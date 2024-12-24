import org.junit.jupiter.api.Test;

import com.example.MediaFile;
import com.example.MediaFileProxy;
import com.example.MediaIterator;
import com.example.MediaLibrary;
import com.example.MediaType;

import static org.junit.jupiter.api.Assertions.*;

public class MediaLibraryDemoTest {

    @Test
    public void testVideoIterator() {
        MediaLibrary library = new MediaLibrary();
        library.addMedia(new MediaFile("video1.mp4", MediaType.VIDEO));
        library.addMedia(new MediaFile("photo1.jpg", MediaType.PHOTO));
        library.addMedia(new MediaFile("audio1.mp3", MediaType.AUDIO));
        library.addMedia(new MediaFile("video2.mp4", MediaType.VIDEO));

        MediaFileProxy proxy = new MediaFileProxy(library);
        MediaIterator iterator = proxy.getIterator(MediaType.VIDEO);

        assertTrue(iterator.hasNext());
        assertEquals("video1.mp4", iterator.next().getName());
        assertTrue(iterator.hasNext());
        assertEquals("video2.mp4", iterator.next().getName());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testCacheUsage() {
        MediaLibrary library = new MediaLibrary();
        library.addMedia(new MediaFile("video1.mp4", MediaType.VIDEO));
        library.addMedia(new MediaFile("photo1.jpg", MediaType.PHOTO));
        library.addMedia(new MediaFile("audio1.mp3", MediaType.AUDIO));
        library.addMedia(new MediaFile("video2.mp4", MediaType.VIDEO));

        MediaFileProxy proxy = new MediaFileProxy(library);

        MediaIterator iterator = proxy.getIterator(MediaType.VIDEO);
        assertTrue(iterator.hasNext());
        assertEquals("video1.mp4", iterator.next().getName());
        assertTrue(iterator.hasNext());
        assertEquals("video2.mp4", iterator.next().getName());
        assertFalse(iterator.hasNext());

        iterator = proxy.getIterator(MediaType.VIDEO);
        assertTrue(iterator.hasNext());
        assertEquals("video1.mp4", iterator.next().getName());
        assertTrue(iterator.hasNext());
        assertEquals("video2.mp4", iterator.next().getName());
        assertFalse(iterator.hasNext());
    }
}
