package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class MediaFilter {
    public List<MediaFile> filterByType(List<MediaFile> mediaFiles, MediaType type) {
        return mediaFiles.stream()
                .filter(media -> media.getType() == type)
                .collect(Collectors.toList());
    }
}
