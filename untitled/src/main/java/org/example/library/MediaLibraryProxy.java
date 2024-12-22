package org.example.library;

import org.example.model.MediaFile;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class MediaLibraryProxy implements MediaLibraryInterface {
    private final MediaLibrary realLibrary;
    private final Map<String, List<MediaFile>> searchCache = new HashMap<>();

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
        String cacheKey = filter.toString();
        if (searchCache.containsKey(cacheKey)) {
            System.out.println("Проксі: Використовуємо кеш для пошуку за предикатом: " + filter);
            return searchCache.get(cacheKey);
        }

        System.out.println("Проксі: Пошук медіафайлів за предикатом: " + filter);
        List<MediaFile> result = realLibrary.search(filter);
        searchCache.put(cacheKey, result);
        return result;
    }

    @Override
    public void removeMedia(Predicate<MediaFile> filter) {
        System.out.println("Проксі: Видалення медіафайлів за предикатом: " + filter);
        realLibrary.removeMedia(filter);
    }
}