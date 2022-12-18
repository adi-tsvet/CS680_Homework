package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CountingVisitorTest {

    private static CountingVisitor visitor;

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

        visitor = new CountingVisitor();

    }
    @AfterEach
    public void resetVisitor(){
        visitor = new CountingVisitor();
    }

    @Test
    public void checkDirectoryCountInRoot() {
        root.accept(visitor);
        int expected = 5;
        int actual = visitor.getDirNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkFilesCountInRootDirectory() {
        root.accept(visitor);
        int expected = 5;
        int actual = visitor.getFileNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkLinksCountInRootDirectory() {
        root.accept(visitor);
        int expected = 2;
        int actual = visitor.getLinkNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkDirectoryCountForHome() {
        home.accept(visitor);
        int expected = 2;
        int actual = visitor.getDirNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkFilesCountForHomeDirectory() {
        home.accept(visitor);
        int expected = 3;
        int actual = visitor.getFileNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkFilesCountForBinDirectory() {
        bin.accept(visitor);
        int expected = 1;
        int actual = visitor.getFileNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkFilesCountForPicturesDirectory() {
        pictures.accept(visitor);
        int expected = 2;
        int actual = visitor.getFileNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkFilesCountForApplicationsDirectory() {
        apps.accept(visitor);
        int expected = 1;
        int actual = visitor.getFileNum();
        assertEquals(expected, actual);
    }

}
