package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MediaLibrary {
    private List<MediaFile> mediaFiles = new ArrayList<>();

    public void addMedia(MediaFile mediaFile) {
        mediaFiles.add(mediaFile);
    }

    public List<MediaFile> getAllMedia() {
        return mediaFiles;
    }

    public List<MediaFile> getMediaByType(MediaType type) {
        return mediaFiles.stream()
                .filter(media -> media.getType() == type)
                .collect(Collectors.toList());
    }
}