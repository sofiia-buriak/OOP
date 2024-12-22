package org.example;

class MediaFile {
    private final String name;
    private final MediaType type;
    private final int size;
    private final String date;

    public MediaFile(String name, MediaType type, int size, String date) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public MediaType getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public String getDate() {
        return date;
    }
}