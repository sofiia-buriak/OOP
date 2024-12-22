package org.example.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.example.model.MediaFile;

public class FilteredIterator implements Iterator<MediaFile> {
    private final Iterator<MediaFile> iterator;

    public FilteredIterator(List<MediaFile> mediaFiles, Predicate<MediaFile> filter) {
        this.iterator = mediaFiles.stream().filter(filter).iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public MediaFile next() {
        return iterator.next();
    }
}
