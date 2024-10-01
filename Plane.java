/**
 * Пакет лабораторної роботи №3
 */
package KI305.Havliuk.Lab3;

import java.io.*;

/**
 * Абстрактний клас <code>Plane</code> описує основні параметри літака
 * @author Dmytro Havliuk
 * @version 1.0
 */
abstract public class Plane {
    private int speed;
    private int altitude;
    private String model;
    protected PrintWriter fout;
    static private int plane_count = 0;
    
    /**
     * Створює літак з заданими параметрами.
     * @param speed швидкість польоту
     * @param altitude висота польоту
     * @param model модель літака
     * @throws FileNotFoundException якщо файл для запису логів не може 
    бути відкрито
     */
    public Plane(int speed, int altitude, String model) throws FileNotFoundException {
        this.speed = speed;
        this.altitude = altitude;
        this.model = model;
        plane_count++;
        fout = new PrintWriter(new File("PlaneLog" + plane_count + ".txt"));
        logAct("Створено літак: " + model + " зі швидкістю " + speed + " км/год та висотою " + altitude + " м.");
    }
    
    /**
     * Повертає швидкість літака.
     */
    public int getSpeed() {
        logAct("Отримано швидкість: " + speed + " км/год.");
        return speed;
    }
    
    /**
     * Встановює швидкість літака.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
        logAct("Швидкість літака змінено на " + speed + " км/год.");
    }
    
    /**
     * Повертає висоту польоту літака.
     */
    public int getAltitude() {
        logAct("Отримано висоту польоту: " + altitude + " метрів.");
        return altitude;
    }
    
    /**
     * Встановює висоту польоту літака.
     */
    public void setAltitude(int altitude) {
        this.altitude = altitude;
        logAct("Висота польоту змінена на " + altitude + " метрів.");
    }
    
    /**
     * Повертає модель літака.
     */
    public String getModel() {
        logAct("Отримано модель літака: " + model);
        return model;
    }
    
    /**
     * Встановює модель літака.
     */
    public void setModel(String model) {
        this.model = model;
        logAct("Модель літака змінено на " + model);
    }
    
    /**
     * Створює літак з заданими параметрами.
     */
    public void fly() {
        logAct("Літак " + model + " летить на висоті " + altitude + " метрів зі швидкістю " + speed + " км/год.");
        System.out.println("Літак " + model + " летить на висоті " + altitude + " метрів зі швидкістю " + speed + " км/год.");
    }
    
    public abstract void performSpecialFunction();

    /**
     * Логування дій у файл
     * @param message повідомлення для запису у файл
     */
    protected void logAct(String message) {
        fout.println(message);
        fout.flush(); // Для негайного запису у файл
    }
    
    /**
     * Закриття ресурсу для запису у файл
     */
    public void dispose() {
        fout.close();
    }
}

