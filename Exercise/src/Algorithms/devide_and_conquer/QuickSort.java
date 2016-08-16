package Algorithms.devide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10; i++) {
//            run();
//        }
        run();
        long finish = System.currentTimeMillis();
        //System.out.println(finish - start + "ms");
    }

    private static void run() throws IOException {

        //Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("ExerciseIn.txt"));
//        BufferedReader input = new BufferedReader(new FileReader("input.txt");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = input.readLine().split(" ");
        //int nSegments = input.nextInt(), nPoints = input.nextInt();
        int nSegments = Integer.parseInt(temp[0]);
        int[] segmentsStart = new int[nSegments];
        int[] segmentsEnd = new int[nSegments];
        int nPoints = Integer.parseInt(temp[1]);
        for (int i = 0; i < nSegments; i++) {
//            a[i] = input.nextInt();
//            segmentsStart[i] = input.nextInt();
//            segmentsEnd[i] = input.nextInt();
            temp = input.readLine().split(" ");
            segmentsStart[i] = Integer.parseInt(temp[0]);
            segmentsEnd[i] = Integer.parseInt(temp[1]);

            //input test
            //System.out.println(segmentsStart[i] + " " + segmentsEnd[i]);
        }
        int[] points = new int[nPoints];
        temp = input.readLine().split(" ");
        for (int i = 0; i < nPoints; i++) {
            points[i] = Integer.parseInt(temp[i]);

            //input test
            //System.out.println(points[i]);
        }
//        sort(segmentsStart, segmentsEnd, points);

        quickSort(segmentsStart, 0, nSegments - 1);
        quickSort(segmentsEnd, 0, nSegments - 1);

        //sort test
//        for (int i : segmentsStart) {
//            System.out.println(i);
//        }

        for (int point : points) {
            System.out.print(binarySearchForStartPoints(segmentsStart,point) -
                    binarySearchForEndPoints(segmentsEnd,point)  +" ");
        }
        System.out.println();


        //sort test
//        int[] b = new int[]{1,3,5,2,5,7,3,2,65,8};
//        quickSort(b,0,9);
//        for (int i : b) {
//            System.out.println(i);
//        }

        // partition test
//        int [] a = new int[]{3, 1, 2, 3, 3, 3, 3, 3, 3, 5};
//        for (int i : partition(a, 0, 9)) {
//            System.out.println(i);
//        }
//        for (int i : a) {
//            System.out.print(i + " ");
//        }

        //search test
//        System.out.println(binarySearchForEndPoints(new int[] {0,1,2,2,2,2,2,2,3,4,4,4,4,4,8,14}, 7));

        //swap test
//        int[] ints = {1, 3, 2};
//        swap(ints, 1, 2);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
    }

    private static void quickSort(int[] a, int l, int r) {
        if(l >= r) return;
        int[] pivots;
        while (l < r) {
            pivots = partition(a, l, r);
            quickSort(a, l, pivots[0]);
            l = pivots[1] + 1;
        }
    }

    private static int[] partition(int[] a, int l, int r) {
        int k;
        swap(a, l, k = new Random().nextInt(r - l + 1) + l);
        int pivot = a[l], j = l, h = j;

        //1 проход для ахуенных
        for (int i = l + 1; i <= r; i++) {
            if (a[i] == pivot) {
                j++;
                swap(a,i,j);
                }
            if (a[i] < pivot){
                j++;
                h++;
                swap(a, j , i);
                swap(a, j, h);
                }
            }

        //2 прохода для лохов
//        for (int i = l + 1; i <= r; i++) {
//            if (a[i] <= pivot) {
//                j++;
//                swap(a, j, i);
//            }
//        }
//        for (int i = l + 1; i <= j; i++) {
//            if (a[i] < pivot) {
//                h++;
//                swap(a, h, i);
//            }
//        }

        swap(a, l, h);
        return new int[]{h ,j};
    }

    public static final  void swap (int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static int binarySearchForEndPoints(int[] array, int key){
        int leftBorder = -1;
        int rightBorder = array.length;
        int middle;
//        a[leftBorder] < key
//        a[rightBorder] >= x
        while (rightBorder > leftBorder + 1){
            middle = leftBorder + (rightBorder - leftBorder)/2;
            if(array[middle] < key) leftBorder = middle;
            else rightBorder = middle;
        }
        return rightBorder;
    }

    private static int binarySearchForStartPoints(int[] array, int key){
        int leftBorder = -1;
        int rightBorder = array.length;
        int middle;
//        a[leftBorder] <= key
//        a[rightBorder] > x
        while (rightBorder > leftBorder + 1){
            middle = leftBorder + (rightBorder - leftBorder)/2;
            if(array[middle] <= key) leftBorder = middle;
            else rightBorder = middle;
        }
        return leftBorder + 1;
    }

//    private static void sort(int[] start, int[] end, int[] points){
//        Arrays.sort(start);
//        Arrays.sort(end);
//        for (int point : points) {
//            int j = 0,h = 0;
//            for (int i = 0; i < start.length; i++) {
//                if (point >= start[i]) j++;
//            }
//            for (int i = 0; i < end.length; i++) {
//                if (point > end[i]) h++;
//            }
//            System.out.print(j - h + " ");
//        }
//    }
}

/*
in
10 10
9 9
9 9
1 3
9 9
9 9
7 7
5 8
9 10
7 10
2 10
5 5 9 8 0 6 3 8 9 0
out
2 2 7 3 0 2 2 3 7 0*/
