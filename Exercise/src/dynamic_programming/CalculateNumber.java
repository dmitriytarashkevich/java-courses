package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//operations: x2, x3, +1

public class CalculateNumber {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        new CalculateNumber().run();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start + "ms");
    }

    private void run() throws IOException {

        //Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("ExerciseIn.txt"));
        BufferedReader input = new BufferedReader(new FileReader("ExerciseIn.txt"));
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        //int n = input.nextInt();
        int[] operationsForN = calculate(n);
        System.out.println(operationsForN[n]);
        for (int i : returnResult(operationsForN)) {
            System.out.print(i + " ");
        }
    }

    private int[] calculate(int n) {
        int[] d = new int[n + 1];
        if (n > 1) d[1] = 0; //1
        if (n > 2) d[2] = 1; //2
        for (double i = 2; i <= n; i++) {
            double a = i/2 == (int) i/2 ? d[(int) (i/2)] + 1 : Double.POSITIVE_INFINITY;
            double b = i/3 == (int) i/3 ? d[(int) (i/3)] + 1 : Double.POSITIVE_INFINITY;
            int c = d[(int)i-1] + 1;
            d[(int) i] = (int) Math.min(a, Math.min(b,c));
        }
        return d;
    }

    private int[] returnResult(int[] d){
        int n = d.length - 1; //n - our number
        int[] result = new int[d[n] + 1]; //initialize array where n is last element
        result[d[n]] = n;
        double i = d.length - 1;
        for (int j = d[n] - 1; j >= 0 && i != 1 ; j--) {
            double a = i/2 == (int) i/2 ? d[(int) (i/2)]  : Double.POSITIVE_INFINITY;
            double b = i/3 == (int) i/3 ? d[(int) (i/3)]  : Double.POSITIVE_INFINITY;
            int c = d[(int)i-1];
            double temp = Math.min(a, Math.min(b,c));
            if (temp == a) i = i/2;
            else if (temp == b) i = i/3;
            else if (temp == c) i = i - 1;
            result[j] = (int) i;
        }
        return result;
    }
}

/*96234
* ans:
* 14
1 3 9 10 11 33 99 297 891 2673 8019 16038 16039 48117 96234*/