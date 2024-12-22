package org.example;

public class ImageFile extends MediaFile {
    public ImageFile(String name, int size, String date) {
        super(name, size, date);
    }

    @Override
    public MediaType getType() {
        return MediaType.IMAGE;
    }
}