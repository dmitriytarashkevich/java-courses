package Algorithms.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnapsackWithoutRepsBU {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        new KnapsackWithoutRepsBU().run();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start + "ms");
    }

    private void run() throws IOException {

        //Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("ExerciseIn.txt"));
//        BufferedReader input = new BufferedReader(new FileReader("ExerciseIn.txt"));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = input.readLine().split(" ");
        int capacity = Integer.parseInt(tokens[0]);
        int numberOfIngots = Integer.parseInt(tokens[1]);
        int[] ingots = new int[numberOfIngots];
        tokens = input.readLine().split(" ");
        for (int i = 0; i < numberOfIngots; i++) {
            //ingots[i] = input.nextInt();
            ingots[i] = Integer.parseInt(tokens[i]);
        }
        int[][] D = new int[capacity + 1][numberOfIngots + 1];

        for (int i = 0; i <= capacity; i++) {
            D[i][0] = 0;
        }
        for (int i = 0; i <= numberOfIngots; i++) {
            D[0][i] = 0;
        }
        for (int i = 1; i <= numberOfIngots; i++) {
            for (int j = 1; j <= capacity; j++) {
                D[j][i] = D[j][i - 1];
                if (ingots[i - 1] <= j) {
                    D[j][i] = Math.max(D[j][i], D[j - ingots[i - 1]][i - 1] + ingots[i - 1]);
                }
            }
        }
        System.out.println(D[capacity][numberOfIngots]);
    }
}
