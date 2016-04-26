/**
 * Created by dmitr on 26.04.2016.
 */
public class MoveRobot{
    public static void moveRobot(Robot robot, int toX, int toY) {
        int dx = toX - robot.getX();
        int dy = toY - robot.getY();
        if (dy >= 0 && dx >= 0) {
            switch (robot.getDirection()) {
                case RIGHT:
                    go(robot,dx);
                    robot.turnLeft();
                    go(robot, dy);
                    break;
                case LEFT:
                    robot.turnRight();
                    go(robot, dy);
                    robot.turnRight();
                    go(robot,dx);
                    break;
                case DOWN:
                    robot.turnLeft();
                    go(robot,dx);
                    robot.turnLeft();
                    go(robot, dy);
                    break;
                case UP:
                    go(robot, dy);
                    robot.turnRight();
                    go(robot,dx);
                    break;
            }

        } else {
            if (dy >= 0 && dx <= 0) {
                switch (robot.getDirection()) {
                    case RIGHT:
                        robot.turnLeft();
                        go(robot, dy);
                        robot.turnLeft();
                        go(robot,dx);
                    case LEFT:
                        go(robot,dx);
                        robot.turnRight();
                        go(robot, dy);
                        break;
                    case DOWN:
                        robot.turnRight();
                        go(robot,dx);
                        robot.turnRight();
                        go(robot, dy);
                        break;
                    case UP:
                        go(robot, dy);
                        robot.turnLeft();
                        go(robot,dx);
                        break;
                }

            } else {
                if (dy <= 0 && dx >= 0) {
                    switch (robot.getDirection()) {
                        case RIGHT:
                            go(robot,dx);
                            robot.turnRight();
                            go(robot, dy);
                            break;
                        case LEFT:
                            robot.turnLeft();
                            go(robot, dy);
                            robot.turnLeft();
                            go(robot,dx);
                            break;
                        case DOWN:
                            go(robot, dy);
                            robot.turnLeft();
                            go(robot,dx);
                            break;
                        case UP:
                            robot.turnRight();
                            go(robot,dx);
                            robot.turnRight();
                            go(robot, dy);
                            break;
                    }

                } else {
                    if (dy <= 0 && dx <= 0) {
                        switch (robot.getDirection()) {
                            case RIGHT:
                                robot.turnRight();
                                go(robot, dy);
                                robot.turnRight();
                                go(robot,dx);
                                break;
                            case LEFT:
                                go(robot,dx);
                                robot.turnLeft();
                                go(robot, dy);
                                break;
                            case DOWN:
                                go(robot, dy);
                                robot.turnRight();
                                go(robot,dx);
                                break;
                            case UP:
                                robot.turnLeft();
                                go(robot,dx);
                                robot.turnLeft();
                                go(robot, dy);
                                break;
                        }
                    }
                }

            }
        }
        if (toY==robot.getY()&& toX==robot.getX()){
            System.out.println("На месте! ");
        }
    }
    public static void go(Robot rob,int a){
        for (int i=0; i<Math.abs(a);i++){
            rob.stepForward();
        }
    }
}
