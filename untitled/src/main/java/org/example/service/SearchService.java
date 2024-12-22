package org.example.service;

import java.util.List;

import java.util.function.Predicate;

import org.example.model.MediaFile;

public interface SearchService {
    List<MediaFile> search(List<MediaFile> mediaFiles, Predicate<MediaFile> filter);
}