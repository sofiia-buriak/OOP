package org.example.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.example.model.MediaFile;

public class MediaSearchService implements SearchService {
    @Override
    public List<MediaFile> search(List<MediaFile> mediaFiles, Predicate<MediaFile> filter) {
        return mediaFiles.stream().filter(filter).collect(Collectors.toList());
    }
}
