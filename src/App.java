public class App {
    public static void main(String[] args) {
        runEjerciciosPD();
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
}
