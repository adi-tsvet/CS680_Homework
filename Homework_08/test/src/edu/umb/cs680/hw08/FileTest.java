package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileTest {

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
    private String[] fileToStringArray(File f) {
        String[] fileInfo = {
                String.valueOf(f.isFile()),
                f.getName(),
                Integer.toString(f.getSize()),
                f.getCreationTime().toString(),
                f.getParent().getName(),
                String.valueOf(f.isDirectory())
        };
        return fileInfo;
    }

    @Test
    public void checkInstanceOfFileX() {
        String[] expected = { "true", "x", "1", now.toString(), "Applications", "false" };
        File actual = x;
        assertArrayEquals(expected,  fileToStringArray(actual));
    }
    @Test
    public void checkInstanceOfFileY() {
        String[] expected = { "true", "y", "1", now.toString(), "Bin", "false" };
        File actual = y;
        assertArrayEquals(expected,  fileToStringArray(actual));
    }

    @Test
    public void checkInstanceOfFileA() {
        String[] expected = { "true", "a", "2", later.toString(), "Pictures", "false" };
        File actual = a;
        assertArrayEquals(expected,  fileToStringArray(actual));
    }

    @Test
    public void checkInstanceOfFileB() {
        String[] expected = { "true", "b", "2", later.toString(), "Pictures", "false" };
        File actual = b;
        assertArrayEquals(expected,  fileToStringArray(actual));
    }

    @Test
    public void checkInstanceOfFileC() {
        String[] expected = { "true", "c", "1", now.toString(), "Home", "false" };
        File actual = c;
        assertArrayEquals(expected,  fileToStringArray(actual));
    }

}