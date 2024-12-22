package org.example;

public abstract class MediaFile {
    private final String name;
    private final int size;
    private final String date;

    public MediaFile(String name, int size, String date) {
        this.name = name;
        this.size = size;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getDate() {
        return date;
    }

    public abstract MediaType getType();
}