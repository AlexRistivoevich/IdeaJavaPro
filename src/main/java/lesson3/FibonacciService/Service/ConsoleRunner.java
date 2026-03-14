package lesson3.FibonacciService.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsoleRunner implements CommandLineRunner {

    private final ConsoleFibonacciService consoleFibonacciService;

    @Override
    public void run(String... args) {
        consoleFibonacciService.runConsoleInterface();
    }
}