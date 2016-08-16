package Java;

import java.util.Scanner;

/**
 * Created by dmitr on 16.05.2016.
 */

/*Напишите программу, читающую текст из System.in
и выводящую в System.out сумму всех встреченных в тексте вещественных чисел
 с точностью до шестого знака после запятой.
 Числом считается последовательность символов,
 отделенная от окружающего текста пробелами или переводами строк
 и успешно разбираемая методом Double.parseDouble.*/


public class SumOfAllDoubles {
    public static void main(String[] args) {
        double sum = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            try {
                sum+=Double.parseDouble(scanner.next());
            }
            catch (NumberFormatException e) {}
        }
        System.out.format("%.6f",sum);
    }
}
