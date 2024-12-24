package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MediaFileProxy {
    private MediaLibrary mediaLibrary;
    private Map<MediaType, List<MediaFile>> cachedMedia = new HashMap<>();

    public MediaFileProxy(MediaLibrary mediaLibrary) {
        this.mediaLibrary = mediaLibrary;
    }

    public MediaIterator getIterator(MediaType type) {
        if (!cachedMedia.containsKey(type)) {
            cachedMedia.put(type, mediaLibrary.getMediaByType(type));
        }
        return new MediaIteratorImpl(cachedMedia.get(type));
    }
}