/**
* Пакет лабораторної роботи №5
*/
package KI305.Havliuk.Lab5;

/**
 * Клас <code>CalculatorFIOApp</code> демонструє роботу класу CalculatorFIO.
 * @author Dmutro Havliuk
 * @version 1.0
 */
public class CalculatorFIOApp {
	
	/**
	* Головний метод для демонстрації роботи класу
	<code>CalculatorFIO</code>
	* @param args у даній програмі не використовується
	*/
    public static void main(String[] args) {
        CalculatorFIO calcFIO = new CalculatorFIO();

        // Демонстрація обчислення
        System.out.println("Демонстрація обчислення:");
        calcFIO.calculate(50);
        System.out.println("Результат обчислення: " + calcFIO.getResult());

        // Запис результату у текстовий файл
        System.out.println("\nЗапис результату у текстовий файл:");
        calcFIO.writeTxt("result.txt");

        // Читання результату з текстового файлу
        System.out.println("\nЧитання результату з текстового файлу:");
        calcFIO.readTxt("result.txt");
        System.out.println("Прочитаний результат: " + calcFIO.getResult());

        // Запис результату у бінарний файл
        System.out.println("\nЗапис результату у бінарний файл:");
        calcFIO.writeBin("result.bin");

        // Читання результату з бінарного файлу
        System.out.println("\nЧитання результату з бінарного файлу:");
        calcFIO.readBin("result.bin");
        System.out.println("Прочитаний результат: " + calcFIO.getResult());
    }
}
