package iterator;

import org.example.iterator.SortedIterator;
import org.example.model.AudioFile;
import org.example.model.MediaFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortedIteratorTest {

    private List<MediaFile> mediaFiles;

    @BeforeEach
    public void setUp() {
        mediaFiles = Arrays.asList(
                new AudioFile("song.mp3", 2048, "2024-12-01"),
                new AudioFile("podcast.mp3", 1024, "2024-12-04")
        );
    }

    @Test
    public void testSortedIterator() {
        SortedIterator iterator = new SortedIterator(mediaFiles, (f1, f2) -> Integer.compare(f1.getSize(), f2.getSize()));
        assertTrue(iterator.hasNext());
        assertEquals("podcast.mp3", iterator.next().getName());
        assertEquals("song.mp3", iterator.next().getName());
        assertFalse(iterator.hasNext());
    }
}
