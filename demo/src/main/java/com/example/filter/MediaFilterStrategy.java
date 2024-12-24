package com.example.filter;

import java.util.List;

import com.example.model.MediaFile;
import com.example.model.MediaType;

public interface MediaFilterStrategy {
    List<MediaFile> filter(List<MediaFile> mediaFiles, MediaType type);
}

