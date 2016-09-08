package level_3.second_version;

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
