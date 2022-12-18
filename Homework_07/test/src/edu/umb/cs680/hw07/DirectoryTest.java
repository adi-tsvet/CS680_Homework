package edu.umb.cs680.hw07;


import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {

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

    private String[] directoryInfoToStringArray(Directory d) {

        String parentName = null; //  Since Root has no parent it will return null
        Directory parent = d.getParent();

        if (parent != null)
            parentName = parent.getName();

        String[] directoryInfo = {Boolean.toString(d.isDirectory()),
                d.getName(),
                Integer.toString(d.getSize()),
                d.getCreationTime().toString(),
                Integer.toString(d.countChildren()),
                Integer.toString(d.getTotalSize()),
                parentName
                };
        return directoryInfo;
    }

    private ArrayList<String> subDirectoryToStringArrayWithNames (Directory d){
        ArrayList<String> subDirectoryName = new ArrayList<>();
         for (Directory directory : d.getSubDirectories()){
             subDirectoryName.add(directory.getName());
         }
         return subDirectoryName;
    }

    @Test
    public void checkInstanceOfRootDirectory(){
        String [] expected = {"true","root","0",timeNow.toString(),"3","7",null};
        assertArrayEquals(expected,directoryInfoToStringArray(root));
    }

    @Test
    public void checkInstanceOfHomeDirectory(){
        String [] expected = {"true","home","0",timeNow.toString(),"2","4","root"};
        assertArrayEquals(expected, directoryInfoToStringArray(home));
    }

    @Test
    public void checkInstanceOfCodeDirectory(){
        String [] expected = {"true","code","0",timeNow.toString(),"3","3","home"};
        assertArrayEquals(expected, directoryInfoToStringArray(code));
    }

    @Test
    public void checkInstanceOfAppsDirectory(){
        String [] expected = {"true","applications","0",timeNow.toString(),"2","2","root"};
        assertArrayEquals(expected, directoryInfoToStringArray(apps));
    }

    @Test
    public void checkInstanceOfLibDirectory(){
        String [] expected = {"true","library","0",timeNow.toString(),"1","1","root"};
        assertArrayEquals(expected, directoryInfoToStringArray(lib));
    }


    @Test
    public void checkParentForHomeDirectory(){
        String expected = "root";
        String actual = home.getParent().getName();
        assertEquals(expected,actual);
    }

    @Test
    public void checkChildrenCountInDirectory() {
        assertEquals(3,root.countChildren());
        assertEquals(2,home.countChildren());
        assertEquals(3,code.countChildren());
        assertEquals(2,apps.countChildren());
        assertEquals(1,lib.countChildren());
    }

    @Test
    public void checkForDirectoryInstances() {
        assertTrue(root.isDirectory());
        assertTrue(home.isDirectory());
        assertTrue(apps.isDirectory());
        assertTrue(code.isDirectory());
        assertTrue(lib.isDirectory());
        assertFalse(x.isDirectory());
        assertFalse(y.isDirectory());
    }

    @Test
    public void checkSubDirectoriesForRootDirectory(){
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("applications","home","library"));
        assertEquals(expected,subDirectoryToStringArrayWithNames(root));
    }

    @Test
    public void checkSubDirectoriesForHomeDirectory(){
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("code"));
        assertEquals(expected,subDirectoryToStringArrayWithNames(home));
    }



}
