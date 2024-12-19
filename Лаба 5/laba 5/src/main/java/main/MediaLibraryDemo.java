package main;

public class MediaLibraryDemo {
    public static void main(String[] args) {
        MediaLibrary library = new MediaLibrary();

        library.addMedia(new MediaFile("song.mp3", MediaType.AUDIO, 1024, "2024-12-01"));
        library.addMedia(new MediaFile("movie.mp4", MediaType.VIDEO, 20480, "2024-12-02"));

        Iterator<MediaFile> iterator = library.iterator(file -> file.getType() == MediaType.AUDIO);
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }
}

