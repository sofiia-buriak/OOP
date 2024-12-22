package iterator;

import org.example.enums.MediaType;
import org.example.iterator.FilteredIterator;
import org.example.model.AudioFile;
import org.example.model.MediaFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FilteredIteratorTest {

    private List<MediaFile> mediaFiles;

    @BeforeEach
    public void setUp() {
        mediaFiles = Arrays.asList(
                new AudioFile("song.mp3", 1024, "2024-12-01"),
                new AudioFile("podcast.mp3", 2048, "2024-12-04")
        );
    }

    @Test
    public void testFilteredIterator() {
        FilteredIterator iterator = new FilteredIterator(mediaFiles, file -> file.getType() == MediaType.AUDIO);
        assertTrue(iterator.hasNext());
        assertEquals("song.mp3", iterator.next().getName());
        assertEquals("podcast.mp3", iterator.next().getName());
        assertFalse(iterator.hasNext());
    }
}