package edu.umb.cs680.hw13.comparator;

import edu.umb.cs680.hw13.fs.FSElement;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement> {

    public int compare(FSElement element1, FSElement element2) {
        return element2.getCreationTime().compareTo(element1.getCreationTime());
    }

}