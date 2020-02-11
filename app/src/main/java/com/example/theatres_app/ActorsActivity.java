package com.example.theatres_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.theatres_app.adapter.ActorAdapter;
import com.example.theatres_app.model.Actor;
import com.example.theatres_app.model.Theater;

import java.util.ArrayList;

public class ActorsActivity extends AppCompatActivity {
    TextView toolbarTextView;
    RecyclerView actorRecyclerView;
    ActorAdapter actorAdapter;
    ArrayList<Actor> actors;
    Theater theater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);

        toolbarTextView = findViewById(R.id.toolbar_text_view);
        actorRecyclerView = findViewById(R.id.actors_recycler_view);

        Bundle intent = getIntent().getExtras();
        assert intent != null;
        theater = (Theater) intent.getSerializable("theater");
        actors = new ArrayList<>(4);
        actors.add(new Actor("Людмила Пашинина","https://sun9-11.userapi.com/c845420/v845420814/158160/FbQiVe2LYH8.jpg?ava=1"));
        actors.add(new Actor("Этож Я","https://sun9-43.userapi.com/c630420/v630420300/4b660/OV_3vCjcXKY.jpg?ava=1"));
        actors.add(new Actor("Таяна Аввакумушкина","https://sun9-67.userapi.com/c858436/v858436904/fd82a/taLqGRj5umA.jpg"));
        actors.add(new Actor("Соседский сосед","https://sun9-61.userapi.com/c849236/v849236145/1834ea/vcxfqiSLcso.jpg"));
        actorAdapter = new ActorAdapter(actors);
        //TODO не уверен сколько актеров в строке - 1 или 2
        actorRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        actorRecyclerView.setAdapter(actorAdapter);


    }
}
