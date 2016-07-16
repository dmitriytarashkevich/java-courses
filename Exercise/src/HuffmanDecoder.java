import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Dmitry Tarashkevich on 19-Jun-16.
 */
public class HuffmanDecoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfString = scanner.nextInt();
        int sizeOfCode = scanner.nextInt();
        Map<Character, String> symbolCode= new HashMap<>();
        while (symbolCode.size() < sizeOfString){
            symbolCode.put(scanner.next().charAt(0), scanner.next());
        }
        //System.out.println(symbolCode);
        StringBuilder code = new StringBuilder(scanner.next());
        //System.out.println(code);
        outer:
        for (int i = 0;; i++) {
            for (Map.Entry<Character, String> entry : symbolCode.entrySet()) {
                if (code.indexOf(entry.getValue()) == i) {
                    code.replace(i, i + entry.getValue().length(), entry.getKey().toString());
                    continue outer;
                }
            }
            break;
        }
        System.out.println(code);
    }
}
