package edu.umb.cs680.hw07;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FileTest {

    static LocalDateTime timeNow = LocalDateTime.now();

    //CREATING ROOT DIRECTORY
    Directory root = new Directory(null, "root", 0, timeNow);

    //DIRECTORY UNDER ROOT
    Directory apps = new Directory(root, "applications", 0, timeNow);
    Directory home = new Directory(root, "home", 0, timeNow);
    Directory lib = new Directory(root, "library", 0, timeNow);

    //DIRECTORY UNDER HOME
    Directory code = new Directory(home, "code", 0, timeNow);

    //FILES UNDER APPLICATIONS
    File x = new File(apps, "x", 1, timeNow);
    File y = new File(apps, "y", 1, timeNow);

    //FILES UNDER LIBRARY
    File z = new File(lib, "z", 1, timeNow);

    //FILES UNDER HOME
    File d = new File(home, "d", 1, timeNow);

    //FILES UNDER CODE
    File a = new File(code, "a", 1, timeNow);
    File b = new File(code, "b", 1, timeNow);
    File c = new File(code, "c", 1, timeNow);


    private String[] fileInfoToStringArray(File file) {
        String fileInfo[] = {Boolean.toString(file.isDirectory()),
                file.getName(),
                Integer.toString(file.getSize()),
                file.getCreationTime().toString(),
                file.getParent().getName()};
        return fileInfo;
    }

    @Test
    public void checkInstanceOfFileA(){
        String [] expected = {"false","a","1",timeNow.toString(),"code"};
        assertArrayEquals(expected,fileInfoToStringArray(a));
    }

    @Test
    public void checkInstanceOfFileZ(){
        String [] expected = {"false","z","1",timeNow.toString(),"library"};
        assertArrayEquals(expected,fileInfoToStringArray(z));
    }

    @Test
    public void checkInstanceOfFileX(){
        String [] expected = {"false","x","1",timeNow.toString(),"applications"};
        assertArrayEquals(expected,fileInfoToStringArray(x));
    }

    @Test
    public void checkInstanceOfFileD(){
        String [] expected = {"false","d","1",timeNow.toString(),"home"};
        assertArrayEquals(expected,fileInfoToStringArray(d));
    }

    @Test
    public void checkAllFilesForFileInstance() {
        assertFalse(a.isDirectory());
        assertFalse(b.isDirectory());
        assertFalse(c.isDirectory());
        assertFalse(d.isDirectory());
        assertFalse(x.isDirectory());
        assertFalse(y.isDirectory());
        assertFalse(z.isDirectory());
    }


}
