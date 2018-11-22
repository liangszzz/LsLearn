package book1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class book4_3_3 {

    /**
     * 迷宫容器
     */
    private Cell[][] cells = new Cell[8][8];

    class Cell {
        /**
         * 所在行
         */
        int row;
        /**
         * 所在列
         */
        int col;
        /**
         * true 表示为墙
         */
        boolean wall = true;
        /**
         * true 表示访问过
         */
        boolean visited = false;

        int branch=0;

        @Override
        public String toString() {
            return "[" + row + "," + col + "]";
        }
    }

    /**
     * 1.0 简单迷宫求解 只有一条路线
     * 2.0 复杂点的迷宫求解 允许出现分支
     *
     * @param cell 迷宫起点
     */
    public void mazeExit(Cell cell) {

        cell.visited = true;
        Stack<Cell> stack = new Stack<>();
        stack.push(cell);

        Cell next = cell;
        while (true) {
            if ((next.row == 7 || next.col == 7) && next.wall == false) {
                break;
            }
            next = searchNext(next);
            if (next == null) {
                //返回上一个有分支的节点
                Cell pre_cell1=stack.pop();
                while (true){
                    if (stack.size()==0){
                        next=cell;
                        break;
                    }
                    if (pre_cell1.branch>0){
                        next=pre_cell1;
                        break;
                    }
                    else {
                        pre_cell1=stack.pop();
                    }
                }
            }
            if (next.col==cell.col && next.row==cell.row){
                System.out.println("迷宫无解");
                break;
            }
            next.visited = true;
            stack.push(next);
        }
        System.out.println(stack.toString());
    }


    Cell searchNext(Cell cell) {
        Cell retCell = null;
        int count=0;
        //寻找方向 上,右,下,左
        if (cell.row - 1 >= 0 && cells[cell.row - 1][cell.col].wall == false && cells[cell.row - 1][cell.col].visited == false) {
            retCell= cells[cell.row - 1][cell.col];
            count++;
        }
        if (cell.col + 1 <= 7 && cells[cell.row][cell.col + 1].wall == false && cells[cell.row][cell.col + 1].visited == false) {
            if (count==0){
                retCell= cells[cell.row][cell.col + 1];
            }
            count++;
        }
        if (cell.row + 1 <= 7 && cells[cell.row + 1][cell.col].wall == false && cells[cell.row + 1][cell.col].visited == false) {
            if (count==0) {
                retCell=  cells[cell.row + 1][cell.col];
            }
            count++;
        }
        if (cell.col - 1 >= 0 && cells[cell.row][cell.col - 1].wall == false && cells[cell.row][cell.col - 1].visited == false) {
            if (count==0) {
                retCell = cells[cell.row][cell.col - 1];
            }
            count++;
        }
        cell.branch=count;
        return retCell;
    }

    @Test
    public void test0() {
        //填满迷宫
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                Cell cell = new Cell();
                cell.row = i;
                cell.col = j;
                cells[i][j] = cell;
            }
        }
        //挑出路径
        cells[0][0].wall = false;
        cells[1][0].wall = false;
        cells[1][1].wall = false;
        cells[1][2].wall = false;
        cells[1][3].wall = false;
        cells[1][4].wall = false;
        cells[2][3].wall = false;
        cells[3][2].wall = false;
        cells[3][3].wall = false;
        cells[4][2].wall = false;
        cells[5][2].wall = false;
        cells[6][2].wall = false;
        cells[7][2].wall = false;

        mazeExit(cells[0][0]);
    }
}
