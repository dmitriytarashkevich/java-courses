import java.util.Scanner;

/**
 * Created by Dmitry Tarashkevich on 11.06.2016.
 */
public class Fibonachi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();//n число Фибоначи
        int m = scanner.nextInt();//делим на m
        int buffer;
        boolean isEndOfPizanoPeriod = false;
        int a = 1; //F(n)
        int b = 0; //F(n-1)
        int k = 0; //счетчик длинны периода Пизано
        if (n>1) {
            for (long i = 2; i <= n; i++) {
                k = k + 1;
                buffer = a;
                a = (a+b) % m;
                b = buffer;
                System.out.println(i + " " + k + " " + a + " " + b);
                if (a == 1 & b == 0) {
                    isEndOfPizanoPeriod = true;
                    break;
                } // как только в последовательности остатков встречается 0,1 период закончен
                //длинна периода - k
            }
            //теперь исчем остаток, но уже не по всей длинне последовательности а по одному периоду
            if(isEndOfPizanoPeriod) {
                for (long i = 2; i < (n % k) + 1; i++) {
                    buffer = a;
                    a = (a + b) % m;
                    b = buffer;
                    System.out.println(i + " " + a + " " + b);
                }
            }
        }
        System.out.println(a);
    }/*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//n число Фибоначи
        int m = scanner.nextInt();//делим на m
        int[] fibonachis =new int[n];
        fibonachis[0] = 1;
        if (n>1) {
            fibonachis[1] = 1;
            for (int i = 2; i < n; i++) {
                fibonachis[i] = (fibonachis[i - 1] + fibonachis[i - 2])%m;
            }
        }
        System.out.println(fibonachis[n-1]);
    }*/
}
