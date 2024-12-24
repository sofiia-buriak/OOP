import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.MediaFile;
import com.example.MediaIterator;
import com.example.MediaIteratorImpl;
import com.example.MediaType;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MediaIteratorImplTest {

    private MediaIterator iterator;

    @BeforeEach
    public void setUp() {
        List<MediaFile> mediaFiles = Arrays.asList(
                new MediaFile("video1.mp4", MediaType.VIDEO),
                new MediaFile("video2.mp4", MediaType.VIDEO)
        );
        iterator = new MediaIteratorImpl(mediaFiles);
    }

    @Test
    public void testHasNext() {
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testNext() {
        assertEquals("video1.mp4", iterator.next().getName());
        assertEquals("video2.mp4", iterator.next().getName());
        assertThrows(IndexOutOfBoundsException.class, () -> iterator.next());
    }
}