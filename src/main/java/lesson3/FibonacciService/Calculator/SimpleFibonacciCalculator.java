package lesson3.FibonacciService.Calculator;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        prefix = "app.cache",
        name = "enabled",
        havingValue = "false",
        matchIfMissing = true
)
public class SimpleFibonacciCalculator implements FibonacciCalculator {

    @Override
    public long calculate(int n) {

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