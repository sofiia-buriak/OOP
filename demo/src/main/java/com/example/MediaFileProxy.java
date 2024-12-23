package com.example;

import java.util.ArrayList;
import java.util.List;

public class MediaFileProxy {
    private MediaLibrary mediaLibrary;
    private List<MediaFile> cachedMedia;

    public MediaFileProxy(MediaLibrary mediaLibrary) {
        this.mediaLibrary = mediaLibrary;
        this.cachedMedia = new ArrayList<>();
    }

    public MediaIterator getIterator(MediaType type) {
        return null;
    }

    private List<MediaFile> loadMedia(MediaType type) {
        return null;
    }
}
