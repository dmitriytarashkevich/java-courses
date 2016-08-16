package OOP.Shapes;

import java.awt.*;

public class Rectangle extends Shape {

    public Rectangle(Color color, int a, int b) {
        super(color,a,b);
        super.setArea(a * b);
    }
}
