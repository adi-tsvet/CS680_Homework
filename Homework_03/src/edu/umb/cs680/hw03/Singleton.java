package edu.umb.cs680.hw03;

public class Singleton{
    private Singleton(){};
    private static Singleton instance = null;
    public static Singleton getInstance(){
        if(instance==null)
            instance = new Singleton ();
        return instance;
    }
}


/*
Singleton instance = Singleton.getInstance();
instance.hashCode();
Singleton instance = Singleton.getInstance();
instance.hashCode();
 */


/* requireNonNull() can receive an error message, which is to be
contained in a NullPointerException.
public Foo()(String str){
this.str = Objects.requireNonNull(
str, “str must be non-null!!!”);
} }
 */