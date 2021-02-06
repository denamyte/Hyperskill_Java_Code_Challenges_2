abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();

//    public static void main(String[] args) {
//        Shape[] shapes = new Shape[] {
//                new Circle(10),
//                new Triangle(3, 4, 5),
//                new Rectangle(5, 10)
//        };
//        for (Shape shape: shapes) {
//            System.out.println(shape.getPerimeter());
//            System.out.println(shape.getArea());
//        }
//    }
}

class Triangle extends Shape {

    private final double s1;
    private final double s2;
    private final double s3;

    Triangle(double s1, double s2, double s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    @Override
    double getPerimeter() {
        return s1 + s2 + s3;
    }

    @Override
    double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
    }
}

class Rectangle extends Shape {

    private final double s1;
    private final double s2;

    Rectangle(double s1, double s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    double getPerimeter() {
        return 2 * (s1 + s2);
    }

    @Override
    double getArea() {
        return s1 * s2;
    }
}

class Circle extends Shape {

    private double r;

    Circle(double r) {
        this.r = r;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    double getArea() {
        return Math.PI * r * r;
    }
}