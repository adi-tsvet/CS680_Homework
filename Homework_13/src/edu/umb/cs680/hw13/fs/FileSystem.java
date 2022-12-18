package edu.umb.cs680.hw13.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FileSystem {

    LinkedList<Directory> directory =new LinkedList<Directory>();
    private Directory root;
    private FileSystem(){};

    private static FileSystem fileSystem = null;

    public static FileSystem getFileSystem() {
        if (fileSystem == null){
            fileSystem = new FileSystem();
        }
        return fileSystem;
    }

    public LinkedList<Directory> getRootDirectory(){
        return this.directory;
    }


    public void appendRootDirectory(Directory root) {
        directory.add(root);
    }

}
