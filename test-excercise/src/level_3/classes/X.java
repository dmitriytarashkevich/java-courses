package level_3.classes;

import level_3.interfaces.CBehavior;
import level_3.interfaces.DBehavior;

public class X implements CBehavior, DBehavior {
    public void showXBehavior() {
        System.out.println(this.getClass().getSimpleName() + " shows it's behavior:");
        this.showA();
        this.showB();
        this.showC();
        this.showD();
        System.out.println(System.lineSeparator());
    }
}
