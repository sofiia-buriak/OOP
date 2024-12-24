package com.example;

import java.util.ArrayList;
import java.util.List;

public class MediaFileProxy {
    private MediaLibrary mediaLibrary;
    private List<MediaFile> cachedMedia = new ArrayList<>();

    public MediaFileProxy(MediaLibrary mediaLibrary) {
        this.mediaLibrary = mediaLibrary;
    }

    public MediaIterator getIterator(MediaType type) {
        if (cachedMedia.isEmpty()) {
            cachedMedia = mediaLibrary.getMediaByType(type);
        }
        return new MediaIteratorImpl(cachedMedia);
    }
}