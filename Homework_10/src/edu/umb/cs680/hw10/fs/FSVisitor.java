package edu.umb.cs680.hw10.fs;

public interface FSVisitor {

    void visit(Link link);
    void visit(Directory dir);
    void visit(File file);

}
