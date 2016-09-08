package level_3.first_version.classes;

import level_3.first_version.interfaces.BBehavior;

public class B implements BBehavior {
    public void showBBehavior() {
        System.out.println(this.getClass().getSimpleName() + " shows it's behavior:");
        this.showB();
        System.out.println(System.lineSeparator());
    }
}
