package com.example.theatres_app.service;

import com.example.theatres_app.R;
import com.example.theatres_app.activity.MainActivity;
import com.example.theatres_app.model.Actor;
import com.example.theatres_app.model.Theater;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class JSoupActorService extends JSoupService {
    static final String DRAM_SITE = "https://kirovdramteatr.ru";
    static final String DOLL_SITE = "http://kirovkukla.ru";
    static final String TUZ_SITE = "https://ekvus-kirov.ru";
    public static ArrayList<Actor> getActorsListByTheater(Theater theater, Document doc){
        if (theater.getSite().contains(DRAM_SITE)) return  getDramaTheaterActorsList(doc);
        if (theater.getSite().contains(DOLL_SITE)) return  getDollTheaterActorsList(doc);
        if (theater.getSite().contains(TUZ_SITE)) return  getTUZTheaterActorsList(doc);
        return null;
    }
    public static ArrayList<Actor> getDollTheaterActorsList(Document doc) {
        ArrayList<Actor> actors = new ArrayList<>();
        //TODO
        return actors;
    }
    public static ArrayList<Actor> getTUZTheaterActorsList(Document doc) {
        ArrayList<Actor> actors = new ArrayList<>();
        //TODO
        return actors;
    }
    public static ArrayList<Actor> getDramaTheaterActorsList(Document doc) {

        ArrayList<Actor> actors = new ArrayList<>();
        Element personList = doc.getElementsByClass("t_person_list").first();
        Elements images = personList.getElementsByTag("img");
        for (Element image: images) {
           String imageUrl = DRAM_SITE + image.attributes().get("src");
           String name = image.attr("alt");
           actors.add(new Actor(name, imageUrl));
        }
        return actors;
    }
}
