package com.example.a1kayat34.sqliteapp;

/**
 * Created by 1kayat34 on 20/11/2017.
 */

public class Song {
    String artist;
    String title;
    long year;

    public Song(String artist, String title) {
        this.artist = artist;
        this.title = title;
        this.year = 0;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String setArtist(String artist) {
        this.artist = artist;
        return this.artist;
    }

    public String setTitle(String title) {
        this.title = title;
        return this.title;
    }
}
