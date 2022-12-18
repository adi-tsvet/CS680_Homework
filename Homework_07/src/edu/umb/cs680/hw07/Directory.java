package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    private LinkedList<FSElement> children;
    private LinkedList<Directory> directory;
    private LinkedList<File> file;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        if(parent!= null) {
            parent.appendChild(this);
        }
        children = new LinkedList<>();
        directory = new LinkedList<>();
        file = new LinkedList<>();
    }

    public LinkedList<FSElement> getChildren(){
        return this.children;
    }

    public void appendChild (FSElement child){
        this.children.add(child);
    }

    public int countChildren(){

        int count=0;
        for(FSElement f: this.children) {
            count+=1;
        }
        return count;
    }

    public LinkedList<Directory> getSubDirectories(){

        for(FSElement fsElement: getChildren()) {
            if(fsElement instanceof Directory) {
                directory.add((Directory) fsElement);
            }
        }
        return directory;
    }

    public LinkedList<File> getFiles(){

        for(FSElement fsElement: getChildren()) {
            if(fsElement instanceof File) {
                file.add((File) fsElement);
            }
        }
        return file;
    }

    public int getTotalSize(){

        int totalSize=0;
        for(FSElement fsElement: getChildren()) {
            if(fsElement instanceof Directory) {
                totalSize+= ((Directory)fsElement).getTotalSize();
            }
            else {
                totalSize+= fsElement.getSize();
            }
        }
        return totalSize;
    }

    @Override
    public boolean isDirectory() {
        if(this instanceof Directory) {
            return true;
        }
        return false;
    }

}
