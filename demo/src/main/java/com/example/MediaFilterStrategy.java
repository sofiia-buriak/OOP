package com.example;

import java.util.List;

public interface MediaFilterStrategy {
    List<MediaFile> filter(List<MediaFile> mediaFiles);
}
