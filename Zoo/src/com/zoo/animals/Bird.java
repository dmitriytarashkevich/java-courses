package com.zoo.animals;

/**
 * Created by dmitr on 02.04.2016.
 */
public class Bird extends Animal implements Actions{
    public Bird(String name, int mealValue, int teethQuantity){
        super(name, mealValue, teethQuantity);
    }
    public boolean play() {
        System.out.println("Cool!! But now " + getClass().getSimpleName()+" "+getName() + " want's to eat...");
        return true;
    }
}
