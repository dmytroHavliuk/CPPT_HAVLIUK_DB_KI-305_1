/**
 * Пакет лабораторної роботи №3
 */
package KI305.Havliuk.Lab3;

import java.io.FileNotFoundException;

/**
 * Клас-драйвер демонструє функціонал класу <code>Bomber</code>
 */
public class BomberApp {
	
	/**
	 * <code>main</code> є вхідною точкою в програму
	 * @param args не використовуєьться
	 */
    public static void main(String[] args) {
        try {
            // Створення об'єкта Bomber
            Bomber bomber = new Bomber(800, 5000, "Boeing B-52", 5);

            // Демонстрація основних методів літака
            bomber.fly();
            System.out.println("Модель літака: " + bomber.getModel());
            System.out.println("Швидкість літака: " + bomber.getSpeed() + " км/год");
            System.out.println("Висота польоту: " + bomber.getAltitude() + " метрів");
            
            // Зліт
            bomber.takeOff();

            // Демонстрація специфічної функції бомбардувальника
            System.out.println("\nДемонстрація скидання бомб:");
            bomber.dropBomb();
            bomber.dropBomb();
            bomber.dropBomb();
            bomber.dropBomb();
            bomber.dropBomb();
            bomber.dropBomb(); // Спроба скинути бомбу, коли вже немає бомб
            
            // Посадка
            bomber.land();

            // Завершення роботи з ресурсами
            bomber.dispose();
            System.out.println("\nРоботу завершено, ресурси звільнено");
        } catch (FileNotFoundException e) {
            System.err.println("Помилка при створенні файлу логу: " + e.getMessage());
        }
    }
}
