package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazeSolverRecursivo {

    private Set<String> visited = new HashSet<>();

    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        if (grid == null || grid.length == 0) {
            return new ArrayList<>();
        }

        List<Cell> path = new ArrayList<>();
        if (findPath(grid, start, end, path)) {
            return path;
        }
        return null;
    }

    private boolean findPath(boolean[][] grid, Cell current, Cell end, List<Cell> path) {
        int row = current.getRow();
        int col = current.getCol();

        // Validaciones fuera de límites o no transitable
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col]) {
            return false;
        }

        // Si ya visitamos esta celda, evitar ciclos
        String key = row + "," + col;
        if (visited.contains(key)) {
            return false;
        }
        visited.add(key);

        path.add(current);

        if (current.equals(end)) {
            return true;
        }

        // Probar movimientos: derecha, abajo, izquierda, arriba
        if (findPath(grid, new Cell(row, col + 1), end, path) || 
            findPath(grid, new Cell(row + 1, col), end, path) || 
            findPath(grid, new Cell(row, col - 1), end, path) || 
            findPath(grid, new Cell(row - 1, col), end, path)) {
            return true;
        }

        // Backtrack si no se encontró camino
        path.remove(path.size() - 1);
        return false;
    }
}
