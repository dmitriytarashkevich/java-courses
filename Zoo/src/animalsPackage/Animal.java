package animalsPackage;

/**
 * Created by dmitr on 02.04.2016.
 */
public class Animal {
    final public int teethQuantity;
    final public int mealValue;
    final private String name;
    public Animal(String name, int mealValue, int teethQuantity){
        this.teethQuantity=teethQuantity;
        this.mealValue=mealValue;
        this.name=name;
        }

    public String getName(){
            return name;
        }
    public void feed(int meal) {
        if (meal < this.mealValue) {
            System.out.println("Nom nom nom. " + getClass().getSimpleName()+" "+ getName() + " want's more...");
        } else {
            System.out.println("Nom nom nom. It's enough for " + getClass().getSimpleName()+" " +getName());
        }
    }


}
