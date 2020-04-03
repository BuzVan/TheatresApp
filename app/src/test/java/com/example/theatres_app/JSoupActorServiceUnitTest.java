package com.example.theatres_app;

import com.example.theatres_app.model.Actor;
import com.example.theatres_app.service.JSoupActorService;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class JSoupActorServiceUnitTest {
    @Test
    public void get_dram_actors_isCorrect() throws IOException {
        assertNotEquals(0,JSoupActorService.getDramaTheaterActorsList(
                JSoupActorService.goToHref("https://kirovdramteatr.ru/truppa/")).size());
    }
    @Test
    public void get_tuz_actors_isCorrect() throws IOException {
        ArrayList<Actor> actors =JSoupActorService.getTUZTheaterActorsList(
                JSoupActorService.goToHref("https://ekvus-kirov.ru/truppa/"));
        assertNotNull(actors);
        for (Actor actor:
             actors) {
            assertNotNull(actor.getImgUrl());
            assertNotNull(actor.getName());
        }
    }

}
