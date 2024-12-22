package model;

import org.example.enums.MediaType;
import org.example.model.ImageFile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImageFileTest {

    @Test
    public void testImageFileCreation() {
        ImageFile imageFile = new ImageFile("testImage", 1024, "2023-10-01");
        assertNotNull(imageFile);
        assertEquals("testImage", imageFile.getName());
        assertEquals(1024, imageFile.getSize());
        assertEquals("2023-10-01", imageFile.getDate());
    }

    @Test
    public void testGetType() {
        ImageFile imageFile = new ImageFile("testImage", 1024, "2023-10-01");
        assertEquals(MediaType.IMAGE, imageFile.getType());
    }
}