import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dmitry Tarashkevich on 19-Jun-16.
 */
public class BinarySearch {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("ExerciseIn.txt"));

        int sizeOfOrderedArray = scanner.nextInt();
        int[] ordered = Arrays.stream(
                scanner.nextLine().replaceFirst(" ", "").split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sizeOfKeysArray = scanner.nextInt();
        int[] keys = Arrays.stream(
                scanner.nextLine().replaceFirst(" ", "").split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int key : keys) {
            System.out.println(binarySearch(ordered,key));
        }
    }
    private static int binarySearch(int[] i, int key){
        int leftBorder = 0;
        int rightBorder = i.length - 1;
        int middle;
        while (leftBorder <= rightBorder){
            middle = leftBorder + (rightBorder - leftBorder)/2;
            if (i[middle] == key){
                return middle+1;

            } else {
                if (i[middle] < key){
                    leftBorder = middle + 1;
                } else {
                    rightBorder = middle - 1;
                }
            }
        }
        return -1;
    }
}
/*
* in
5 1 5 8 12 13
5 8 1 23 1 11
 out
 3 1 -1 1 -1*/
