package com.example.theatres_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.example.theatres_app.R;
import com.example.theatres_app.adapter.ActorAdapter;
import com.example.theatres_app.model.Actor;
import com.example.theatres_app.model.Theater;
import com.example.theatres_app.service.JSoupActorService;
import com.example.theatres_app.service.JSoupService;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class ActorsActivity extends AppCompatActivity {
    TextView toolbarTextView;
    RecyclerView actorRecyclerView;
    ActorAdapter actorAdapter;
    ArrayList<Actor> actors;
    Theater theater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        actors = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);


        toolbarTextView = findViewById(R.id.toolbar_text_view);
        actorRecyclerView = findViewById(R.id.actors_recycler_view);

        Bundle intent = getIntent().getExtras();
        assert intent != null;
        theater = (Theater) intent.getSerializable("theater");



        ActorsTask task = new ActorsTask(this);
        task.execute();


    }
    class ActorsTask extends AsyncTask<Void, Void, Void>{

        private ActorsActivity actorsActivity;
        public ActorsTask(ActorsActivity actorsActivity) {
            this.actorsActivity = actorsActivity;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document= JSoupService.goToHref(theater.getTroupeUrl());
                actors = JSoupActorService.getActorsList(document);

                System.out.println("Actors all: " + actors.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            actorAdapter = new ActorAdapter(actors);
            actorRecyclerView.setLayoutManager(new GridLayoutManager(actorsActivity,2));
            actorRecyclerView.setAdapter(actorAdapter);
        }
    }
}
