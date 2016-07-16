import java.util.Scanner;

/**
 * Created by Dmitry Tarashkevich on 12.06.2016.
 */
public class NODEuqlid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        while(true){
            if (m == 0){
                System.out.println(n);
                break;
            }
            if (n == 0){
                System.out.println(m);
                break;
            }
            if(m >= n) {
                m = m % n;
            } else {
                n = n % m;
            }
        }
    }
}
