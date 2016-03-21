public class Calculator {
    private int result;
    public Calculator() {
    public void add(int ... params) {
        for (int param : params) {
            this.result += param;
        }
    }
    public int getResult() {
        return this.result;
    }
    public void cleanResult() {
        this.result = 0;
    }
}