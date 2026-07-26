[11:53 pm, 24/07/2026] deekshithapunuru Deeshitha: import java.util.Scanner;

interface Shape {
    double calculateArea();
    void displayDetails();
}

class Circle implements Shape {
    private double radius; 

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void displayDetails() {
        System.out.println("Circle:");
        System.out.println("Radius = " + radius);
        System.out.println("Area of Circle = " + calculateArea());
    }
}

class Rectangle implements Shape {
    private double length; 
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Overrid…
[11:53 pm, 24/07/2026] deekshithapunuru Deeshitha: import java.util.Scanner;

class PiCalculator {
    private int terms;
    public static final double EXACT_PI = Math.PI;

    public PiCalculator(int terms) {
        this.terms = terms;
    }

    public double getPiValue() {
        double pi = 0.0;
        for (int i = 0; i < terms; i++) {
            pi += Math.pow(-1, i) / (2 * i + 1);
        }
        return pi * 4;
    }

    protected void displayPrecisionInfo() {
        System.out.println("Protected Method - Displaying Precision Info:");
        System.out.println("Precision used: " + terms + " terms");
        System.out.println("Series used: Leibniz Series (4/1 - 4/3 + 4/5 - 4/7 + 4/9 ...)");
    }

    public void displayPrivateData() {
        System.out.println("Private Data - Accessed only 
