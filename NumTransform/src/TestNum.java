/**
 * Created by dmitr on 02.04.2016.
 */
public class TestNum {
    public static void main(String[] args) {
        int inputLength = args.length;
        Num num1 = new Num();
        num1.value = 156;
        num1.transformToBin();
        num1.transformToHex();
        num1.transformToString();

    }
}
