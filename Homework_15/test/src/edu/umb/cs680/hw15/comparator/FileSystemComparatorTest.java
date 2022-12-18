package edu.umb.cs680.hw15.comparator;

import edu.umb.cs680.hw15.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class FileSystemComparatorTest {


    static private LocalDateTime now = LocalDateTime.now();
    static private LocalDateTime later = LocalDateTime.now();

    static Directory root = new Directory(null, "Root", 0, now);

    static Directory apps = new Directory(null, "Applications", 0, now);
    static File x = new File(null, "x", 1, now);

    static Directory bin = new Directory(null, "Bin", 0, now);
    static File y = new File(null, "y", 1, now);

    static Directory home = new Directory(null, "Home", 0, now);
    static Directory pictures = new Directory(null, "Pictures", 0, later);
    static File c = new File(null, "c", 1, now);
    static File a = new File(null, "a", 2, later);
    static File b = new File(null, "b", 2, later);

    static Link d = new Link(null, "d", 0, later, null);
    static Link e = new Link(null, "e", 0, later, null);

    @BeforeAll
    static void init() {
        root.appendChild(apps);
        root.appendChild(bin);
        root.appendChild(home);
        root.appendChild(d);
        root.appendChild(e);

        apps.appendChild(x);

        bin.appendChild(y);

        home.appendChild(pictures);
        home.appendChild(c);

        pictures.appendChild(a);
        pictures.appendChild(b);

        d.setTarget(pictures);
        e.setTarget(x);
    }

    @Test
    public void CheckChildrenOfRootDirectoryInAlphabeticalOrder() {
        FSElement[] expected = {apps,bin,home,d,e};
        LinkedList<FSElement> actual = root.getChildren();
        Collections.sort(actual , (FSElement fsElement1, FSElement fsElement2) -> fsElement1.getName().compareTo(fsElement2.getName()));
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    public void CheckChildrenOfRootDirectoryInReverseAlphabeticalOrder() {
        FSElement[] expected = {e,d,home,bin,apps};
        LinkedList<FSElement> actual = root.getChildren();
        Collections.sort(actual , (FSElement fsElement1, FSElement fsElement2) -> fsElement2.getName().compareTo(fsElement1.getName()));
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    public void CheckChildrenOfRootDirectoryInSizeBasedOrder() {
        FSElement[] expected = {apps,bin,home,d,e};
        LinkedList<FSElement> actual = root.getChildren();
        Collections.sort(actual , (FSElement fsElement1, FSElement fsElement2) -> fsElement1.getSize() - (fsElement2.getSize()));
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    public void CheckChildrenOfRootDirectoryInCreationTimeOrder() {
        FSElement[] expected = {apps,bin,home,d,e};
        LinkedList<FSElement> actual = root.getChildren();
        Collections.sort(actual , (FSElement fsElement1, FSElement fsElement2) -> (fsElement2.getCreationTime()).compareTo(fsElement1.getCreationTime()));
        assertArrayEquals(expected,actual.toArray());
    }

}
