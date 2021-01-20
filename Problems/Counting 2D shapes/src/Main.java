import java.util.Arrays;

class Counter {
    public static int count2DShapes(Shape[] shapes) {
        return (int) Arrays.stream(shapes).filter(Counter::isShape2DSuccessor).count();
    }

    static boolean isShape2DSuccessor(Shape shape) {
        return shape instanceof Shape2D && Shape2D.class != shape.getClass();
    }

//    public static void main(String[] args) {
//        Shape[] shapes = {
//                new Shape(),
//                new Shape2D(),
//                new Shape2D(),
//                new Shape3D(),
//                new Circle(),       // 1st
//                new Shape2DSub1(),  // 2nd
//                new Shape2DSub2(),  // 3rd, total 3
//                new Cube(),
//                new Shape3DSub1(),
//                new Shape3DSub2(),
//        };
//        System.out.println(count2DShapes(shapes));
//    }
}

// Don't change the code below

class Shape {
}

class Shape2D extends Shape {
}

class Shape3D extends Shape {
}


class Circle extends Shape2D {
}

class Shape2DSub1 extends Shape2D {
}

class Shape2DSub2 extends Shape2D {
}


class Cube extends Shape3D {
}

class Shape3DSub1 extends Shape3D {
}

class Shape3DSub2 extends Shape3D {
}