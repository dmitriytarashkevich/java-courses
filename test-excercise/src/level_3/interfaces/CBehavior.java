package level_3.interfaces;

public interface CBehavior extends ABehavior{
    default void showC(){
        System.out.print("C ");
    };
}
