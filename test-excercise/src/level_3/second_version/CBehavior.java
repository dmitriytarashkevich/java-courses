package level_3.second_version;

public interface CBehavior extends ABehavior {
    default void showC(){
        System.out.print("C ");
    };
}
