package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class TypeFilterStrategy implements MediaFilterStrategy {
    private MediaType type;

    public TypeFilterStrategy(MediaType type) {
        this.type = type;
    }

    @Override
    public List<MediaFile> filter(List<MediaFile> mediaFiles) {
        return mediaFiles.stream()
                .filter(media -> media.getType() == type)
                .collect(Collectors.toList());
    }
}
