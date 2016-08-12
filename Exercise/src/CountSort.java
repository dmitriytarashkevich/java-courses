import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSort {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        new CountSort().run();
        long finish = System.currentTimeMillis();
//        System.out.println(finish - start + "ms");
    }

    private void run() throws IOException {

        //Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("ExerciseIn.txt"));
//        BufferedReader input = new BufferedReader(new FileReader("ExerciseIn.txt"));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        //int n = input.nextInt();
        int[] a = new int[n];
        String[] tokens = input.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            //a[i] = input.nextInt();
            a[i] = Integer.parseInt(tokens[i]);
        }
        int m = 10; //number of different values
        for (int i : countSort(a,m)) {
            System.out.print(i + " ");
        }
    }

    private int[] countSort(int[] a, int m){
        int[] b = new int[m];
        int[] sorted = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[a[i]]++;
        }
        for (int i = 1; i < m; i++) {
            b[i]+= b[i-1];
        }
        for (int i = a.length - 1; i >= 0 ; i--) {
            sorted[b[a[i]] - 1] = a[i];
            b[a[i]]--;
        }
        return sorted;
    }
}
