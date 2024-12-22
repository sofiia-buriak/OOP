package org.example.library;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.example.iterator.FilteredIterator;
import org.example.iterator.SortedIterator;
import org.example.model.MediaFile;
import org.example.service.RemoveService;
import org.example.service.SearchService;

import java.util.ArrayList;
import java.util.Comparator;

public class MediaLibrary implements MediaLibraryInterface {
    private final List<MediaFile> mediaFiles = new ArrayList<>();
    private final SearchService searchService;
    private final RemoveService removeService;

    public MediaLibrary(SearchService searchService, RemoveService removeService) {
        this.searchService = searchService;
        this.removeService = removeService;
    }

    @Override
    public void addMedia(MediaFile file) {
        mediaFiles.add(file);
    }

    @Override
    public Iterator<MediaFile> iterator(Predicate<MediaFile> filter) {
        return new FilteredIterator(mediaFiles, filter);
    }

    @Override
    public Iterator<MediaFile> sortedIterator(Comparator<MediaFile> comparator) {
        return new SortedIterator(mediaFiles, comparator);
    }


    @Override
    public List<MediaFile> search(Predicate<MediaFile> filter) {
        return searchService.search(mediaFiles, filter);
    }

    @Override
    public void removeMedia(Predicate<MediaFile> filter) {
        removeService.remove(mediaFiles, filter);
    }
}
