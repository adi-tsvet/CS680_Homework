package edu.umb.cs680.hw07;

import java.util.LinkedList;
import java.util.Map;

public class FileSystem {

    LinkedList<Directory> directory =new LinkedList<Directory>();
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

    public void appendRootDir(Directory root) {
        directory.add(root);
    }

    public LinkedList<Directory> getRootDirs() {
        return this.directory;
    }
}
