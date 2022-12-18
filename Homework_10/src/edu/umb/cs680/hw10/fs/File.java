package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.securityContext.*;

import java.time.LocalDateTime;

public class File extends FSElement {

    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    public boolean isDirectory() {
        return false;
    }

    public boolean isFile() {
        return true;
    }

    public boolean isLink() {
        return false;
    }

    @Override
    public void accept(FSVisitor v, SecurityContext ctx) {
        if(ctx.isActive()){
            v.visit(this);
        }
        else{
            System.out.print("User needs to login to search a File");
        }
    }
}
