package org.example;

import java.util.List;

import java.util.function.Predicate;

public interface SearchService {
    List<MediaFile> search(List<MediaFile> mediaFiles, Predicate<MediaFile> filter);
}