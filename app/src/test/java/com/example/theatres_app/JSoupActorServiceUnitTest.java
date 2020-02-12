package com.example.theatres_app;

import com.example.theatres_app.service.JSoupActorService;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class JSoupActorServiceUnitTest {
    @Test
    public void get_dram_actors_isCorrect() throws IOException {
        assertNotEquals(0,JSoupActorService.getDramaTheaterActorsList(
                JSoupActorService.goToHref("https://kirovdramteatr.ru/truppa/")).size());
    }

}
