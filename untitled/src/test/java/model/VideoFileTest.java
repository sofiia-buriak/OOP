package model;

import org.example.enums.MediaType;
import org.example.model.VideoFile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VideoFileTest {

    @Test
    public void testVideoFileCreation() {
        VideoFile videoFile = new VideoFile("example.mp4", 1024, "2023-10-01");
        assertEquals("example.mp4", videoFile.getName());
        assertEquals(1024, videoFile.getSize());
        assertEquals("2023-10-01", videoFile.getDate());
    }

    @Test
    public void testGetType() {
        VideoFile videoFile = new VideoFile("example.mp4", 1024, "2023-10-01");
        assertEquals(MediaType.VIDEO, videoFile.getType());
    }
}