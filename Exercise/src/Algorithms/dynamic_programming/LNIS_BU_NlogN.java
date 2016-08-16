package Algorithms.dynamic_programming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Longest Nonincreasing Subsequence with recovery response

public class LNIS_BU_NlogN {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        new LNIS_BU_NlogN().run();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start + "ms");
    }

    private void run() throws IOException {

        int[] a = input();

//        lowerBound test
//        System.out.println(lowerBound(new int[] {14,8,8,0}, 7));

        int[][] arrays = findLNIS(a);
        int [] d = arrays[0];
        int [] p = arrays[1];
        int [] c = arrays[2];

        int length = printLNIS_length(d);
        for (int i : returnResult(a,p,c,length)) {
            System.out.print(i + " ");
        }
    }

    private int[] input() throws IOException {
        //Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("ExerciseIn.txt"));
        BufferedReader input = new BufferedReader(new FileReader("ExerciseIn.txt"));
        //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        //int n = input.nextInt();
        int [] a = new int[n];
        String[] tokens = input.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            //a[i] = input.nextInt();
            a[i] = Integer.parseInt(tokens[i]);
        }
        return a;
    }

    private int[][] findLNIS(int[] a) {
        int[] c = new int[a.length];
        int[] d = new int[a.length + 1];
        int[] p = new int[a.length + 1];
        for (int i : p) {
            i = -1;
        }
        for (int i = 0; i <= a.length; i++) {
            d[i] = Integer.MIN_VALUE;
        }
        d[0] = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int j = lowerBound(d,a[i]);
            if (d[j-1] >= a[i] && a[i] >= d[j]) {
                p[j] = i;
                c[i] = p[j-1];
                d[j] = a[i];
            }
        }
        c[0] = -1;
        return new int[][]{d,p,c};
    }

    private int printLNIS_length(int[] d){
        for (int i = d.length - 1; i >= 0 ; i--) {
            if (d[i]!= Integer.MIN_VALUE) {
                System.out.println(i);
                return i;
            }
        }
        return 1;
    }

    private int[] returnResult(int[] a, int[] p, int[] c, int length){
        int [] result = new int[length];
        for (int i = p[length];length > 0;length--) {
            result[length-1] = i+1;
            i = c[i];
        }
        return result;
//        outer:
//        for (int i = 0,c = 0; i < d.length; i++) {
//            if (d[i] != Integer.MAX_VALUE && d[i] != Integer.MIN_VALUE) {
//                for (; c < a.length;) {
//                    if (d[i] == a[c]) {
//                        System.out.print(c + 1 + " ");
//                        c++;
//                        continue outer;
//                    }
//                    c++;
//                }
//            }
//        }
    }

    private  int lowerBound(int[] array, int key){
        int leftBorder = -1;
        int rightBorder = array.length;
        int middle;
//        a[leftBorder] >= key
//        a[rightBorder] > x
        while (rightBorder > leftBorder + 1){
            middle = leftBorder + (rightBorder - leftBorder)/2;
            if(array[middle] >= key) leftBorder = middle;
            else rightBorder = middle;
        }
        return rightBorder;
    }
}

/*test:
input:
10
7 6 1 6 4 1 2 4 10 1
ans:
6
1 2 4 5 8 10

input:
5
0 5 5 5 5
ans:
4
2 3 4 5*/