package level_3.first_version.classes;

import level_3.first_version.interfaces.CBehavior;

public class C implements CBehavior {
    public void showCBehavior() {
        System.out.println(this.getClass().getSimpleName() + " shows it's behavior:");
        this.showA();
        this.showC();
        System.out.println(System.lineSeparator());
    }
}
