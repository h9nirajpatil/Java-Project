package com.driver;
public class Main
{
    public static class Product
    {
        public int product(int x , int y)
        {
            int a = x * y;
            return a;
        }
        public int product(int x , int y , int z)
        {
            int b = x * y * z;
            return b;
        }
        public double product(double x , double y)
        {
            double c = x * y;
            return c;
        }
    }
    public static void main(String[] args)
    {
        Product p = new Product();
        System.out.println( p.product(2,3) );
        System.out.println( p.product(2,3,4) );
        System.out.println( p.product(6.98,7.789) );
    }
}