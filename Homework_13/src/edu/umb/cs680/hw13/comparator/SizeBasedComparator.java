package edu.umb.cs680.hw13.comparator;

import edu.umb.cs680.hw13.fs.FSElement;

import java.util.Comparator;

public class SizeBasedComparator implements Comparator<FSElement> {

    public int compare(FSElement element1, FSElement element2) {
        return element2.getSize() - element1.getSize(); //This will sort larger size first
    }
}
