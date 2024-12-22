package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.Comparator;

public class MediaLibrary implements MediaLibraryInterface {
    private final List<MediaFile> mediaFiles = new ArrayList<>();
    private final SearchService searchService;
    private final SortService sortService;
    private final RemoveService removeService;

    public MediaLibrary(SearchService searchService, SortService sortService, RemoveService removeService) {
        this.searchService = searchService;
        this.sortService = sortService;
        this.removeService = removeService;
    }

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
        return sortService.sort(mediaFiles, comparator).iterator();
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
