package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MediaFileProxy {
    private MediaLibrary mediaLibrary;
    private MediaFilter mediaFilter = new MediaFilter();
    private Map<MediaType, List<MediaFile>> cachedMedia = new HashMap<>();

    public MediaFileProxy(MediaLibrary mediaLibrary) {
        this.mediaLibrary = mediaLibrary;
    }

    public MediaIterator getIterator(MediaType type) {
        if (!cachedMedia.containsKey(type)) {
            List<MediaFile> allMedia = mediaLibrary.getAllMedia();
            cachedMedia.put(type, mediaFilter.filterByType(allMedia, type));
        }
        return new MediaIteratorImpl(cachedMedia.get(type));
    }
}