package com.driver;
public class Main {
  public static class A {
    //defining a method
    public String meth() {return "Invoking method from class A";}
  }
  //Creating a child class
  public static class B extends A{
    //defining the same method as in the parent class
    @Override
    public String meth() { return "Method is overridden in Extendend class B";}
  }
  public static void main(String[] args) {
    B obj = new B();//creating object
    obj.meth();//calling method
    B obj1 = new B();//creating object
    obj1.meth();//calling method
  }
}

