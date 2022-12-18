package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.*;
import edu.umb.cs680.hw10.securityContext.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileCrawlingVisitorTest {

    static private FileCrawlingVisitor visitor;
    private static SecurityContext ctx;
    private static User user;
    private static EncryptedString pwd;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
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
        ctx = new SecurityContext(user);
    }

    @AfterEach
    public void resetVisitor(){
        visitor = new FileCrawlingVisitor();
        ctx = new SecurityContext(user);
    }
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach  //restoring it to its original state when each test terminates
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void checkFilesInRootDirectory() {
        ctx.login(pwd); //User has logged In
        root.accept(visitor,ctx);
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
        ctx.login(pwd); //User has logged In
        home.accept(visitor,ctx);
        LinkedList<File> actual = visitor.getFiles();
        LinkedList<File> expected = new LinkedList<>();
        expected.add(a);
        expected.add(b);
        expected.add(c);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void checkFilesInBinDirectory() {
        ctx.login(pwd); //User has logged In
        bin.accept(visitor,ctx);
        LinkedList<File> actual = visitor.getFiles();
        LinkedList<File> expected = new LinkedList<>();
        expected.add(y);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void checkFilesInApplicationDirectory() {
        ctx.login(pwd); //User has logged In
        apps.accept(visitor,ctx);
        LinkedList<File> actual = visitor.getFiles();
        LinkedList<File> expected = new LinkedList<>();
        expected.add(x);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void checkFilesInPicturesDirectory() {
        ctx.login(pwd); //User has logged In
        pictures.accept(visitor,ctx);
        LinkedList<File> actual = visitor.getFiles();
        LinkedList<File> expected = new LinkedList<>();
        expected.add(a);
        expected.add(b);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
    @Test
    public void checkWhenUserAccessRootAndIsNotLoggedIn(){
        //ctx would currently be in LoggedOut state
        root.accept(visitor,ctx);
        assertEquals("User needs to login to traverse a Directory",outputStreamCaptor.toString().trim());
    }
    @Test
    public void checkWhenUserAccessFileXAndIsNotLoggedIn(){
        //ctx would currently be in LoggedOut state
        x.accept(visitor,ctx);
        assertEquals("User needs to login to search a File",outputStreamCaptor.toString().trim());
    }
}
