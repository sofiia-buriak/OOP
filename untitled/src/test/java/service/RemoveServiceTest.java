package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.example.enums.MediaType;
import org.example.model.AudioFile;
import org.example.model.MediaFile;
import org.example.service.MediaRemoveService;
import org.example.service.RemoveService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemoveServiceTest {

    private RemoveService removeService;
    private List<MediaFile> mediaFiles;

    @BeforeEach
    public void setUp() {
        removeService = new MediaRemoveService();
        mediaFiles = new ArrayList<>(Arrays.asList(
                new AudioFile("song.mp3", 1024, "2024-12-01"),
                new AudioFile("podcast.mp3", 2048, "2024-12-04")
        ));
    }

    @Test
    public void testRemove() {
        removeService.remove(mediaFiles, file -> file.getType() == MediaType.AUDIO);
        assertEquals(0, mediaFiles.size());
        assertFalse(mediaFiles.stream().anyMatch(file -> file.getType() == MediaType.AUDIO));
    }
}