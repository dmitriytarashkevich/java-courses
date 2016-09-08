package level_3;

import level_3.classes.*;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        X x = new X();

        a.showABehavior();
        b.showBBehavior();
        c.showCBehavior();
        d.showDBehavior();
        x.showXBehavior();
    }
}
