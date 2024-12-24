import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.MediaFile;
import com.example.MediaFilter;
import com.example.MediaType;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MediaFilterTest {

    private MediaFilter mediaFilter;

    @BeforeEach
    public void setUp() {
        mediaFilter = new MediaFilter();
    }

    @Test
    public void testFilterByType() {
        List<MediaFile> mediaFiles = Arrays.asList(
                new MediaFile("video1.mp4", MediaType.VIDEO),
                new MediaFile("photo1.jpg", MediaType.PHOTO),
                new MediaFile("video2.mp4", MediaType.VIDEO)
        );

        List<MediaFile> filteredMedia = mediaFilter.filterByType(mediaFiles, MediaType.VIDEO);
        assertEquals(2, filteredMedia.size());
        assertEquals("video1.mp4", filteredMedia.get(0).getName());
        assertEquals("video2.mp4", filteredMedia.get(1).getName());
    }
}