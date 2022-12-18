package edu.umb.cs680.hw10.fs;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class FileSystemTest {

    private LocalDateTime now = LocalDateTime.now();

    private Directory[] LinkedListToArray(LinkedList<Directory> rootList) {
        Directory[] rootArray = new Directory[rootList.size()];
        int index = 0;
        for (Directory root : rootList) {
            rootArray[index++] = root;
        }
        return rootArray;
    }

    @Test
    public void CheckForGetRootDirectory() {
        FileSystem fileSystem = FileSystem.getFileSystem();
        Directory[] expected = {};
        Directory[] actual = this.LinkedListToArray(fileSystem.getRootDirectory());
        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkFileSystemForSingleInstance() {
        FileSystem fileSystem1 = FileSystem.getFileSystem();
        FileSystem fileSystem2 = FileSystem.getFileSystem();
        assertSame(fileSystem1, fileSystem2);
    }

    @Test
    public void CheckForAddRootDirectory() {
        Directory root = new Directory(null, "Root", 0, this.now);
        Directory[] expected = { root };

        FileSystem fileSystem = FileSystem.getFileSystem();
        fileSystem.appendRootDirectory(root);
        LinkedList<Directory> rootDir = fileSystem.getRootDirectory();
        Directory[] actual = this.LinkedListToArray(rootDir);

        assertArrayEquals(expected, actual);
    }

}