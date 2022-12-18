package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class FileCrawlingVisitorTest {

    static private FileCrawlingVisitor visitor;
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
        visitor = new FileCrawlingVisitor();
    }

    @AfterEach
    public void resetVisitor(){
        visitor = new FileCrawlingVisitor();
    }

    @Test
    public void checkFilesInRootDirectory() {
        root.accept(visitor);
        LinkedList<File> actual = visitor.getFiles();
        LinkedList<File> expected = new LinkedList<>();
        expected.add(x);
        expected.add(y);
        expected.add(a);
        expected.add(b);
        expected.add(c);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void checkFilesInHomeDirectory() {
        home.accept(visitor);
        LinkedList<File> actual = visitor.getFiles();
        LinkedList<File> expected = new LinkedList<>();
        expected.add(a);
        expected.add(b);
        expected.add(c);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void checkFilesInBinDirectory() {
        bin.accept(visitor);
        LinkedList<File> actual = visitor.getFiles();
        LinkedList<File> expected = new LinkedList<>();
        expected.add(y);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void checkFilesInApplicationDirectory() {
        apps.accept(visitor);
        LinkedList<File> actual = visitor.getFiles();
        LinkedList<File> expected = new LinkedList<>();
        expected.add(x);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void checkFilesInPicturesDirectory() {
        pictures.accept(visitor);
        LinkedList<File> actual = visitor.getFiles();
        LinkedList<File> expected = new LinkedList<>();
        expected.add(a);
        expected.add(b);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
