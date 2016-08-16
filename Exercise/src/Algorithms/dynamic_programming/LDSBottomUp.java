package Algorithms.dynamic_programming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LDSBottomUp {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        new LDSBottomUp().run();
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
        int[] a = new int[n];
        String[] tokens = input.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            //a[i] = input.nextInt();
            a[i] = Integer.parseInt(tokens[i]);
        }
        System.out.println(lds(a));
    }

    private int lds(int[] a) {
        int length = a.length;
        int[] d = new int[length];
        for (int i = 0; i < length; i++) {
            d[i] = 1;
            for (int j = 0; j < i ; j++) {
                if (a[i] % a[j] == 0 && d[j] + 1 > d[i]) d[i] = d[j] + 1;
            }
        }
        int MaxLength = 0;
        for (int i = 0; i < length; i++) {
            MaxLength = Math.max(MaxLength, d[i]);
        }
        return MaxLength;
    }
}
/*18
1 4 4 6 7 9 12 14 14 15 17 20 22 24 24 27 30 30
ans: 6*/