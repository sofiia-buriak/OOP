import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.MediaFile;
import com.example.MediaFileProxy;
import com.example.MediaIterator;
import com.example.MediaLibrary;
import com.example.MediaType;

import static org.junit.jupiter.api.Assertions.*;

public class MediaFileProxyTest {

    private MediaLibrary mediaLibrary;
    private MediaFileProxy mediaFileProxy;

    @BeforeEach
    public void setUp() {
        mediaLibrary = new MediaLibrary();
        mediaLibrary.addMedia(new MediaFile("video1.mp4", MediaType.VIDEO));
        mediaLibrary.addMedia(new MediaFile("photo1.jpg", MediaType.PHOTO));
        mediaLibrary.addMedia(new MediaFile("video2.mp4", MediaType.VIDEO));

        mediaFileProxy = new MediaFileProxy(mediaLibrary);
    }

    @Test
    public void testGetIterator() {
        MediaIterator iterator = mediaFileProxy.getIterator(MediaType.VIDEO);
        assertTrue(iterator.hasNext());
        assertEquals("video1.mp4", iterator.next().getName());
        assertTrue(iterator.hasNext());
        assertEquals("video2.mp4", iterator.next().getName());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testCacheUsage() {
        MediaIterator iterator = mediaFileProxy.getIterator(MediaType.VIDEO);
        assertTrue(iterator.hasNext());
        assertEquals("video1.mp4", iterator.next().getName());
        assertTrue(iterator.hasNext());
        assertEquals("video2.mp4", iterator.next().getName());
        assertFalse(iterator.hasNext());

        iterator = mediaFileProxy.getIterator(MediaType.VIDEO);
        assertTrue(iterator.hasNext());
        assertEquals("video1.mp4", iterator.next().getName());
        assertTrue(iterator.hasNext());
        assertEquals("video2.mp4", iterator.next().getName());
        assertFalse(iterator.hasNext());
    }
}