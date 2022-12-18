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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountingVisitorTest {

    private static CountingVisitor visitor;
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

        visitor = new CountingVisitor();
        ctx = new SecurityContext(user);

    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void resetClassObject(){
        visitor = new CountingVisitor();
        ctx = new SecurityContext(user);
    }
    @AfterEach  //restoring it to its original state when each test terminates
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void checkDirectoryCountInRoot() {
        ctx.login(pwd); //User has logged In
        root.accept(visitor,ctx);
        int expected = 5;
        int actual = visitor.getDirNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkFilesCountInRootDirectory() {
        ctx.login(pwd); //User has logged In
        root.accept(visitor,ctx);
        int expected = 5;
        int actual = visitor.getFileNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkLinksCountInRootDirectory() {
        ctx.login(pwd); //User has logged In
        root.accept(visitor,ctx);
        int expected = 2;
        int actual = visitor.getLinkNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkDirectoryCountForHome() {
        ctx.login(pwd); //User has logged In
        home.accept(visitor,ctx);
        int expected = 2;
        int actual = visitor.getDirNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkFilesCountForHomeDirectory() {
        ctx.login(pwd); //User has logged In
        home.accept(visitor,ctx);
        int expected = 3;
        int actual = visitor.getFileNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkFilesCountForBinDirectory() {
        ctx.login(pwd); //User has logged In
        bin.accept(visitor,ctx);
        int expected = 1;
        int actual = visitor.getFileNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkFilesCountForPicturesDirectory() {
        ctx.login(pwd); //User has logged In
        pictures.accept(visitor,ctx);
        int expected = 2;
        int actual = visitor.getFileNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkFilesCountForApplicationsDirectory() {
        ctx.login(pwd); //User has logged In
        apps.accept(visitor,ctx);
        int expected = 1;
        int actual = visitor.getFileNum();
        assertEquals(expected, actual);
    }

    @Test
    public void checkWhenUserAccessRootAndIsNotLoggedIn(){
        //ctx would currently be in LoggedOut state
        root.accept(visitor,ctx);
        assertEquals("User needs to login to traverse a Directory",outputStreamCaptor.toString().trim());
    }

}
