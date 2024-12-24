package com.example.demo;

import com.example.filter.MediaFilterStrategy;
import com.example.filter.TypeFilterStrategy;
import com.example.iterator.MediaIterator;
import com.example.library.MediaLibrary;
import com.example.model.MediaFile;
import com.example.model.MediaType;
import com.example.proxy.MediaFileProxy;

public class MediaLibraryDemo {
    public static void main(String[] args) {
        MediaLibrary library = new MediaLibrary();
        library.addMedia(new MediaFile("video1.mp4", MediaType.VIDEO));
        library.addMedia(new MediaFile("photo1.jpg", MediaType.PHOTO));
        library.addMedia(new MediaFile("audio1.mp3", MediaType.AUDIO));
        library.addMedia(new MediaFile("video2.mp4", MediaType.VIDEO));

        MediaFilterStrategy typeFilter = new TypeFilterStrategy();
        MediaFileProxy proxy = new MediaFileProxy(library, typeFilter);

        System.out.println("Fetching video files (first time - loading from library):");
        MediaIterator iterator = proxy.getIterator(MediaType.VIDEO);
        while (iterator.hasNext()) {
            MediaFile mediaFile = iterator.next();
            System.out.println("Loaded: " + mediaFile.getName());
        }

        System.out.println("\nFetching video files (second time - using cache):");
        iterator = proxy.getIterator(MediaType.VIDEO);
        while (iterator.hasNext()) {
            MediaFile mediaFile = iterator.next();
            System.out.println("Loaded: " + mediaFile.getName());
        }

        System.out.println("\nFetching audio files:");
        iterator = proxy.getIterator(MediaType.AUDIO);
        while (iterator.hasNext()) {
            MediaFile mediaFile = iterator.next();
            System.out.println("Loaded: " + mediaFile.getName());
        }

        System.out.println("\nFetching photo files:");
        iterator = proxy.getIterator(MediaType.PHOTO);
        while (iterator.hasNext()) {
            MediaFile mediaFile = iterator.next();
            System.out.println("Loaded: " + mediaFile.getName());
        }
    }
}