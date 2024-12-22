package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

class MediaLibrary {
    private final List<MediaFile> mediaFiles = new ArrayList<>();

    public void addMedia(MediaFile file) {
        mediaFiles.add(file);
    }

    public Iterator<MediaFile> iterator(Predicate<MediaFile> filter) {
        return mediaFiles.stream().filter(filter).iterator();
    }

    public Iterator<MediaFile> sortedIterator(Comparator<MediaFile> comparator) {
        List<MediaFile> sortedList = new ArrayList<>(mediaFiles);
        sortedList.sort(comparator);
        return sortedList.iterator();
    }

    public List<MediaFile> search(Predicate<MediaFile> filter) {
        return mediaFiles.stream().filter(filter).collect(Collectors.toList());
    }

    public void removeMedia(Predicate<MediaFile> filter) {
        mediaFiles.removeIf(filter);
    }
}