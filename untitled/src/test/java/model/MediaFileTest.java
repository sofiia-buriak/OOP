package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.enums.MediaType;
import org.example.model.AudioFile;
import org.example.model.ImageFile;
import org.example.model.MediaFile;
import org.example.model.VideoFile;
import org.junit.jupiter.api.Test;

public class MediaFileTest {

    @Test
    public void testAudioFile() {
        MediaFile audioFile = new AudioFile("song.mp3", 1024, "2024-12-01");
        assertEquals("song.mp3", audioFile.getName());
        assertEquals(1024, audioFile.getSize());
        assertEquals("2024-12-01", audioFile.getDate());
        assertEquals(MediaType.AUDIO, audioFile.getType());
    }

    @Test
    public void testImageFile() {
        MediaFile imageFile = new ImageFile("picture.jpg", 512, "2024-12-03");
        assertEquals("picture.jpg", imageFile.getName());
        assertEquals(512, imageFile.getSize());
        assertEquals("2024-12-03", imageFile.getDate());
        assertEquals(MediaType.IMAGE, imageFile.getType());
    }

    @Test
    public void testVideoFile() {
        MediaFile videoFile = new VideoFile("movie.mp4", 20480, "2024-12-02");
        assertEquals("movie.mp4", videoFile.getName());
        assertEquals(20480, videoFile.getSize());
        assertEquals("2024-12-02", videoFile.getDate());
        assertEquals(MediaType.VIDEO, videoFile.getType());
    }
}