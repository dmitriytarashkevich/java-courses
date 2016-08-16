package Algorithms.greedy_algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dmitry Tarashkevich on 14.06.2016.
 */
public class N_LikeSumOfMaxK_numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = new ArrayList<>();
        int sum = 0;
        for (int i = 1; (sum + i) <= n; i++){
            sum += i;
            summands.add(i);
        }
        if (sum < n){
            int lastSummand = summands.get(summands.size()-1);
            int dif = n - sum;
            summands.set(summands.size()-1,lastSummand + dif);
        }
        System.out.println(summands.size());
        summands.forEach(System.out::println);
    }
}
