
package edu.umb.cs680.hw13.comparator;

import edu.umb.cs680.hw13.fs.FSElement;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement> {

    public int compare(FSElement fsElement1, FSElement fsElement2) {
        return fsElement1.getName().compareTo(fsElement2.getName());
    }


}