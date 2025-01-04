package dev.sohaib;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public Song findSong(String title) {
        for (Song song: songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if (index >= 0 && index < songs.size()) {
            Song songToAdd = songs.get(index);
            if (!playlist.contains(songs.get(index))) {
                playlist.add(songs.get(index));
                return true;
            }
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        if (findSong(title) != null) {
            if (!playlist.contains(findSong(title))) {
                playlist.add(findSong(title));
                return true;
            }
        }
        return false;
    }
}
