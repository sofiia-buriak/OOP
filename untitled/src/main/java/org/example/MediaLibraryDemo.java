package org.example;

import java.util.Iterator;
import java.util.List;

public class MediaLibraryDemo {
    public static void main(String[] args) {
        MediaLibrary library = new MediaLibrary();

        library.addMedia(new MediaFile("song.mp3", MediaType.AUDIO, 1024, "2024-12-01"));
        library.addMedia(new MediaFile("movie.mp4", MediaType.VIDEO, 20480, "2024-12-02"));
        library.addMedia(new MediaFile("picture.jpg", MediaType.IMAGE, 512, "2024-12-03"));

        System.out.println("Файли типу AUDIO:");
        Iterator<MediaFile> iterator = library.iterator(file -> file.getType() == MediaType.AUDIO);
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }

        System.out.println("\nФайли, відсортовані за розміром:");
        Iterator<MediaFile> sortedIterator = library.sortedIterator((f1, f2) -> Integer.compare(f1.getSize(), f2.getSize()));
        while (sortedIterator.hasNext()) {
            System.out.println(sortedIterator.next().getName());
        }

        System.out.println("\nПошук файлу з іменем 'movie.mp4':");
        List<MediaFile> searchResults = library.search(file -> file.getName().equals("movie.mp4"));
        for (MediaFile file : searchResults) {
            System.out.println("Знайдено: " + file.getName());
        }

        System.out.println("\nВидалення файлів типу IMAGE...");
        library.removeMedia(file -> file.getType() == MediaType.IMAGE);

        System.out.println("Файли після видалення:");
        iterator = library.iterator(file -> true);
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }
}
