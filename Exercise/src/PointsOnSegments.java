import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dmitry Tarashkevich on 14.06.2016.
 */
public class PointsOnSegments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfSegments = scanner.nextInt();
        List<Integer> points = new ArrayList<>();
        List<Segment> segments = new ArrayList<>();
        for (int i = 0; i < countOfSegments; i++){
            segments.add(new Segment(scanner.nextInt(),scanner.nextInt()));
        }
        segments.sort((o1, o2) -> o1.end - o2.end);
        //System.out.println(segments);
        points.add(segments.get(0).end);
        for (int i = 1; i < countOfSegments; i++) {
            if (segments.get(i).start > points.get(points.size() - 1)){
                points.add(segments.get(i).end);
            }
        }
        System.out.println(points.size());
        points.forEach(System.out::println);
    }
}
class  Segment{
    public int start;
    public int end;

    public Segment(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "\n" + this.start + " " + this.end;
    }
}
