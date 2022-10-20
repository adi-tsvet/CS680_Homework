//Author: Prof. Junichi Suzuki
//Homework - 00

package edu.umb.cs680.hw00_ex;
//Class Calculator

public class Calculator1 {

    public float multiply(float x, float y){
        return x*y;
    }

    public float divide (float x, float y) {
        if(y==0){
            throw new IllegalArgumentException("division by zero");
        }
        return x/y;
    }

    public static void main(String[] args){
        Calculator1 calc = new Calculator1();
        System.out.println( calc.multiply(2, 3) );
        System.out.println( calc.divide(10, 2) );
    }

}