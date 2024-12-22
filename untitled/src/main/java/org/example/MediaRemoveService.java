package org.example;

import java.util.List;
import java.util.function.Predicate;

public class MediaRemoveService implements RemoveService {
    @Override
    public void remove(List<MediaFile> mediaFiles, Predicate<MediaFile> filter) {
        mediaFiles.removeIf(filter);
    }
}