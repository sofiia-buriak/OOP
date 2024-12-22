package service;

import org.example.model.AudioFile;
import org.example.model.MediaFile;
import org.example.service.MediaSearchService;
import org.example.service.SearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SearchServiceTest {

    private SearchService searchService;
    private List<MediaFile> mediaFiles;

    @BeforeEach
    public void setUp() {
        searchService = new MediaSearchService();
        mediaFiles = Arrays.asList(
                new AudioFile("song.mp3", 1024, "2024-12-01"),
                new AudioFile("podcast.mp3", 2048, "2024-12-04")
        );
    }

    @Test
    public void testSearch() {
        List<MediaFile> results = searchService.search(mediaFiles, file -> file.getName().contains(".mp3"));
        assertEquals(2, results.size());
        assertTrue(results.stream().anyMatch(file -> file.getName().equals("song.mp3")));
        assertTrue(results.stream().anyMatch(file -> file.getName().equals("podcast.mp3")));
    }
}