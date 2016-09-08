package level_3.interfaces;

public interface DBehavior extends BBehavior{
    default void showD(){
        System.out.print("D ");
    };
}
