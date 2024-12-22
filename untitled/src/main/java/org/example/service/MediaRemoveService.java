package org.example.service;

import java.util.List;
import java.util.function.Predicate;

import org.example.model.MediaFile;

public class MediaRemoveService implements RemoveService {
    @Override
    public void remove(List<MediaFile> mediaFiles, Predicate<MediaFile> filter) {
        mediaFiles.removeIf(filter);
    }
}