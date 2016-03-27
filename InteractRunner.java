/** Класс запускает калькулятор, поддерживает ввод данных и вызывает необходимые методы из класса Calculator */
import java.util.Scanner; //импортируем класс для ввода
public class InteractRunner {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in); // создаем объект типа Scanner с именем reader
        try { //пробуем выполнить задачу
            Calculator calc = new Calculator();
            String UseResult = "y"; //создаем переменную для цикла while для использования результата
            String exit = "n"; //переменная для цикла while для выхода
            while (!exit.equals("y")) { //пока не выходим выполняем цикл вычисления
                System.out.println("Enter first argument: ");
                Double a = reader.nextDouble();
                System.out.println("Enter operator: ");
                String b = reader.next();
                System.out.println("Enter second argument: ");
                Double c = reader.nextDouble();
                switch (b) { //проверяем оператор и вызываем необходимый метод
                    case "+":
                        calc.add(a, c);
                        break;
                    case "-":
                        calc.dif(a, c);
                        break;
                    case "*":
                        calc.mltp(a, c);
                        break;
                    case "/":
                        calc.dev(a, c);
                        break;
                    case "^":
                        calc.inv(a, c);
                        break;
                }
                Double result = calc.getResult();
                System.out.println("Result: " + result); //вывод результата
                System.out.println("Use result: y/n"); //вопрос о дальнешем использовании результата
                UseResult = reader.next();
                while (!UseResult.equals("n")) { //выполняем цикл пока необходимо исопльзовать результат
                    System.out.println("Enter operator: ");
                    b = reader.next(); //ввод оператора, т к первый аргумент - result
                    System.out.println("Enter second argument: ");
                    c = reader.nextDouble();
                    switch (b) {
                        case "+":
                            calc.add(result, c);
                            break;
                        case "-":
                            calc.dif(result, c);
                            break;
                        case "*":
                            calc.mltp(result, c);
                            break;
                        case "/":
                            calc.dev(result, c);
                            break;
                        case "^":
                            calc.inv(result, c);
                            break;
                    }
                    result = calc.getResult(); //принимаем результат
                    System.out.println("Result: " + result); //выводим
                    System.out.println("Use result: y/n"); //вопрос о дальнешем использовании результата
                    UseResult = reader.next();
                }
                calc.cleanResult(); //очистка result если он не будет использоваться
                System.out.println("Exit: y/n"); //вопрос о выходе
                exit = reader.next();

            }
        } finally { // вне зависимости от выполненных действий закрываем сканер
            reader.close();
        }
    }
}