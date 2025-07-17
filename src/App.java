import java.util.List;

import models.Cell;
import models.Maze;
import models.MazeSolverRecursivo;
import models.MazeSolverRecursivoCompleto;

public class App {
    public static void main(String[] args) {
        // runEjerciciosPD();
        runMaze();
    }

    private static void runEjerciciosPD() {
        EJerciciosPD ejerciciosPD = new EJerciciosPD();

        System.out.println("Fibonacci Recursivo");
        long start = System.nanoTime();
        int resultado = ejerciciosPD.getFibonacci(50);
        long end = System.nanoTime();
        double duration = (end - start) / 1_000_000_000.0;
        System.out.println("Resultado = " + resultado + " en tiempo " + duration + " segundos");

        System.out.println("Fibonacci con Programación Dinámica");
        long start2 = System.nanoTime();
        int resultado2 = ejerciciosPD.getFibonacciPD(50);
        long end2 = System.nanoTime();
        double duration2 = (end2 - start2) / 1_000_000_000.0;
        System.out.printf("Resultado = %d en tiempo %.6f segundos\n", resultado2, duration2);
    }

    private static void runMaze() {
        boolean[][] predefinedMaze = {
            { true,  true,  true,  true },
            { false, true,  true,  true },
            { true,  true,  false, false },
            { true,  true,  true,  true },
        };

        Maze maze = new Maze(predefinedMaze);
        System.out.println("Laberinto cargado:");
        maze.printMaze();

        Cell start = new Cell(0, 0);
        Cell end   = new Cell(3, 3);

        // Usando el solver recursivo simple (derecha y abajo)
        MazeSolverRecursivo simpleSolver = new MazeSolverRecursivo();
        List<Cell> path = simpleSolver.getPath(predefinedMaze, start, end);

        if (!path.isEmpty()) {
            System.out.println("Camino encontrado (simple):");
            for (Cell cell : path) {
                System.out.print(cell + " ");
            }
            System.out.println();
        } else {
            System.out.println("No se encontró un camino (simple).");
        }

        // Ahora usando el solver recursivo completo (arriba, derecha, abajo, izquierda)
        MazeSolverRecursivoCompleto fullSolver = new MazeSolverRecursivoCompleto();
        List<Cell> fullPath = fullSolver.getPath(predefinedMaze, start, end);

        if (!fullPath.isEmpty()) {
            System.out.println("Camino encontrado (completo):");
            for (Cell cell : fullPath) {
                System.out.print(cell + " ");
            }
            System.out.println();
        } else {
            System.out.println("No se encontró un camino (completo).");
        }
    }
}
   


