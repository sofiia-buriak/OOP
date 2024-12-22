import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.MediaFile;
import org.example.MediaLibrary;
import org.example.MediaType;

import java.util.Iterator;
import java.util.List;

public class MediaLibraryTest {

    private MediaLibrary library;

    @BeforeEach
    public void setUp() {
        library = new MediaLibrary();
        library.addMedia(new MediaFile("song.mp3", MediaType.AUDIO, 1024, "2024-12-01"));
        library.addMedia(new MediaFile("movie.mp4", MediaType.VIDEO, 20480, "2024-12-02"));
        library.addMedia(new MediaFile("picture.jpg", MediaType.IMAGE, 512, "2024-12-03"));
        library.addMedia(new MediaFile("podcast.mp3", MediaType.AUDIO, 2048, "2024-12-04"));
    }

    @Test
    public void testIteratorWithFilter() {
        Iterator<MediaFile> audioIterator = library.iterator(file -> file.getType() == MediaType.AUDIO);
        assertTrue(audioIterator.hasNext());
        assertEquals("song.mp3", audioIterator.next().getName());
        assertEquals("podcast.mp3", audioIterator.next().getName());
        assertFalse(audioIterator.hasNext());
    }

    @Test
    public void testSortedIterator() {
        Iterator<MediaFile> sortedIterator = library.sortedIterator((f1, f2) -> Integer.compare(f1.getSize(), f2.getSize()));
        assertTrue(sortedIterator.hasNext());
        assertEquals("picture.jpg", sortedIterator.next().getName());
        assertEquals("song.mp3", sortedIterator.next().getName());
        assertEquals("podcast.mp3", sortedIterator.next().getName());
        assertEquals("movie.mp4", sortedIterator.next().getName());
        assertFalse(sortedIterator.hasNext());
    }

    @Test
    public void testSearch() {
        List<MediaFile> results = library.search(file -> file.getName().contains(".mp3"));
        assertEquals(2, results.size());
        assertTrue(results.stream().anyMatch(file -> file.getName().equals("song.mp3")));
        assertTrue(results.stream().anyMatch(file -> file.getName().equals("podcast.mp3")));
    }

    @Test
    public void testRemoveMedia() {
        library.removeMedia(file -> file.getType() == MediaType.IMAGE);
        List<MediaFile> remainingFiles = library.search(file -> true);
        assertEquals(3, remainingFiles.size());
        assertFalse(remainingFiles.stream().anyMatch(file -> file.getName().equals("picture.jpg")));
    }
}

