/**
 * Created by dmitr on 31.03.2016.
 */
public class MashaTest {
    public static void main(String[] args) {
        String gfriend="Masha";
        if (gfriend=="Masha"){
            System.out.println("true1");//объект сравнивается со значнием
        }
        String gfriend1 = new String ("Natasha");
        String gfriend2 = new String ("Natasha");
        if (gfriend1==gfriend2) {
            System.out.println("true2"); // сравниваются два разных объекта, они не равны, равны их значения
        }
        String gfriend3 = new String ("Natasha");
        String gfriend4 = new String ("Natasha");
        if (gfriend3.equals(gfriend4)) {
            System.out.println("true3"); // сравниваются значения двух разных объектов
        }
    }
}
