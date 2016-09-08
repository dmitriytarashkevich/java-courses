package level_3.first_version.interfaces;

public interface CBehavior extends ABehavior{
    default void showC(){
        System.out.print("C ");
    };
}
