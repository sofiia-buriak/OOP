package demo;
import org.junit.jupiter.api.Test;

import com.example.filter.TypeFilterStrategy;
import com.example.iterator.MediaIterator;
import com.example.library.MediaLibrary;
import com.example.model.MediaFile;
import com.example.model.MediaType;
import com.example.proxy.MediaFileProxy;

import static org.junit.jupiter.api.Assertions.*;

public class MediaLibraryDemoTest {

    @Test
    public void testVideoIterator() {
        MediaLibrary library = new MediaLibrary();
        library.addMedia(new MediaFile("video1.mp4", MediaType.VIDEO));
        library.addMedia(new MediaFile("photo1.jpg", MediaType.PHOTO));
        library.addMedia(new MediaFile("audio1.mp3", MediaType.AUDIO));
        library.addMedia(new MediaFile("video2.mp4", MediaType.VIDEO));

        MediaFileProxy proxy = new MediaFileProxy(library, new TypeFilterStrategy());
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

        MediaFileProxy proxy = new MediaFileProxy(library, new TypeFilterStrategy());

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

    @Test
    public void testAudioIterator() {
        MediaLibrary library = new MediaLibrary();
        library.addMedia(new MediaFile("video1.mp4", MediaType.VIDEO));
        library.addMedia(new MediaFile("audio1.mp3", MediaType.AUDIO));
        library.addMedia(new MediaFile("audio2.mp3", MediaType.AUDIO));

        MediaFileProxy proxy = new MediaFileProxy(library, new TypeFilterStrategy());
        MediaIterator iterator = proxy.getIterator(MediaType.AUDIO);

        assertTrue(iterator.hasNext());
        assertEquals("audio1.mp3", iterator.next().getName());
        assertTrue(iterator.hasNext());
        assertEquals("audio2.mp3", iterator.next().getName());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testPhotoIterator() {
        MediaLibrary library = new MediaLibrary();
        library.addMedia(new MediaFile("photo1.jpg", MediaType.PHOTO));
        library.addMedia(new MediaFile("video1.mp4", MediaType.VIDEO));
        library.addMedia(new MediaFile("photo2.jpg", MediaType.PHOTO));

        MediaFileProxy proxy = new MediaFileProxy(library, new TypeFilterStrategy());
        MediaIterator iterator = proxy.getIterator(MediaType.PHOTO);

        assertTrue(iterator.hasNext());
        assertEquals("photo1.jpg", iterator.next().getName());
        assertTrue(iterator.hasNext());
        assertEquals("photo2.jpg", iterator.next().getName());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testEmptyLibrary() {
        MediaLibrary library = new MediaLibrary();
        MediaFileProxy proxy = new MediaFileProxy(library, new TypeFilterStrategy());

        MediaIterator iterator = proxy.getIterator(MediaType.VIDEO);
        assertFalse(iterator.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> iterator.next());
    }

    @Test
    public void testMixedMediaTypes() {
        MediaLibrary library = new MediaLibrary();
        library.addMedia(new MediaFile("video1.mp4", MediaType.VIDEO));
        library.addMedia(new MediaFile("photo1.jpg", MediaType.PHOTO));
        library.addMedia(new MediaFile("audio1.mp3", MediaType.AUDIO));
        library.addMedia(new MediaFile("video2.mp4", MediaType.VIDEO));

        MediaFileProxy proxy = new MediaFileProxy(library, new TypeFilterStrategy());

        MediaIterator iterator = proxy.getIterator(MediaType.VIDEO);
        assertTrue(iterator.hasNext());
        assertEquals("video1.mp4", iterator.next().getName());
        assertTrue(iterator.hasNext());
        assertEquals("video2.mp4", iterator.next().getName());
        assertFalse(iterator.hasNext());

        iterator = proxy.getIterator(MediaType.AUDIO);
        assertTrue(iterator.hasNext());
        assertEquals("audio1.mp3", iterator.next().getName());
        assertFalse(iterator.hasNext());

        iterator = proxy.getIterator(MediaType.PHOTO);
        assertTrue(iterator.hasNext());
        assertEquals("photo1.jpg", iterator.next().getName());
        assertFalse(iterator.hasNext());
    }
}
