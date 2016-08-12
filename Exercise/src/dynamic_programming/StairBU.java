package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StairBU {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        new StairBU().run();
        long finish = System.currentTimeMillis();
//        System.out.println(finish - start + "ms");
    }

    private void run() throws IOException {

        //Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("ExerciseIn.txt"));
        BufferedReader input = new BufferedReader(new FileReader("ExerciseIn.txt"));
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        //int n = input.nextInt();
        int[] a = new int[n];
        String[] tokens = input.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            //a[i] = input.nextInt();
            a[i] = Integer.parseInt(tokens[i]);
        }

        System.out.println(getSumOfStairs(a));
    }

    private int getSumOfStairs(int[] a) {
        int[] d = new int[a.length + 1];
        d[0] = 0;
        if (a.length > 0) d[1] = a[0];
        for (int i = 2 ; i <= a.length; i++) {
            d[i] = Math.max(d[i-1] + a[i-1], d[i-2]+a[i - 1]);
        }
        return d[a.length];
    }
}

/*3
-1 2 1
ans: 3

8
3 4 10 10 0 -6 -10 0
ans: 21*/
