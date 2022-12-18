package edu.umb.cs680.hw09.fs;


import java.util.LinkedList;

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

    public void appendRootDirectory(Directory root) {
        directory.add(root);
    }


}
