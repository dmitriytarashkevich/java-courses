package OOP.ChristmasTree;

import java.util.HashMap;

public class Tree {

    private HashMap toys;

    public Tree() {
        this.toys = new HashMap<Toy.Color, Integer>();
    }

    public void addToy(Toy toy){
        if (toy.getTree()!=this) toy.setTree(this); else return;
        this.toys.merge(toy.getColor(), 1 , (x,y)->(Integer) x + (Integer) y );
    }

    public void removeToy(Toy toy){
        if (toy.getTree()== this) toy.setTree(null); else return;
        toys.replace(toy.getColor() , (Integer) toys.get(toy.getColor()) - 1);
    }

    public HashMap getToys() {
        return toys;
    }
}
