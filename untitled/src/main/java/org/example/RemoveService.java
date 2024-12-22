package org.example;

import java.util.List;
import java.util.function.Predicate;

public interface RemoveService {
    void remove(List<MediaFile> mediaFiles, Predicate<MediaFile> filter);
}