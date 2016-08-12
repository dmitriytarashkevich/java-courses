import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Dmitry Tarashkevich on 11.06.2016.
 */
public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();//n число Фибоначи
        int m = scanner.nextInt();//делим на m
        int buffer;
        ArrayList arrayList = new ArrayList();
        boolean endOfPizanoPeriod = false;
        int a = 1; //F(n)
        int b = 0; //F(n-1)
        int k = 0; //счетчик длинны периода Пизано
        if (n > 1) {
            for (long i = 2; i <= n; i++) {
                k = k + 1;
                buffer = a;
                a = (a + b) % m;
                b = buffer;
                System.out.println(i + " " + k + " " + a + " " + b);
                if (a == 1 & b == 0) {
                    endOfPizanoPeriod = true;
                    break;
                } // как только в последовательности остатков встречается 0,1 период закончен
                //длинна периода - k
            }
            //теперь исчем остаток, но уже не по всей длинне последовательности а по одному периоду
            if (endOfPizanoPeriod) {
                for (long i = 2; i < (n % k) + 1; i++) {
                    buffer = a;
                    a = (a + b) % m;
                    b = buffer;
                    System.out.println(i + " " + a + " " + b);
                }
            }
        }
        System.out.println(a);
    }
}
/*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();//n число Фибоначи
        int m = scanner.nextInt();//делим на m
        System.out.println(getFibonacciRest(n,m));

    }
    private static ArrayList<Long> getSequencePeriod(long m){
        ArrayList<Long> s = new ArrayList();
        s.add((long)0);
        s.add((long)1);
        for(int i = 2; i < m * 6; i++){
            s.add((s.get(i - 1) + s.get(i - 2)) % m);
            if(s.get(i) == 1 && s.get(i-1) == 0){
                break;
            }
        }
        return s;
    }
    private static long getFibonacciRest(long n, long m){
        ArrayList<Long> s = getSequencePeriod(m);
        long period = s.size() - 2; // находим период Пизано
        int val = (int)(n % period);
        return s.get(val);
    }*/
