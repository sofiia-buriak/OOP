import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.MediaFile;
import com.example.MediaLibrary;
import com.example.MediaType;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MediaLibraryTest {

    private MediaLibrary mediaLibrary;

    @BeforeEach
    public void setUp() {
        mediaLibrary = new MediaLibrary();
    }

    @Test
    public void testAddMedia() {
        MediaFile mediaFile = new MediaFile("video1.mp4", MediaType.VIDEO);
        mediaLibrary.addMedia(mediaFile);
        List<MediaFile> allMedia = mediaLibrary.getAllMedia();
        assertEquals(1, allMedia.size());
        assertEquals(mediaFile, allMedia.get(0));
    }

    @Test
    public void testGetAllMedia() {
        mediaLibrary.addMedia(new MediaFile("video1.mp4", MediaType.VIDEO));
        mediaLibrary.addMedia(new MediaFile("photo1.jpg", MediaType.PHOTO));
        List<MediaFile> allMedia = mediaLibrary.getAllMedia();
        assertEquals(2, allMedia.size());
    }
}