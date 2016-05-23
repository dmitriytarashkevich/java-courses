
/**
 * Created by Dmitry Tarashkevich on 16.05.2016.
 */
public class Generics {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        System.out.println(i+" "+s);
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        System.out.println(pair2.getFirst() + " " + pair2.getSecond());
        System.out.println(pair.equals(pair2)); // mus be true!
        System.out.println(pair.hashCode() == pair2.hashCode()); // true!
    }
}
class Pair <A,B> {
    private A first;
    private B second;
    private Pair(A first,B second){
        this.first = first;
        this.second = second;
    }
    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
    public static <A,B> Pair<A,B> of(A first,B second){
        return new Pair<>(first,second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
        return second != null ? second.equals(pair.second) : pair.second == null;

    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}