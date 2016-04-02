/**
 * Created by dmitr on 02.04.2016.
 */
public class Num {
    public int value;
    public void transformToHex() {
        System.out.println("Hex = " + Integer.toHexString(value));
    }
    public void transformToBin() {
        System.out.println("Bin = " + Integer.toBinaryString(value));
    }
    public void transformToString() {
        System.out.println("String = " + Integer.toString(value));

    }
}
