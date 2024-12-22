package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MediaSortService {
    public List<MediaFile> sort(List<MediaFile> mediaFiles, Comparator<MediaFile> comparator) {
        List<MediaFile> sortedList = new ArrayList<>(mediaFiles);
        sortedList.sort(comparator);
        return sortedList;
    }
}