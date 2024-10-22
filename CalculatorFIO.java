/**
* Пакет лабораторної роботи №5
*/
package KI305.Havliuk.Lab5;

import java.io.*;
import java.util.Scanner;
/**
 * Клас <code>CalculatorFIO</code> забезпечує операції з калькулятором та
 * файловим введенням/виведенням
 * @author Dmutro Havliuk
 * @version 1.0
 */
public class CalculatorFIO {
    private Calculator calc;
    private double res;

    /**
     * Конструктор за замовчуванням
     */
    public CalculatorFIO() {
        calc = new Calculator();
    }

    /**
     * Записує результат у текстовий файл
     * @param name ім'я файлу
     */
    public void writeTxt(String name) {
        try (PrintWriter writer = new PrintWriter(name)) {
            writer.printf("%f ", res);
            System.out.println("Результат був успішно записаний до текстового файлу.");
        } catch (FileNotFoundException e) {
            System.err.println("Неможливо створити файл або відкрити існуючий файл.");
        }
    }

    /**
     * Читає результат з текстового файлу
     * @param name ім'я файлу
     */
    public void readTxt(String name) {
        try (Scanner scanner = new Scanner(new File(name))) {
            if (scanner.hasNextDouble()) {
                res = scanner.nextDouble();
                System.out.println("Результат був успішно зчитаний з текстового файлу.");
            } else {
                System.err.println("Файл не містить числових даних.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл з ім'ям " + name + " не був знайдений.");
        }
    }

    /**
     * Записує результат у бінарний файл
     * @param name ім'я файлу
     */
    public void writeBin(String name) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(name))) {
            dos.writeDouble(res);
            System.out.println("Результат був успішно записаний до бінарного файлу.");
        } catch (IOException e) {
            System.err.println("Неможливо створити файл або відкрити існуючий файл.");
        }
    }

    /**
     * Читає результат з бінарного файлу
     * @param name ім'я файлу
     */
    public void readBin(String name) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(name))) {
            res = dis.readDouble();
            System.out.println("Результат був успішно зчитаний з бінарного файлу.");
        } catch (IOException e) {
            System.err.println("Неможливо відкрити файл з ім'ям " + name + ".");
        }
    }

    /**
     * Обчислює вираз та зберігає результат
     * @param x кут в градусах (дробове число)
     */
    public void calculate(double x) {
        try {
            res = calc.calculate(x);
        } catch (CalcException e) {
            System.err.println("Помилка при обчисленні виразу: " + e.getMessage());
        }
    }

    /**
     * Повертає поточний результат
     * @return поточний результат
     */
    public double getResult() {
        return res;
    }
}

/**
* Клас <code>CalcException</code> представляє спеціальне виключення для обчислень.
* @author Dmutro Havliuk
* @version 1.0
*/
@SuppressWarnings("serial")
class CalcException extends ArithmeticException {
    /**
     * Конструктор за замовчуванням.
     */
    public CalcException() {}

    /**
     * Конструктор з параметром.
     * @param cause причина виключення
     */
    public CalcException(String cause) {
        super(cause);
    }
}

/**
* Клас <code>Calculator</code> реалізує метод обчислення виразу tg(x)/sin(2x)
* @author Dmutro Havliuk
* @version 1.0
*/
class Calculator {
    /**
    * Метод обчислює вираз tg(x)/sin(2x)
    * @param x Кут в градусах (дробове число)
    * @return результат обчислення виразу
    * @throws CalcException якщо виникла арифметична проблема під час обчислення виразу
    */
	public double calculate(double x) throws CalcException {
	    double y, rad, sin2x;
	    // Обмежуємо значення x до діапазону [0, 360]
	    double striped_x = x % 360.0;
	    
	    try {
	        // Перевірка на заборонені значення для тангенса
	        if (striped_x == 90.0 || striped_x == 270.0) {
	            throw new CalcException("Заборонене значення X для обчислення тангенса.");
	        }
	        
	        // Переведення градусів у радіани
	        rad = striped_x * Math.PI / 180.0;
	        
	        // Обчислення sin(2x)
	        sin2x = Math.sin(2 * rad);
	        
	        // Перевірка на випадок нуля у знаменнику
	        if (sin2x == 0) {
	            throw new CalcException("Заборонене значення X для обчислення синуса 2x.");
	        }

	        // Обчислення виразу
	        y = Math.tan(rad) / sin2x;
	    } catch (CalcException e) {
	        throw e;
	    } catch (ArithmeticException ex) {
	        throw new CalcException("Причина виключення: невідома арифметична помилка.");
	    }
	    return y;
	}
}
