package level_3.first_version.classes;

import level_3.first_version.interfaces.ABehavior;

public class A implements ABehavior {
    public void showABehavior() {
        System.out.println(this.getClass().getSimpleName() + " shows it's behavior:");
        this.showA();
        System.out.println(System.lineSeparator());
    }
}
