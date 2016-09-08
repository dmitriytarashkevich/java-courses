package level_3.classes;

import level_3.interfaces.BBehavior;

public class B implements BBehavior {
    public void showBBehavior() {
        System.out.println(this.getClass().getSimpleName() + " shows it's behavior:");
        this.showB();
        System.out.println(System.lineSeparator());
    }
}
