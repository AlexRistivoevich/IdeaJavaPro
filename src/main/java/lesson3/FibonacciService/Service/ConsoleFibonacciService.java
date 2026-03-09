package lesson3.FibonacciService.Service;

import lesson3.FibonacciService.Calculator.FibonacciCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class ConsoleFibonacciService {
    private final FibonacciCalculator fibonacciCalculator;

    public void runConsoleInterface() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите число или 'q' для выхода: ");
                String key = sc.nextLine();

                if ("q".equalsIgnoreCase(key)) {
                    System.out.println("Выход из программы");
                    return;
                }
                try {
                    int a = Integer.parseInt(key);
                    Long value = fibonacciCalculator.calculate(a);
                    System.out.println("Полученное значение: " + value);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите число или 'q' для выхода");
                }
            }
        }
    }
}
