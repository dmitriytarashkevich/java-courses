package level_3.second_version;

public interface DBehavior extends BBehavior {
    default void showD(){
        System.out.print("D ");
    };
}
