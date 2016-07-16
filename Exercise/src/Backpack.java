import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dmitry Tarashkevich on 14.06.2016.
 */
public class Backpack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfItems = scanner.nextInt();
        int maxWeight = scanner.nextInt();
        List<Item> items = new ArrayList<>();
        while (items.size() < numberOfItems){
            items.add(new Item(scanner.nextInt(),scanner.nextInt()));
        }
        items.sort((o1, o2) -> Double.compare(o2.value, o1.value));
        System.out.println(items);
        int currentWeight = 0;
        double currentPrice = 0;
        int numberOfItemsInBackpack = 0;
        for (int i = 0;
             (i < items.size() && (currentWeight + items.get(i).weight) <= maxWeight);
             i++) {
            numberOfItemsInBackpack++;
            currentWeight += items.get(i).weight;
            currentPrice += items.get(i).price;
        }
        if (numberOfItemsInBackpack < numberOfItems) {
            Item lastItem = items.get(numberOfItemsInBackpack);
            currentPrice += lastItem.value * ((maxWeight - currentWeight));
        }
        System.out.printf("%.3f", currentPrice);
    }
}
class Item {
    public int price;
    public int weight;
    public double value;

    public Item(int price, int weight) {
        this.weight = weight;
        this.price = price;
        this.value = (double) price / weight;
    }
    @Override
    public String toString() {
        return "Item{" +
                "price =" + price +
                ", weight =" + weight +
                ", value =" + value +
                '}';
    }
}
