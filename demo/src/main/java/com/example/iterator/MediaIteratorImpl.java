package com.example.iterator;

import java.util.List;

import com.example.model.MediaFile;

public class MediaIteratorImpl implements MediaIterator {
    private List<MediaFile> mediaFiles;
    private int position = 0;

    public MediaIteratorImpl(List<MediaFile> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    @Override
    public boolean hasNext() {
        return position < mediaFiles.size();
    }

    @Override
    public MediaFile next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more media files");
        }
        return mediaFiles.get(position++);
    }
}