/*Напишите программу, которая прочитает из System.in последовательность целых чисел,
разделенных пробелами, затем удалит из них все числа, стоящие на четных позициях,
и затем выведет получившуюся последовательность в обратном порядке в System.out.

Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.

В этом задании надо написать программу целиком, включая import'ы, декларацию класса Main и метода main.

Sample Input:
1 2 3 4 5 6 7
Sample Output:
6 4 2*/
import java.io.ByteArrayInputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Dmitry Tarashkevich on 20.05.2016.
 */
public class OnlyEvenAndDescending {
    public static void main(String[] args) {
        ByteArrayInputStream in = new ByteArrayInputStream(new byte [] {1,2,3,4,5,6});
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0; //счетчик для определения четных элементов
        while (scanner.hasNext()){
            i++;
            if (i % 2 == 0){ //либо можно ( i & 1 )==0
                deque.add(scanner.nextInt()); //если четный - пишем в
            } else {
                scanner.next(); // если нечетн
            }
        }
        Iterator<Integer>  iter = deque.descendingIterator();
        while (iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
    }
}
