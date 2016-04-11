import animalsPackage.*;

/**
 * Created by dmitr on 02.04.2016.
 */
public class Zoo {
    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Crocodile("Alex" ,80, 42);
        animals[1] = new Bird("Kesha" ,3, 2);
        animals[2] = new Snake("Josh" ,45, 2);
        animals[3] = new Crocodile("Philip" ,100, 80);
        for (Animal a: animals){
            System.out.println("Let's play with " + a.getClass().getSimpleName() +" "+ a.getName() + " and feed it");
            ((Actions)a).play();
            a.feed(90);
        }
    }
}
