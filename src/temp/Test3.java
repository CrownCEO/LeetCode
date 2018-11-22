package temp;


import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Mr.Bao
 * @create 2018-10-08-19:10
 * @since 1.0.0
 */
public class Test3 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Maze maze = new Maze();
        maze.K = scanner.nextInt();
        String[] array = new String[4];
        array[0] = scanner.next();
        array[1] = scanner.next();
        array[2] = scanner.next();
        array[3] = scanner.next();


        for(int i = 0;i<array.length;i++){
            String temp = array[i];
            char[] a = temp.toCharArray();
            for(int j = 1;j<a.length;){
                if(a[j]=='0'){
                    a[j]='2';
                    maze.initialMaze(array);
                    maze.findPath();
                    a[j]='0';
                }
                j = j+2;
            }


        }


//        int temp[][] = maze.maze;
//        System.out.println(temp);
//        for(int i = 1;i<temp.length-1;i++){
//            for(int j = 1;j<temp[i].length-1;j++){
//                int t =  maze.maze[i][j];
//                maze.maze[i][j]=2;
//                maze.startCell = new MazeCell(i, j, 0);
//                maze.findPath();
//                maze.maze[i][j] = t;
//
//            }
//        }

    }


    public static class Maze {
        /**
         * 临时保存路径
         */
        private Stack<MazeCell> pathStack = new Stack<>();
        /**
         * 保存迷宫
         */
        private int[][] maze;
        private boolean flag = false;
        private MazeCell startCell;
        private MazeCell endCell;
        private int K = 0;

        public Maze() {

        }

        /**
         * 寻找路径
         */
        public void findPath() {
            assert flag;
            processCell(startCell.getX(), startCell.getY(), startCell.getStep());
        }

        private void processCell(int x, int y, int step) {
            if (x == endCell.getX() && y == endCell.getY()) {
                pathStack.pop();
                printPath();
//                System.out.println("(" + endCell.getX() + "," + endCell.getY() + ")");
                return;
            }
            test(x, y - 1, step + 1);
            test(x, y + 1, step + 1);
            test(x - 1, y, step + 1);
            test(x + 1, y, step + 1);
        }

        private void test(int x, int y, int step) {
            if (canGo(x, y)) {
                MazeCell mazeCell = new MazeCell(x, y, step);
                insertToPath(mazeCell);
                processCell(x, y, step);
            }
        }

        private void printPath() {
            for (int i = 0; i < pathStack.size(); i++) {
                MazeCell cell = pathStack.get(i);
//                System.out.print("(" + cell.getX() + "," + cell.getY() + ")->");
            }
            if(pathStack.size()<=K){
                System.out.println(0);
            }else{
                System.out.println(1);
            }
//            System.out.println("路径长度为 " + pathStack.size());
        }

        private void insertToPath(MazeCell mazeCell) {
            while (pathStack.peek().getStep() >= mazeCell.getStep()) {
                pathStack.pop();
            }
            pathStack.push(mazeCell);
        }

        private boolean canGo(int x, int y) {
            if (maze[x][y] == -1) {
                return false;
            }
            for (int i = 0; i < pathStack.size(); i++) {
                MazeCell mazeCell = pathStack.get(i);
                if (mazeCell.getX() == x && mazeCell.getY() == y) {
                    return false;
                }
            }
            return true;
        }

        private void initialMaze(String[] lines) {
            int column;
            int row;

            int temp = 0;

            row = 4;
            column = 4;
            maze = new int[row + 2][column + 2];
//            System.out.println("请输入迷宫（-1为墙，0为路，2为起点，1为终点）:");
            for (int i = 0; i < column + 2; i++) {
                maze[0][i] = -1;
            }



            for (int i = 1; i < row + 1; i++) {
                String str = lines[i-1];
                String[] line = str.split(",");
                maze[i][0] = -1;
                for (int j = 1; j < column + 1; j++) {
                    temp = Integer.parseInt(line[j - 1]);
                    switch (temp) {
                        case 2:
                            startCell = new MazeCell(i, j, 0);
                            maze[i][j] = temp;
                            pathStack.push(startCell);
                            break;
                        case 1:
                            endCell = new MazeCell(i, j, -1);
                        case 0:
                        case -1:
                            maze[i][j] = temp;
                            break;
                        default:
                            System.out.println("输入不符合要求T T");
                            return;
                    }
                }
                maze[i][column + 1] = -1;
            }
            for (int i = 0; i < column + 2; i++) {
                maze[row + 1][i] = -1;
            }
            if (startCell != null && endCell != null) {
                flag = true;
//                System.out.println("输入成功:)");
            } else {
                System.out.println("至少要有一个起点和终点:(");
            }
        }

    }


    public static class MazeCell {
        private int x;
        private int y;
        private int step;

        public MazeCell(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }
    }


}
