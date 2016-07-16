/*Необходимо посчитать число пар индексов 1≤i<j≤n, для которых A[i]>A[j]
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class InversionMergeSort {

    static int counter = 0;

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("ExerciseIn.txt"));
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
            //System.out.println(arr[i]);
        }
        int[] sorted = sortMerge(arr);
        /*for (int i : sorted) {
            System.out.print(i + " ");
        }*/
        System.out.println(counter);
    }
    private static int[] sortMerge(int[] arr) {
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
                sortMerge(Arrays.copyOfRange(arr, middle, len)));
    }
    private static int[] merge(int[] left, int[] right) {
        int leftLength = left.length, rightLength = right.length;
        int l = 0, r = 0, len = leftLength + rightLength; // l, r - счетчики в массивах
        int[] result = new int[len];
        while (l < left.length || r < right.length) {
            if (l == left.length) {
                result[l+r] = right[r];
                r++;
            } else if (r == right.length) {
                result[l+r] = left[l];
                l++;
            } else if (left[l] <= right[r]) {
                result[l+r] = left[l];
                l++;
            } else {
                result[l+r] = right[r];
                counter += left.length-l;
                r++;
            }
        }
        return result;
    }
}
