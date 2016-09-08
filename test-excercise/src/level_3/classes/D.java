package level_3.classes;

import level_3.interfaces.DBehavior;

public class D implements DBehavior {
    public void showDBehavior() {
        System.out.println(this.getClass().getSimpleName() + " shows it's behavior:");
        this.showB();
        this.showD();
        System.out.println(System.lineSeparator());
    }
}
