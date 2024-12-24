package com.example.iterator;

import com.example.model.MediaFile;

public interface MediaIterator {
    boolean hasNext();
    MediaFile next();
}
