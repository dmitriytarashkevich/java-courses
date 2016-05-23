import java.util.stream.IntStream;

/**
 * Created by Dmitry Tarashkevich on 21.05.2016.
 */
public class PseudoRandomStream {

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed,operand -> mid(operand*operand)); // your implementation here
    }
    public static int mid(int i){
        return (i%10000 - i%10)/10;
    }
}
