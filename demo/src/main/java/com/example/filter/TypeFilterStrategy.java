package com.example.filter;

import java.util.List;
import java.util.stream.Collectors;

import com.example.model.MediaFile;
import com.example.model.MediaType;

public class TypeFilterStrategy implements MediaFilterStrategy {
    @Override
    public List<MediaFile> filter(List<MediaFile> mediaFiles, MediaType type) {
        return mediaFiles.stream()
                .filter(media -> media.getType() == type)
                .collect(Collectors.toList());
    }
}
