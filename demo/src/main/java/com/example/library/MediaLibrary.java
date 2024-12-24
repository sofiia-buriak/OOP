package com.example.library;

import java.util.List;

import com.example.model.MediaFile;

import java.util.ArrayList;

public class MediaLibrary {
    private List<MediaFile> mediaFiles = new ArrayList<>();

    public void addMedia(MediaFile mediaFile) {
        mediaFiles.add(mediaFile);
    }

    public List<MediaFile> getAllMedia() {
        return mediaFiles;
    }
}