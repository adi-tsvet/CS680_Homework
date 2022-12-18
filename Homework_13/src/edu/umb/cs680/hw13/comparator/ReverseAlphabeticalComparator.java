package edu.umb.cs680.hw13.comparator;

import edu.umb.cs680.hw13.fs.FSElement;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {

    public int compare(FSElement fsElement1, FSElement fsElement2) {
        return fsElement2.getName().compareTo(fsElement1.getName());
    }

}