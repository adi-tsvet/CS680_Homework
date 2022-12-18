package edu.umb.cs680.hw09.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DirectoryTest {

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

    static Link d = new Link(null, "d", 0, now, null);
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

    private String[] directoryToStringArray(Directory dir) {
        String parentName = null;
        Directory parent = dir.getParent();

        if (parent != null)
            parentName = parent.getName();

        String[] dirInfo = {
                String.valueOf(dir.isDirectory()),
                dir.getName(),
                Integer.toString(dir.getSize()),
                dir.getCreationTime().toString(),
                parentName,
                String.valueOf(dir.isFile()),
                Integer.toString(dir.getTotalSize()),
                Integer.toString(dir.countChildren())
        };
        return dirInfo;
    }

    @Test
    public void checkInstanceOfRootDirectory() {
        String[] expected = { "true", "Root", "0", now.toString(), null, "false", "7", "5" };
        Directory actual = root;
        assertArrayEquals(expected,directoryToStringArray(actual));
    }

    @Test
    public void checkInstanceOfApplicationsDirectory() {
        String[] expected = { "true", "Applications", "0", now.toString(), "Root", "false", "1", "1" };
        Directory actual = apps;
        assertArrayEquals(expected,directoryToStringArray(actual));
    }

    @Test
    public void checkInstanceOfBinDirectory() {
        String[] expected = { "true", "Bin", "0", now.toString(), "Root", "false", "1", "1" };
        Directory actual = bin;
        assertArrayEquals(expected,directoryToStringArray(actual));
    }
    @Test
    public void checkInstanceOfHomeDirectory() {
        String[] expected = { "true", "Home", "0", now.toString(), "Root", "false", "5", "2" };
        Directory actual = home;
        assertArrayEquals(expected,directoryToStringArray(actual));
    }

    @Test
    public void checkInstanceOfPicturesDirectory() {
        String[] expected = { "true", "Pictures", "0", later.toString(), "Home", "false", "4", "2" };
        Directory actual = pictures;
        assertArrayEquals(expected,directoryToStringArray(actual));
    }

    @Test
    public void CheckIfRootIsLink() {
        assertFalse(root.isLink());
    }

    @Test
    public void CheckForSubDirectoriesInRootDirectory() {
        Directory[] expected = new Directory[3];
        expected[0] = apps;
        expected[1] = bin;
        expected[2] = home;
        Directory[] actual = new Directory[3];
        LinkedList<Directory> subDirectories = root.getSubDirectories();
        actual[0] = subDirectories.get(0);
        actual[1] = subDirectories.get(1);
        actual[2] = subDirectories.get(2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void CheckForSubDirectoriesInHomeDirectory() {
        Directory[] expected = new Directory[1];
        expected[0] = pictures;
        Directory[] actual = new Directory[1];
        LinkedList<Directory> subDirectories = home.getSubDirectories();
        actual[0] = subDirectories.get(0);
        assertArrayEquals(expected, actual);
    }

}