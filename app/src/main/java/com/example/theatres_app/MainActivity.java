package com.example.theatres_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.theatres_app.model.Theater;

public class MainActivity extends AppCompatActivity {

    String[] theaterName;
    String[] theaterAddress;
    String[] theaterVk;
    String[] theaterSite;
    String[] theaterTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theaterName = getResources().getStringArray(R.array.theater_names);
        theaterAddress = getResources().getStringArray(R.array.theater_address);
        theaterVk = getResources().getStringArray(R.array.theater_vk);
        theaterSite = getResources().getStringArray(R.array.theater_site);
        theaterTel = getResources().getStringArray(R.array.theater_tel);
    }

    public void onCardClick(View view) {


        Intent intent = new Intent(getApplicationContext(), TheaterActivity.class);
        int number = (view.getId()==R.id.theaterTUZ)? 0: (view.getId()==R.id.theaterDrama)?1:2;
        Theater theater = getTheaterByNum(number);
        intent.putExtra("theater", theater);


        startActivity(intent);
    }
    private Theater getTheaterByNum(int num){
        Theater theater = (num==0)? getTUZ():
                (num==1)? getDram():
                        getDol();
        //создание элемента Theater theater с помощью конструктора
        int id = (num==0)?R.drawable.tuz_image:(num==1)? R.drawable.drama_image:R.drawable.dolls_image;
        theater.setImageId(id);
        return theater;
    }
    private Theater getTUZ(){
        return new Theater(
                getResources().getString(R.string.theaterTUZ_name),
                getResources().getString(R.string.theaterTUZ_address),
                getResources().getString(R.string.theaterTUZ_site),
                getResources().getString(R.string.theaterTUZ_vk),
                getResources().getString(R.string.theaterTUZ_tel));
    }
    private Theater getDram(){
        return new Theater(
                getResources().getString(R.string.theaterDrama_name),
                getResources().getString(R.string.theaterDrama_address),
                getResources().getString(R.string.theaterDrama_site),
                getResources().getString(R.string.theaterDrama_vk),
                getResources().getString(R.string.theaterDrama_tel));
    }
    private Theater getDol(){
        return new Theater(
                getResources().getString(R.string.theaterDol_name),
                getResources().getString(R.string.theaterDol_address),
                getResources().getString(R.string.theaterDol_site),
                getResources().getString(R.string.theaterDol_vk),
                getResources().getString(R.string.theaterDol_tel));
    }
}
