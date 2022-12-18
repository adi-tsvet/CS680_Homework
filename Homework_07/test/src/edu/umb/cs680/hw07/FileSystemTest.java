package edu.umb.cs680.hw07;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.FileSystem;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FileSystemTest {

    static LocalDateTime localTime = LocalDateTime.now();

    private String[] directoryInfoToStringArray(Directory d) {
        String directoryInfo[] = {null, //since root would have null parent
                d.getName(),
                Integer.toString(d.getSize()),
                d.getCreationTime().toString()};
        return directoryInfo;
    }

    @Test
    public void checkFileSystemForSingleInstance() {
        FileSystem FS1 = FileSystem.getFileSystem();
        FileSystem FS2 = FileSystem.getFileSystem();
        assertEquals(FS1,FS2);
    }

    @Test
    public void checkInstanceForRootDirectory() {
        Directory root = new Directory(null, "root", 0, localTime);
        String expected[] = {null, "root", "0", localTime.toString()};
        FileSystem.getFileSystem().appendRootDir(root);
        Directory actual = FileSystem.getFileSystem().getRootDirs().getFirst();
        assertArrayEquals(expected, directoryInfoToStringArray(actual));
    }
}
