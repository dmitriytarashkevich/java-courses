package OOP.Shapes;

import java.awt.*;

public abstract class Shape implements HasArea, Comparable{

    private double area;
    private Color color;
    private int[] sizes;

    public Shape(Color color, int... sizes) {
        this.color = color;
        this.sizes = sizes;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + ":\n" + "\tsizes: ");
        for (int size : sizes) {
            sb.append(size + " ");
        }
        sb.append(String.format("\n\tarea: %.3f", this.area));
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(this.area,((Shape) o).getArea());
    }

    @Override
    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public double getArea() {
        return area;
    }
}
