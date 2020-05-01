package com.example.dede_s_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private ArrayList<String> fotoMahasiswa = new ArrayList<>();
    private ArrayList<String> namaMahasiswa = new ArrayList<>();
    private ArrayList<String> infoMahasiswa = new ArrayList<>();
    private ArrayList<String> kelasMahasiswa = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<String> fotoMahasiswa, ArrayList<String> namaMahasiswa, ArrayList<String> infoMahasiswa, ArrayList<String> kelasMahasiswa, Context context) {
        this.fotoMahasiswa = fotoMahasiswa;
        this.namaMahasiswa = namaMahasiswa;
        this.infoMahasiswa = infoMahasiswa;
        this.kelasMahasiswa = kelasMahasiswa;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.desain_layout_adapter, parent, false);
        ViewHolder holder = new ViewHolder(view);



        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(context).asBitmap().load(fotoMahasiswa.get(position)).into(holder.imageView);
        holder.textView.setText(namaMahasiswa.get(position));



        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, namamahasiswa.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context,DetailActivity.class);

                intent.putExtra("foto_Mahasiswa", fotoMahasiswa.get(position));
                intent.putExtra("nama_Mahasiswa", namaMahasiswa.get(position));
                intent.putExtra("info_Mahasiswa", infoMahasiswa.get(position));
                intent.putExtra("kelas_Mahasiswa", kelasMahasiswa.get(position));

                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return namaMahasiswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        CircleImageView imageView;
        TextView textView;




        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);



            constraintLayout = itemView.findViewById(R.id.constrainLayout);
        }
    }

}
