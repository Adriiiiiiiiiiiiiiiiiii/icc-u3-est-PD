import java.util.HashMap;
import java.util.Map;

public class EJerciciosPD {
    public int getFibonacci(int n) {
        if (n <= 1) return n;
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    private Map<Integer, Integer> memo = new HashMap<>();

    public int getFibonacciPD(int n) {
        if (n <= 1) return n;

        Integer result = memo.get(n);
        if (result != null) return result;

        result = getFibonacciPD(n - 1) + getFibonacciPD(n - 2);
        memo.put(n, result);
        return result;
    }
}
