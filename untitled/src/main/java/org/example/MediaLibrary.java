package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

public class MediaLibrary implements MediaLibraryInterface {
    private final List<MediaFile> mediaFiles = new ArrayList<>();

    @Override
    public void addMedia(MediaFile file) {
        mediaFiles.add(file);
    }

    @Override
    public Iterator<MediaFile> iterator(Predicate<MediaFile> filter) {
        return mediaFiles.stream().filter(filter).iterator();
    }

    @Override
    public Iterator<MediaFile> sortedIterator(Comparator<MediaFile> comparator) {
        List<MediaFile> sortedList = new ArrayList<>(mediaFiles);
        sortedList.sort(comparator);
        return sortedList.iterator();
    }

    @Override
    public List<MediaFile> search(Predicate<MediaFile> filter) {
        return mediaFiles.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public void removeMedia(Predicate<MediaFile> filter) {
        mediaFiles.removeIf(filter);
    }
}