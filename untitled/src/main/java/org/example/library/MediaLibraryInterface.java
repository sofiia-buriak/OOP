package org.example.library;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.example.model.MediaFile;

public interface MediaLibraryInterface {
    void addMedia(MediaFile file);
    Iterator<MediaFile> iterator(Predicate<MediaFile> filter);
    Iterator<MediaFile> sortedIterator(Comparator<MediaFile> comparator);
    List<MediaFile> search(Predicate<MediaFile> filter);
    void removeMedia(Predicate<MediaFile> filter);
}
