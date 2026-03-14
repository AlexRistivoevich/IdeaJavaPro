package lesson3.FibonacciService.Service;

import lesson3.FibonacciService.Calculator.FibonacciCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "app.cache", name = "enabled", havingValue = "true")
public class CachedFibonacciCalculator implements FibonacciCalculator {

    private final Map<Integer, Long> cache = new ConcurrentHashMap<>();

    @Override
    public long calculate(int n) {

        if (cache.containsKey(n)) {
            System.out.println("Значение получено из кэша");
            return cache.get(n);
        }

        long value = calculateWithoutCaching(n);
        cache.put(n, value);
        return value;
    }

    private long calculateWithoutCaching(int n) {

        if (n <= 1) return n;

        long prev = 0;
        long curr = 1;

        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }
}