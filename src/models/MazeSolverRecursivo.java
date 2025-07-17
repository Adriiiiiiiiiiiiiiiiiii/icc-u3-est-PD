package models;

import java.util.List;
import java.util.ArrayList;

/**
 * Solución recursiva simple: solo mueve derecha y abajo.
 */
public class MazeSolverRecursivo implements MazeSolder {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        if (grid == null || grid.length == 0) {
            return path;
        }
        if (findPath(grid, start, end, path)) {
            return path;
        }
        return new ArrayList<>();
    }

    private boolean findPath(
        boolean[][] grid,
        Cell cur,
        Cell end,
        List<Cell> path
    ) {
        int row = cur.getFila();
        int col = cur.getColumna();

        // Fuera de rango o bloqueada
        if (row < 0 || col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            !grid[row][col]
        ) {
            return false;
        }

        // Llegamos al destino
        if (row == end.getFila() && col == end.getColumna()) {
            path.add(cur);
            return true;
        }

        // Derecha
        if (findPath(grid, new Cell(row, col + 1), end, path)) {
            path.add(cur);
            return true;
        }
        // Abajo
        if (findPath(grid, new Cell(row + 1, col), end, path)) {
            path.add(cur);
            return true;
        }

        return false;
    }
}
