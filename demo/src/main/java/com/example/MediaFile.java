package com.example;

public class MediaFile {
    private String name;
    private MediaType type;

    public MediaFile(String name, MediaType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public MediaType getType() {
        return type;
    }
}