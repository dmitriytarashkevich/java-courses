package OOP.Shapes;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

public class StartShapeParty {
    public static void main(String[] args) {
        Shape[] shapes = fabricShapes();
        printShapes(shapes);
        findMaxArea(shapes);
    }

    private static Shape[] fabricShapes() {
        Shape circle = new Circle(Color.RED, 5);
        Shape square = new Square(Color.CYAN, 5);
        Shape rectangle = new Rectangle(Color.BLACK, 4 ,6);
        return new Shape[]{circle, square, rectangle};
    }

    private static void printShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    private static void findMaxArea(Shape[] shapes){
        Shape max = Collections.max(Arrays.asList(shapes));
        System.out.printf("Max area: %s %.3f\n", max.getClass().getSimpleName(), max.getArea());
    }
}
