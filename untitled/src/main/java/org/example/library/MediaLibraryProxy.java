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
        System.out.println("Проксі: Додавання медіафайлу: " + file.getName());
        realLibrary.addMedia(file);
    }

    @Override
    public Iterator<MediaFile> iterator(Predicate<MediaFile> filter) {
        System.out.println("Проксі: Фільтрація медіафайлів за предикатом: " + filter);
        return realLibrary.iterator(filter);
    }

    @Override
    public Iterator<MediaFile> sortedIterator(Comparator<MediaFile> comparator) {
        System.out.println("Проксі: Сортування медіафайлів за компаратором: " + comparator);
        return realLibrary.sortedIterator(comparator);
    }

    @Override
    public List<MediaFile> search(Predicate<MediaFile> filter) {
        System.out.println("Проксі: Пошук медіафайлів за предикатом: " + filter);
        return realLibrary.search(filter);
    }

    @Override
    public void removeMedia(Predicate<MediaFile> filter) {
        System.out.println("Проксі: Видалення медіафайлів за предикатом: " + filter);
        realLibrary.removeMedia(filter);
    }
}