package OOP.christmas_tree;

public class Toy {

    private Color color;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        return color == toy.color;

    }

    @Override
    public int hashCode() {
        return color != null ? color.hashCode() : 0;
    }

    private Tree tree;

    public Toy(Color color) {
        this.color = color;
        this.tree = null;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    enum Color {Blue, Green, Yellow, Red, Pink}

}
