package org.example;

public class VideoFile extends MediaFile {
    public VideoFile(String name, int size, String date) {
        super(name, size, date);
    }

    @Override
    public MediaType getType() {
        return MediaType.VIDEO;
    }
}