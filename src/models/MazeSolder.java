package models;

import java.util.List;

public interface MazeSolder {
    List<Cell> getPath(boolean [][] grid, Cell start,Cell end);
}