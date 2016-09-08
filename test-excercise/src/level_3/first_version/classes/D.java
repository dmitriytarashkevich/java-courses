package level_3.first_version.classes;

import level_3.first_version.interfaces.DBehavior;

public class D implements DBehavior {
    public void showDBehavior() {
        System.out.println(this.getClass().getSimpleName() + " shows it's behavior:");
        this.showB();
        this.showD();
        System.out.println(System.lineSeparator());
    }
}
