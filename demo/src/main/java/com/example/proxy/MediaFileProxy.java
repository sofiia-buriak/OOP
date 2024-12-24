package com.example.proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.filter.MediaFilterStrategy;
import com.example.iterator.MediaIterator;
import com.example.iterator.MediaIteratorImpl;
import com.example.library.MediaLibrary;
import com.example.model.MediaFile;
import com.example.model.MediaType;

public class MediaFileProxy {
    private MediaLibrary mediaLibrary;
    private Map<MediaType, List<MediaFile>> cachedMedia = new HashMap<>();
    private MediaFilterStrategy filterStrategy;

    public MediaFileProxy(MediaLibrary mediaLibrary, MediaFilterStrategy filterStrategy) {
        this.mediaLibrary = mediaLibrary;
        this.filterStrategy = filterStrategy;
    }

    public MediaIterator getIterator(MediaType type) {
        if (!cachedMedia.containsKey(type)) {
            List<MediaFile> allMedia = mediaLibrary.getAllMedia();
            cachedMedia.put(type, filterStrategy.filter(allMedia, type));
        }
        return new MediaIteratorImpl(cachedMedia.get(type));
    }
}
