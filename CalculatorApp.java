/**
* Пакет лабораторної роботи №4
*/
package KI305.Havliuk.Lab4;

import java.io.*;

/**
* Клас <code>CalculatorDriver</code> є драйвером для тестування класу Calculator.
* Він демонструє використання класу Calculator та запис результатів у файл.
* @author Dmutro Havliuk
* @version 1.0
*/
public class CalculatorApp {

    /**
     * Головний метод програми.
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        try (PrintWriter writer = new PrintWriter(new FileWriter("calculator_results.txt"))) {
            writer.println("Результати обчислень виразу tg(x)/sin(2x):");
            writer.println("x (градуси) | Результат");
            writer.println("------------------------");

            for (double x = 0; x <= 360.0; x = x + 10) {
                try {
                    double result = calc.calculate(x);
                    writer.printf("%-12.2f | %.4f%n", x, result);
                } catch (CalcException e) {
                    writer.printf("%-12.2f | %s%n", x, e.getMessage());
                }
            }

            System.out.println("Результати записано у файл 'calculator_results.txt'");
        } catch (IOException e) {
            System.err.println("Помилка при записі у файл: " + e.getMessage());
        }
    }
}
