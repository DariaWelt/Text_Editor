abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {

    double aLen, bLen, cLen;

    public Triangle(double aLen, double bLen, double cLen) {
        this.aLen = aLen;
        this.bLen = bLen;
        this.cLen = cLen;
    }

    @Override
    double getPerimeter() {
        return aLen + bLen + cLen;
    }

    @Override
    double getArea() {
        double p = getPerimeter() / 2;
        double area = p * (p - aLen) * (p - bLen) * (p - cLen);
        area = Math.sqrt(area);
        return area;
    }
}

class Rectangle extends Shape {

    double aLen, bLen;

    public Rectangle(double aLen, double bLen) {
        this.aLen = aLen;
        this.bLen = bLen;
    }

    @Override
    double getPerimeter() {
        return 2 * (aLen + bLen);
    }

    @Override
    double getArea() {
        return aLen * bLen;
    }
}

class Circle extends Shape {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}