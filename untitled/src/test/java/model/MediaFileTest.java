package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.enums.MediaType;
import org.example.model.MediaFile;
import org.junit.jupiter.api.Test;

class MediaFileTest {

    private static class TestMediaFile extends MediaFile {
        public TestMediaFile(String name, int size, String date) {
            super(name, size, date);
        }

        @Override
        public MediaType getType() {
            return MediaType.IMAGE; 
        }
    }

    @Test
    void testGetName() {
        MediaFile mediaFile = new TestMediaFile("example", 100, "2023-10-01");
        assertEquals("example", mediaFile.getName());
    }

    @Test
    void testGetSize() {
        MediaFile mediaFile = new TestMediaFile("example", 100, "2023-10-01");
        assertEquals(100, mediaFile.getSize());
    }

    @Test
    void testGetDate() {
        MediaFile mediaFile = new TestMediaFile("example", 100, "2023-10-01");
        assertEquals("2023-10-01", mediaFile.getDate());
    }

    @Test
    void testGetType() {
        MediaFile mediaFile = new TestMediaFile("example", 100, "2023-10-01");
        assertEquals(MediaType.IMAGE, mediaFile.getType());
    }
}