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

        final char[] chars = s.toCharArray();
        for (char c : chars) {
            if (frequencies.containsKey(c)){
                frequencies.put(c, frequencies.get(c) + 1);
            } else {
                frequencies.put(c,1);
            }
        }

        Map <Character,Node> charNode = new HashMap<>();
        PriorityQueue <Node> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            Leaf e = new Leaf(entry.getKey(), entry.getValue());
            queue.add(e);
            charNode.put(entry.getKey(), e);
        }
        int sum = 0;
        while (queue.size()>1){
            Node left = queue.poll();
            Node right = queue.poll();
            queue.add(new InternalNode(left, right));
            sum += (left.frequency + right.frequency);
        }

        if (frequencies.size() == 1){
            sum = s.length();
        }

        System.out.println(frequencies.size() + " " + sum);
        Node root = queue.poll();
        if ( frequencies.size() == 1 ){
            root.setBinCode("0");
        } else {
            root.setBinCode("");
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            stringBuilder.append(charNode.get(c).binCode);
        }
        System.out.println(stringBuilder);
    }
}

class Node implements Comparable <Node>{
    public Node(int frequency) {
        this.frequency = frequency;
    }

    String binCode;
    int frequency;

    public void setBinCode(String binCode) {
        this.binCode = binCode;
    }
    @Override
    public int compareTo(Node o) {
        return Integer.compare(frequency, o.frequency);
    }
}


class InternalNode extends Node{
    public InternalNode(Node left, Node right) {
        super(left.frequency + right.frequency);
        this.left = left;
        this.right = right;
    }

    Node left;
    Node right;

    @Override
    public void setBinCode(String binCode) {
        super.setBinCode(binCode);
        left.setBinCode(binCode + "0");
        right.setBinCode(binCode + "1");
    }
}


class Leaf extends Node{

    char symbol;

    @Override
    public void setBinCode(String binCode) {
        super.setBinCode(binCode);
        System.out.println(symbol + ": " + binCode);
    }

    public Leaf(char symbol, int frequency) {
        super(frequency);
        this.frequency = frequency;
        this.symbol = symbol;
    }
}
