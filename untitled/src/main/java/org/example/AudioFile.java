package org.example;

public class AudioFile extends MediaFile {
    public AudioFile(String name, int size, String date) {
        super(name, size, date);
    }

    @Override
    public MediaType getType() {
        return MediaType.AUDIO;
    }
}