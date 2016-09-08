package level_3.second_version;

public interface C extends A {
    default void showC(){
        System.out.print("C ");
    };
}
