import org.junit.jupiter.api.Test;

import com.example.MediaFile;
import com.example.MediaType;

import static org.junit.jupiter.api.Assertions.*;

public class MediaFileTest {

    @Test
    public void testMediaFileCreation() {
        MediaFile mediaFile = new MediaFile("video1.mp4", MediaType.VIDEO);
        assertEquals("video1.mp4", mediaFile.getName());
        assertEquals(MediaType.VIDEO, mediaFile.getType());
    }
}