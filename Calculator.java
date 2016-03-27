/** Класс Калькулятор, который содержит методы для сложения, вычитания, деления, умножения входящих аргументов и
 * возведения одного аргумента в степень другого
 */
public class Calculator {
    private double result; //внутренняя перемнная результат(изначально равная нулю)
    public void add(double ... params) { //метод сложения использующий массив аргументов params
        for (double param : params) { //для каждого аргумента param выполнять цикл
            this.result += param;//все аргументы прибавляются к result
        }
    }
    public void dif(double a, double b) {//метод вычитания двух входящих аргументов
        this.result = a-b;
    }
    public void mltp(double ... params) {//метод умножения
        /**изначально result присваиваем значение 1, чтобы можно было выполнить операцию
         * умножения с присваиванием. В остальном метод аналогичен методу сложения
         */
        this.result = 1;
        for (double param : params) {
            this.result *= param;
        }
    }
    public void dev(double a, double b) { // деление
        this.result = a/b;
    }
    public void inv(double a, double b) { //возведение в степень
        this.result = Math.pow(a, b);
    }
    public double getResult() { //присваиваем переменной типа public значение внутренней result для вывода в другом классе
        return this.result;
    }
    public void cleanResult() { //очитска результата
        this.result = 0;
    }
}