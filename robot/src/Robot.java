/**
 * Created by dmitr on 26.04.2016.
 */
public class Robot {
    public Robot(int x, int y, Direction direction, int toX, int toY){
        this.toX=toX;
        this.toY=toY;
        this.x=x;
        this.y=y;
        this.direction=direction;
    }
    int x;
    int y;
    Direction direction;
    int toX;
    int toY;

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        System.out.println("Поверну налево");
        switch (getDirection()) {
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case UP:
                direction = Direction.LEFT;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
            case LEFT:
                direction = Direction.DOWN;
        }
    }

    public void turnRight() {
        System.out.println("Певерну направо");
        switch (getDirection()) {
            default:
            case DOWN:
                direction = Direction.LEFT;
                break;
            case UP:
                direction = Direction.RIGHT;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
            case LEFT:
                direction = Direction.UP;
        }
    }

    public void stepForward() {
        switch (getDirection()) {
            default:
            case RIGHT:
                x++;
                break;
            case LEFT:
                x--;
                break;
            case UP:
                y++;
                break;
            case DOWN:
                y--;
                break;
        }
        System.out.println("Топ " + getX() +" " +getY());
    }
}
