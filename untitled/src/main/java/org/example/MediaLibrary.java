package com.example;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.Comparator;

public class MediaLibrary {
    public void addMedia(MediaFile file) {
    }

    public Iterator<MediaFile> iterator(Predicate<MediaFile> filter) {
        return null; 
    }

    public Iterator<MediaFile> sortedIterator(Comparator<MediaFile> comparator) {
        return null;
    }


    public List<MediaFile> search(Predicate<MediaFile> filter) {
        return null; 
    }

    public void removeMedia(Predicate<MediaFile> filter) {
    }
}

