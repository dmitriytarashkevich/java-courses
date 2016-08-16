package Algorithms.greedy_algorithms.Huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Dmitry Tarashkevich on 18-Jun-16.
 */
public class HuffmanEncoder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Map <Character, Integer> frequencies = new HashMap<>();

        //get char-frequencies map
        final char[] chars = s.toCharArray();
        for (char c : chars) {
            frequencies.merge(c, 1, (x, y) -> x+y);
        }

        Map <Character,Node> charNode = new HashMap<>();
        PriorityQueue <Node> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            Leaf e = new Leaf(entry.getKey(), entry.getValue());
            queue.add(e);
            charNode.put(entry.getKey(), e);
        }

        //build tree
        int sum = 0;
        while (queue.size()>1){
            Node left = queue.poll();
            Node right = queue.poll();
            InternalNode internalNode = new InternalNode(left, right);
            queue.add(internalNode);
            sum += (internalNode.getFrequency());
        }

        if (frequencies.size() == 1){
            sum = s.length();
        }

        //print number of chars and length of encoded string (=sum of all frequencies)
        System.out.println(frequencies.size() + " " + sum);

        //Root is last node in queue
        Node root = queue.poll();
        String rootBinCode = frequencies.size() == 1 ? "0" : "";
        root.setBinCode(rootBinCode);

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            stringBuilder.append(charNode.get(c).getBinCode());
        }
        System.out.println(stringBuilder);
    }
}

class Node implements Comparable <Node>{

    private String binCode;
    private int frequency;

    public Node(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getBinCode() {
        return binCode;
    }

    public void setBinCode(String binCode) {
        this.binCode = binCode;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(frequency, o.frequency);
    }
}


class InternalNode extends Node{

    Node left;
    Node right;

    public InternalNode(Node left, Node right) {
        super(left.getFrequency() + right.getFrequency());
        this.left = left;
        this.right = right;
    }

    @Override
    public void setBinCode(String binCode) {
        super.setBinCode(binCode);
        left.setBinCode(binCode + "0");
        right.setBinCode(binCode + "1");
    }
}


class Leaf extends Node{

    char symbol;

    public Leaf(char symbol, int frequency) {
        super(frequency);
        this.symbol = symbol;
    }

    @Override
    public void setBinCode(String binCode) {
        super.setBinCode(binCode);
        System.out.println(symbol + ": " + binCode);
    }
}
