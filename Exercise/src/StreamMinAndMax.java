/*Напишите метод, находящий в стриме минимальный и максимальный элементы
в соответствии порядком, заданным Comparator'ом.

Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:

minMaxConsumer.accept(min, max);
Если стрим не содержит элементов, то вызовите
minMaxConsumer.accept(null, null);*/
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/**
 * Created by Dmitry Tarashkevich on 22.05.2016.
 */
public class StreamMinAndMax {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        final Object[] min = {null};
        final Object [] max = {null};
        stream.forEach(
                o -> {
                    if (min[0] == null || order.compare(o, (T) min[0])<0) {
                        min[0] = o;
                    }
                    if (max[0] == null || order.compare(o, (T) max[0])>0) {
                        max[0] = o;
                    }
                }
        );
        minMaxConsumer.accept((T) min[0],(T) max[0]);
    }
}
