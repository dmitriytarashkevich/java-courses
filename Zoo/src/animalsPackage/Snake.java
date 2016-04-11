package animalsPackage;

/**
 * Created by dmitr on 02.04.2016.
 */
public class Snake extends Animal implements Actions{
    public Snake(String name, int mealValue, int teethQuantity){
        super(name, mealValue, teethQuantity);
    }
    public boolean play(){
            System.out.println("I don't wanna play with " + getClass().getSimpleName()+" "+ getName() + ". It is too angry.");
            return false;
    }
}
