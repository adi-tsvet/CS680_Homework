package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FSVisitor;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;

import java.util.LinkedList;

public class FileSearchVisitor implements FSVisitor {

    String fileName;
    LinkedList<File> foundFiles;

    public FileSearchVisitor(String fileName) {
        this.fileName = fileName;
        foundFiles = new LinkedList<>();
    }


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LinkedList<File> getFoundFiles() {
        return foundFiles;
    }


    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
        if(file.getName().equals(fileName)){
            foundFiles.add(file); }
    }
}
