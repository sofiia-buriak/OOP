package org.example;

import java.util.Comparator;
import java.util.List;

public interface SortService {
    List<MediaFile> sort(List<MediaFile> mediaFiles, Comparator<MediaFile> comparator);
}