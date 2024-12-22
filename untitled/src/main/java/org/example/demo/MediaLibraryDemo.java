package org.example.demo;

import org.example.enums.MediaType;
import org.example.library.MediaLibrary;
import org.example.library.MediaLibraryProxy;
import org.example.model.AudioFile;
import org.example.model.ImageFile;
import org.example.model.MediaFile;
import org.example.model.VideoFile;
import org.example.service.MediaRemoveService;
import org.example.service.MediaSearchService;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MediaLibraryDemo {
    public static void main(String[] args) {

        MediaLibrary realLibrary = new MediaLibrary(new MediaSearchService(), new MediaRemoveService());
        MediaLibraryProxy proxyLibrary = new MediaLibraryProxy(realLibrary);

        proxyLibrary.addMedia(new AudioFile("song.mp3", 1024, "2024-12-01"));
        proxyLibrary.addMedia(new VideoFile("movie.mp4", 20480, "2024-12-02"));
        proxyLibrary.addMedia(new ImageFile("picture.jpg", 512, "2024-12-03"));
        proxyLibrary.addMedia(new AudioFile("podcast.mp3", 2048, "2024-12-04"));

        System.out.println("\nПошук файлу з іменем 'movie.mp4':");
        List<MediaFile> searchResults = proxyLibrary.search(file -> file.getName().equals("movie.mp4"));
        for (MediaFile file : searchResults) {
            System.out.println("Знайдено: " + file.getName());
        }

        System.out.println("\nПовторний пошук файлу з іменем 'movie.mp4':");
        searchResults = proxyLibrary.search(file -> file.getName().equals("movie.mp4"));
        for (MediaFile file : searchResults) {
            System.out.println("Знайдено: " + file.getName());
        }

        System.out.println("\nВидалення файлів типу IMAGE...");
        proxyLibrary.removeMedia(file -> file.getType() == MediaType.IMAGE);

        System.out.println("\nПошук файлу з іменем 'movie.mp4' після видалення IMAGE:");
        searchResults = proxyLibrary.search(file -> file.getName().equals("movie.mp4"));
        for (MediaFile file : searchResults) {
            System.out.println("Знайдено: " + file.getName());
        }

        System.out.println("\nФільтрація медіафайлів за розміром більше 1000:");
        Iterator<MediaFile> filteredIterator = proxyLibrary.iterator(file -> file.getSize() > 1000);
        while (filteredIterator.hasNext()) {
            MediaFile file = filteredIterator.next();
            System.out.println("Фільтрований файл: " + file.getName() + " (Розмір: " + file.getSize() + ")");
        }

        System.out.println("\nСортування медіафайлів за іменем:");
        Iterator<MediaFile> sortedIterator = proxyLibrary.sortedIterator(Comparator.comparing(MediaFile::getName));
        while (sortedIterator.hasNext()) {
            MediaFile file = sortedIterator.next();
            System.out.println("Відсортований файл: " + file.getName());
        }

        System.out.println("\nСортування медіафайлів за розміром у зворотному порядку:");
        sortedIterator = proxyLibrary.sortedIterator(Comparator.comparing(MediaFile::getSize).reversed());
        while (sortedIterator.hasNext()) {
            MediaFile file = sortedIterator.next();
            System.out.println("Відсортований файл: " + file.getName() + " (Розмір: " + file.getSize() + ")");
        }
    }
}