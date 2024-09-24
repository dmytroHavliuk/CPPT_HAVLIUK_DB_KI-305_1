/**
 * Пакет лабораторної роботи №2
 */
package KI305.Havliuk.Lab2;

import java.io.*;
/**
 * Клас <code>PlaneApp</code> виконує тестування та демонстрацію роботи 
 * класу Plane.
 * @author Dmytro Havliuk
 * @version 1.0
 */
public class PlaneApp {
    /**
     * Є вхідною точкою програми.
     * @param args аргументи командного рядка
     * @throws FileNotFoundException якщо файл для логування не знайдено
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Створення літака за замовчуванням
        Plane plane1 = new Plane();
        System.out.println("Plane 1 створено за замовчуванням.");
        logPlaneState(plane1);
        
        // Запуск двигуна
        plane1.startEngine();
        // Активація системи зв'язку
        plane1.activateComms();
        // Оновлення координат літака
        plane1.updatePosition(55.7, 37.6);
        logPlaneState(plane1);
        
        // Створення другого літака за допомогою іншого конструктора
        Plane plane2 = new Plane(2000, 150.0, 40.7, 74.9);
        System.out.println("Plane 2 створено з індивідуальними параметрами.");
        logPlaneState(plane2);
        
        // Оновлення частоти системи зв'язку
        plane2.activateComms();
        plane2.updatePosition(48.8, 2.3);
        logPlaneState(plane2);

        // Закриття ресурсу для логування
        plane1.dispose();
        plane2.dispose();
        System.out.println("Логування закінчено, ресурси звільнено.");
    }

    /**
     * Допоміжний метод для виведення стану літака на консоль.
     * @param plane літак, стан якого необхідно вивести
     */
    private static void logPlaneState(Plane plane) {
        System.out.println("Стан літака:");
        System.out.println("Двигун працює: " + plane.isEngineRunning());
        System.out.println("Система зв'язку активна: " + plane.isCommsActive());
        System.out.println("Поточна позиція: " + plane.getCurrentPosition());
        System.out.println();
    }
}
