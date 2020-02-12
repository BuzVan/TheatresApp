package com.example.theatres_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.theatres_app.R;
import com.example.theatres_app.model.Theater;

public class TheaterActivity extends AppCompatActivity {

    private Theater theater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle intent = getIntent().getExtras();
        assert intent != null;
        theater = (Theater) intent.getSerializable("theater");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater);

        ImageView theaterImageView = findViewById(R.id.theater_image_view_details);
        theaterImageView.setImageResource(theater.getImageId());

        TextView theaterNameTextView = findViewById(R.id.theater_name_text_view_details);
        theaterNameTextView.setText(theater.getName());

        TextView theaterVKTextView = findViewById(R.id.theater_vk_text_view);
        theaterVKTextView.setText(theater.getVk());

        TextView theaterSiteTextView = findViewById(R.id.theater_site_text_view);
        theaterSiteTextView.setText(theater.getSite());

        TextView theaterTelTextView = findViewById(R.id.theater_tel_text_view);
        theaterTelTextView.setText(theater.getTel());

        TextView theaterAddressTextView = findViewById(R.id.theater_address_text_view);
        theaterAddressTextView.setText(theater.getAddress());
    }

    public void TroupeButtonClick(View view) {

        Intent intent = new Intent(getApplicationContext(), ActorsActivity.class);
        intent.putExtra("theater", theater);


        startActivity(intent);
    }
}
