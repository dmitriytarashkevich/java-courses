/**
 * Created by dmitr on 26.04.2016.
 */
public class Start {
    public static void main(String[] args) {
        Robot robot = new Robot(3,100,Direction.LEFT,7,10);
        System.out.println("Я тут: " + robot.getX() + " " + robot.getY());
        String s = null;
        switch (robot.getDirection()){
            case UP: s="вверх";
                break;
            case DOWN: s="вниз";
                break;
            case LEFT:s="влево";
                break;
            case RIGHT:s="вправо";
                break;
        }
        System.out.println("Смотрю " + s);
        System.out.println("Мне нужно сюда: " + robot.toX + " " + robot.toY);
        MoveRobot.moveRobot(robot, robot.toX, robot.toY);
    }
}
