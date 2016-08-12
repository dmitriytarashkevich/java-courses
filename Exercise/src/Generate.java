import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Generate {
    public static void main(String[] args) throws FileNotFoundException {
        new Generate().run();
    }

    private void run() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("ExerciseIn.txt");
        int m = 1000000;
        printWriter.println(m);
        Random random = new Random();
        for (int i = 0; i < m; i++) {
            printWriter.print(random.nextInt(10) + " ");
        }
        printWriter.close();
    }
}
