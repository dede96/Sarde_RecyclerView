package com.example.dede_s_recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> fotoMahasiswa = new ArrayList<>();
    private ArrayList<String> namaMahasiswa = new ArrayList<>();
    private ArrayList<String> infoMahasiswa = new ArrayList<>();
    private ArrayList<String> kelasMahasiswa = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataFromInternet();
    }

    private void prosesRecyclerViewAdapter(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(fotoMahasiswa, namaMahasiswa, infoMahasiswa, kelasMahasiswa, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
    private  void getDataFromInternet(){

        namaMahasiswa.add("Dede Setiawan");
        fotoMahasiswa.add("data:image/jpeg;base64,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");
        infoMahasiswa.add("Kelas : TI.17.F1");
        kelasMahasiswa.add("Nim : 311710347");

        namaMahasiswa.add("Indri Barbie");
        fotoMahasiswa.add("https://cdns.klimg.com/kapanlagi.com/g/i/n/indri_barbie_pebalap_cantik_seksi_bandung_yang_hebohkan_internet/p/indri_barbie-20141218-008-rita.jpg");
        infoMahasiswa.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        kelasMahasiswa.add("24");

        namaMahasiswa.add("Tarn Softhip");
        fotoMahasiswa.add("https://scontent-atl3-1.cdninstagram.com/v/t51.2885-15/sh0.08/e35/c0.170.1366.1366a/s640x640/88197175_209764003612340_1313120067404596830_n.jpg?_nc_ht=scontent-atl3-1.cdninstagram.com&_nc_cat=108&_nc_ohc=-m8HJwYnDQAAX8yF58g&oh=46fecd3fd9103a69e389dfc4f96012f4&oe=5EAFB837");
        infoMahasiswa.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        kelasMahasiswa.add("20");

        namaMahasiswa.add("Synyister Gates");
        fotoMahasiswa.add("https://i.pinimg.com/originals/79/2f/4c/792f4cbf3250ebda4279213042a57da5.jpg");
        infoMahasiswa.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        kelasMahasiswa.add("28");

        namaMahasiswa.add("Jerinx");
        fotoMahasiswa.add("https://asset-a.grid.id/crop/0x0:0x0/360x240/photo/haifoto/original/75734_jerinx-sid.jpg");
        infoMahasiswa.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        kelasMahasiswa.add("31");

        namaMahasiswa.add("Vino G Bastian");
        fotoMahasiswa.add("https://cdn.idntimes.com/content-images/community/2019/08/picsart-08-15-081754-de51fbb0fb39b48b3f91678c786a6a6d_600x400.jpg");
        infoMahasiswa.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        kelasMahasiswa.add("27");

        namaMahasiswa.add("Chesster Benington");
        fotoMahasiswa.add("https://awsimages.detik.net.id/community/media/visual/2017/07/21/5b945349-869c-416f-92e6-a6af73d5cca6.jpg?w=900&q=70");
        infoMahasiswa.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        kelasMahasiswa.add("26");



        prosesRecyclerViewAdapter();

    }
}
