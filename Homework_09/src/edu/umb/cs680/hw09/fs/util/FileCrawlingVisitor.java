package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.*;

import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor {

    private LinkedList<File> files;

    public FileCrawlingVisitor() {
        files = new LinkedList<>();
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
        files.add(file);
    }
    public LinkedList<File> getFiles() {
        return files;
    }
}
