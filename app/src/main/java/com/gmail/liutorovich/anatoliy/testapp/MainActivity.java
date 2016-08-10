package com.gmail.liutorovich.anatoliy.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList images = prepareData();
        DataAdapter adapter = new DataAdapter(this, getApplicationContext(),images);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList prepareData(){

        ArrayList image = new ArrayList<>();
        for(int i=0;i<image_urls.length;i++){
            image.add(image_urls[i]);
        }
        return image;
    }

    private final String image_urls[] = {
            "http://content2.onliner.by/catalog/device/main/3a5d75d72132fae1c54f9ea7a64f7cba.jpg",
            "http://content2.onliner.by/catalog/device/main/2977c2cdde044b5ed67913a68833d65c.jpg",
            "http://content2.onliner.by/catalog/device/main/bb9e07dd93127a60884186801b84498e.jpeg",
            "http://content2.onliner.by/catalog/device/main/27a56f53744ad1e52fe8f223718c7928.jpg",
            "http://content2.onliner.by/catalog/device/main/662c15455e4dbe38e28eb3c6bc31d158.jpg",
            "http://active.shop.by/pics/items/Apple_iPhone_4_16Gb_a.jpg",
            "http://cs630727.vk.me/v630727180/230cf/5TRPdtj_YpE.jpg",
            "http://fishki.net/picsw/112012/12/post/priroda/priroda-0002.jpg",
            "http://katyaburg.ru/sites/default/files/pictures/krasota_prirody/priroda_letom_foto_kartinki_10.jpg",
            "http://fb.ru/misc/i/gallery/28685/694036.jpg",
            "http://pixelbrush.ru/uploads/posts/2012-10/1350546323_gcnhtiudjfk5d7h.jpeg",
            "http://www.proavtogid.ru/wp-content/uploads/2010/11/bmw6-2.jpg",
            "http://mercedes-e-class.ru/images/mercedes-benz-e-coupe-2.jpg",
            "http://avtoliker.com/_nw/1/01393191.jpg",
            "https://img.championat.com/news/big/a/y/v-chjom-lebron-silnee-dzhordana_1376997501235851347_g.jpg",
            "http://www.ua-sport.org/uploads/posts/2016-04/14606160401kobe.jpeg",
            "http://i121.photobucket.com/albums/o219/arkanthill/nba/lebron_vs_kobe.jpg",
            "https://img.championat.com/news/big/e/a/grom-v-raju_1330594525420396761_g.jpg",
            "https://img.championat.com/news/big/q/s/1287910986128608690foto.jpg",
            "http://www.nbasports.ru/wp-content/uploads/2013/08/kubok.jpg"
    };
}
