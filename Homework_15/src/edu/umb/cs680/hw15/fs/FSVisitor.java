package edu.umb.cs680.hw15.fs;

public interface FSVisitor {

    void visit(Link link);
    void visit(Directory dir);
    void visit(File file);

}
