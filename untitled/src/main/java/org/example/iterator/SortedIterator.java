package org.example.iterator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.example.model.MediaFile;

public class SortedIterator implements Iterator<MediaFile> {
    private final Iterator<MediaFile> iterator;

    public SortedIterator(List<MediaFile> mediaFiles, Comparator<MediaFile> comparator) {
        List<MediaFile> sortedList = new ArrayList<>(mediaFiles);
        sortedList.sort(comparator);
        this.iterator = sortedList.iterator();
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
