package animalsPackage;

/**
 * Created by dmitr on 02.04.2016.
 */
public class Crocodile extends Animal implements Actions{
    public Crocodile(String name, int mealValue, int teethQuantity){
        super(name, mealValue, teethQuantity);
    }
    public boolean play(){
        if (this.teethQuantity>Actions.maxTeethQuantity){
            System.out.println("I don't wanna play with "+ getClass().getSimpleName()+" " + getName() + ". It is too angry.");
            return false;
        } else {
            System.out.println("Cool!! But now "+ getClass().getSimpleName()+" " + getName() + " want's to eat...");
            return true;
        }

    };
}
