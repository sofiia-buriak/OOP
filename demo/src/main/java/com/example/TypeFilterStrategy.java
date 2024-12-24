package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class TypeFilterStrategy implements MediaFilterStrategy {
    @Override
    public List<MediaFile> filter(List<MediaFile> mediaFiles, MediaType type) {
        return mediaFiles.stream()
                .filter(media -> media.getType() == type)
                .collect(Collectors.toList());
    }
}
