package com.example.theatres_app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theatres_app.R;
import com.example.theatres_app.model.Actor;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {
    private ArrayList<Actor> actorList;

    public ActorAdapter(ArrayList<Actor> actors) {
        this.actorList = actors;
    }

    class ActorViewHolder extends RecyclerView.ViewHolder{
        ImageView actorImageView;
        TextView actorNameTextView;
        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);
            actorImageView = itemView.findViewById(R.id.table_actor_image_view);
            actorNameTextView = itemView.findViewById(R.id.table_actor_name_text_view);
        }
        public void bind(Actor actor) {
            actorNameTextView.setText(actor.getName());
            String actorPhotoUrl = actor.getImgUrl();
            Picasso.with(itemView.getContext())
                    .load(actorPhotoUrl)
                    .resize(500, 500)
                    .centerInside()
                    .into(actorImageView);
            actorImageView.setVisibility(actorPhotoUrl != null ? View.VISIBLE : View.GONE);
        }

    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.actor_table_item, parent, false);
        return new ActorAdapter.ActorViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
        holder.bind(actorList.get(position));
    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }

}
