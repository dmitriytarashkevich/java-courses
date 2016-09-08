package level_3.classes;

import level_3.interfaces.ABehavior;

public class A implements ABehavior {
    public void showABehavior() {
        System.out.println(this.getClass().getSimpleName() + " shows it's behavior:");
        this.showA();
        System.out.println(System.lineSeparator());
    }
}
