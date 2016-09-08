package level_3.second_version;

public interface D extends B {
    default void showD(){
        System.out.print("D ");
    };
}
