package dynamic_programming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*уменьшить память
* восстановление решения
* ускорить
* для <T>*/

public class EditDistBU {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        new EditDistBU().run();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start + "ms");
    }

    private void run() throws IOException {

        //Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("ExerciseIn.txt"));
        BufferedReader input = new BufferedReader(new FileReader("ExerciseIn.txt"));
        //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        char[] first = input.readLine().toCharArray();
        char[] second = input.readLine().toCharArray();
        System.out.println(getEditDistance(first,second));
    }

    private int getEditDistance(char[] first, char[] second){
        int[][] d = new int[first.length + 1][second.length + 1];
        for (int i = 0; i <= first.length; i++) {
            d[i][0] = i;
        }
        for (int i = 1; i <= second.length; i++) {
            d[0][i] = i;
        }
        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                d[i][j] = Math.min(d[i-1][j-1] + isDifferent(first[i-1], second[j-1]),
                        Math.min(d[i-1][j] + 1,
                                d[i][j-1] + 1));
                //System.out.println(i + " " + j);
            }
        }
        return d[first.length][second.length];
    }

    private byte isDifferent(Object a, Object b){
        if (a.equals(b)) return 0;
        else return 1;
    }
}
