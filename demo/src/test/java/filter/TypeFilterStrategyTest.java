package filter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.model.MediaFile;
import com.example.model.MediaType;
import com.example.filter.TypeFilterStrategy;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TypeFilterStrategyTest {

    private TypeFilterStrategy typeFilterStrategy;

    @BeforeEach
    public void setUp() {
        typeFilterStrategy = new TypeFilterStrategy();
    }

    @Test
    public void testFilterByType() {
        List<MediaFile> mediaFiles = Arrays.asList(
                new MediaFile("video1.mp4", MediaType.VIDEO),
                new MediaFile("photo1.jpg", MediaType.PHOTO),
                new MediaFile("video2.mp4", MediaType.VIDEO)
        );

        List<MediaFile> filteredMedia = typeFilterStrategy.filter(mediaFiles, MediaType.VIDEO);
        assertEquals(2, filteredMedia.size());
        assertEquals("video1.mp4", filteredMedia.get(0).getName());
        assertEquals("video2.mp4", filteredMedia.get(1).getName());
    }
}