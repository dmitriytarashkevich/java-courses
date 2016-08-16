package OOP.christmas_tree;

public class LetsChristmas {
    public static void main(String[] args) {

        Tree christmasTree = new Tree();
        Toy yellow1 = new Toy(Toy.Color.Yellow);
        Toy blue = new Toy(Toy.Color.Blue);
        Toy green = new Toy(Toy.Color.Green);
        Toy yellow2 = new Toy(Toy.Color.Yellow);
        christmasTree.addToy(yellow1);
        christmasTree.addToy(yellow2);
        christmasTree.addToy(blue);
        christmasTree.addToy(green);

        //How much YELLOW toys on tree?
        System.out.println(christmasTree.getToys().get(Toy.Color.Yellow));
    }
}
