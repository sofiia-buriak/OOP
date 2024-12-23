package com.example;

public class MediaLibraryDemo {
    public static void main(String[] args) {
        MediaLibrary library = new MediaLibrary();

        library.addMedia(new MediaFile("video1.mp4", MediaType.VIDEO));
        library.addMedia(new MediaFile("photo1.jpg", MediaType.PHOTO));
        library.addMedia(new MediaFile("audio1.mp3", MediaType.AUDIO));
        library.addMedia(new MediaFile("video2.mp4", MediaType.VIDEO));

        MediaFileProxy proxy = new MediaFileProxy(library);

        MediaIterator iterator = proxy.getIterator(MediaType.VIDEO);

        while (iterator.hasNext()) {
            MediaFile mediaFile = iterator.next();
            System.out.println("Loaded: " + mediaFile.getName());
        }

        System.out.println("\nUsing cache:");
        iterator = proxy.getIterator(MediaType.VIDEO);
        while (iterator.hasNext()) {
            MediaFile mediaFile = iterator.next();
            System.out.println("Loaded: " + mediaFile.getName());
        }
    }
}