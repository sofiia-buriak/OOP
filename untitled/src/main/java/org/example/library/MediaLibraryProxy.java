package org.example.library;

import org.example.model.MediaFile;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class MediaLibraryProxy implements MediaLibraryInterface {
    private final MediaLibrary realLibrary;

    public MediaLibraryProxy(MediaLibrary realLibrary) {
        this.realLibrary = realLibrary;
    }

    @Override
    public void addMedia(MediaFile file) {

    }

    @Override
    public Iterator<MediaFile> iterator(Predicate<MediaFile> filter) {
        return null;
    }

    @Override
    public Iterator<MediaFile> sortedIterator(Comparator<MediaFile> comparator) {
        return null;
    }

    @Override
    public List<MediaFile> search(Predicate<MediaFile> filter) {
        return null; 
    }

    @Override
    public void removeMedia(Predicate<MediaFile> filter) {
    }
}