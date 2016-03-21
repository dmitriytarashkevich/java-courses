public class Calculator {
    private double result;
    public void add(double ... params) {
        for (double param : params) {
            this.result += param;
        }
    }
    public void dif(double a, double b) {
        this.result = a-b;
    }
    public void mltp(double ... params) {
        this.result = 1;
        for (double param : params) {
            this.result *= param;
        }
    }
    public void dev(double a, double b) {
        this.result = a/b;
    }
    public void inv(double a, double b) {
        this.result = Math.pow(a, b);
    }
    public double getResult() {
        return this.result;
    }
    public void cleanResult() {
        this.result = 0;
    }
}