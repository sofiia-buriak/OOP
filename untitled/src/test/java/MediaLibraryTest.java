import static org.junit.Assert.*;
import org.junit.Test;

import org.example.MediaFile;
import org.example.MediaLibrary;
import org.example.MediaType;

import java.util.Iterator;

public class MediaLibraryTest {
    @Test
    public void testAddMediaAndFilterIterator() {
        MediaLibrary library = new MediaLibrary();

        library.addMedia(new MediaFile("song.mp3", MediaType.AUDIO, 1024, "2024-12-01"));
        library.addMedia(new MediaFile("movie.mp4", MediaType.VIDEO, 20480, "2024-12-02"));

        Iterator<MediaFile> iterator = library.iterator(file -> file.getType() == MediaType.AUDIO);

        assertTrue(iterator.hasNext());
        assertEquals("song.mp3", iterator.next().getName());
        assertFalse(iterator.hasNext()); 
    }
}
