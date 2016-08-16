package Algorithms.greedy_algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Dmitry Tarashkevich on 19-Jun-16.
 */
public class PriorityQueue {

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        run();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start + " ms");
    }
    private static void run() throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("ExerciseIn.txt"));
        int numberOfOperations = scanner.nextInt();
        String operation;
        MaxHeap maxHeap = new MaxHeap();
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> Integer.compare(y, x));
        for (int i = 0; i <= numberOfOperations; i++) {
            operation = scanner.nextLine();
            if(operation.contains("ExtractMax")){
                //System.out.println(maxHeap.poll());
                System.out.println(maxHeap.extractMax());
                continue;
            }
            if (operation.contains("Insert")){
                maxHeap.add(Integer.parseInt(operation.replaceAll("Insert ", "")));
            }
        }
    }
}

class MaxHeap {

    private ArrayList<Integer> heap;

    public MaxHeap(){
        heap = new ArrayList<>();
    }

    public int extractMax (){
        int max = heap.get(0);
        Collections.swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        siftDown(0);
        return max;
    }

    public void add(int i) {
        heap.add(i);
        siftUp(heap.size()-1);
    }

    private void siftDown(int nodeIndex) {
        int leftChild = getLeftChildIndex(nodeIndex);
        int rightChild = getRightChildIndex(nodeIndex);
        int max;
        // find max between left and right
        if (rightChild >= heap.size()) {
            if (leftChild >= heap.size()) return;
            else max = leftChild;
        } else max = Math.max(heap.get(leftChild),heap.get(rightChild));

        //swap with max
        if (heap.get(nodeIndex) < heap.get(max)) {
            Collections.swap(heap, nodeIndex, max);
            siftDown(max);
        }

    }

    private void siftUp(int nodeIndex) {
        int parent;
        if (nodeIndex != 0) {
            parent = getParentIndex(nodeIndex);
            if (heap.get(parent) < heap.get(nodeIndex)) {
                Collections.swap(heap,parent,nodeIndex);
                siftUp(parent);
            }
        }
    }

    private int getLeftChildIndex(int nodeIndex) {
        return 2 * nodeIndex + 1;
    }

    private int getRightChildIndex(int nodeIndex) {
        return 2 * nodeIndex + 2;
    }

    private int getParentIndex(int nodeIndex) {
        return (nodeIndex - 1) / 2;
    }
}

/*test{
        26
        Insert 200
        Insert 10
        ExtractMax
        Insert 5
        Insert 600
        ExtractMax
        Insert 220
        Insert 103
        ExtractMax
        Insert 59
        Insert 5070
        ExtractMax
        ExtractMax
        Insert 26800
        Insert 16460
        ExtractMax
        Insert 5654
        Insert 50640
        ExtractMax
        ExtractMax
        Insert 2070
        Insert 1700
        ExtractMax
        Insert 53
        Insert 10
        ExtractMax
        }*/
