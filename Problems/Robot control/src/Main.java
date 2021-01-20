class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {
        while (robot.getX() != toX || robot.getY() != toY) {
            turnRound(robot.getX() - toX, robot.getY() - toY, robot);
            robot.stepForward();
        }
    }

    private static void turnRound(int xDist, int yDist, Robot robot) {
        if (goodMove(xDist, yDist, robot.getDirection())) {
            return;
        }
        if (goodMove(xDist, yDist, robot.getDirection().turnLeft())) {
            robot.turnLeft();
        } else {
            robot.turnRight();
            if (!goodMove(xDist, yDist, robot.getDirection())) {
                robot.turnRight();
            }
        }
    }

    private static boolean goodMove(int xDist, int yDist, Direction curDir) {
        return opposite(xDist, curDir.dx()) || opposite(yDist, curDir.dy());
    }

    private static boolean opposite(int val1, int val2) {
        return val1 < 0 && val2 > 0 || val1 > 0 && val2 < 0;
    }

//    public static void main(String[] args) {
//        Robot robot = new Robot(2, 2, Direction.UP);
//        int toX = 10;
//        int toY = -15;
//        moveRobot(robot, toX, toY);
//        System.out.printf("robot.x = %d, robot.y = %d%n", robot.getX(), robot.getY());
//    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}