package edu.umb.cs680.hw13.fs;

public interface FSVisitor {

    void visit(Link link);
    void visit(Directory dir);
    void visit(File file);

}
