package level_3.first_version.interfaces;

public interface DBehavior extends BBehavior{
    default void showD(){
        System.out.print("D ");
    };
}
