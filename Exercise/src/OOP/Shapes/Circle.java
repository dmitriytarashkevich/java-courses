package OOP.Shapes;

import java.awt.*;

public class Circle extends Shape {
    public Circle(Color color, int radius) {
        super(color, radius);
        super.setArea(Math.PI * Math.pow(radius,2));
    }
}
