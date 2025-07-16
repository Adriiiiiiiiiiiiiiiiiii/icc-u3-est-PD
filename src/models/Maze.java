package models;

import java.util.List;

public class Maze {
    private boolean[][] predefinedMaze;

    public Maze(boolean[][] predefinedMaze) {
        this.predefinedMaze = predefinedMaze;
    }

    public void printMaze() {
        for (int i = 0; i < predefinedMaze.length; i++) {
            for (int j = 0; j < predefinedMaze[i].length; j++) {
                System.out.print(predefinedMaze[i][j] ? "-" : "*");
            }
            System.out.println();
        }
    }

    public boolean[][] getMaze() {
        return predefinedMaze;
    }

    public interface MazeSolver {
        List<Cell> getPath(boolean[][] grid, Cell start, Cell end);
    }
}
