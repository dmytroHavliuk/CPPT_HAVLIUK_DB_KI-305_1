/**
 * Пакет лабораторної роботи №2
 */
package KI305.Havliuk.Lab2;

import java.io.*;

/**
 * Клас <code>Plane</code> описує літак з можливістю керування двигуном, системою зв'язку та 
 * навігацією.
 * @author Dmytro Havliuk
 * @version 1.0
 */
public class Plane {
    private Engine engine;
    private CommunicationSystem comms;
    private NavigationSystem navigation;
    private PrintWriter fout;
    static private int plane_count = 0;

    /**
     * Створює літак з заданими параметрами.
     * @param horsepower потужність двигуна
     * @param radioFrequency частота радіозв'язку
     * @param latitude широта
     * @param longitude довгота
     * @throws FileNotFoundException якщо файл для запису логів не може бути відкрито
     */
    public Plane(int horsepower, double radioFrequency, double latitude, double longitude) throws FileNotFoundException {
        engine = new Engine(horsepower);
        comms = new CommunicationSystem(radioFrequency);
        navigation = new NavigationSystem(latitude, longitude);
        plane_count++;
        fout = new PrintWriter(new File("Log" + plane_count + ".txt"));
        log("Plane created.");
    }

    /**
     * Створює літак з налаштуваннями за замовчуванням.
     * @throws FileNotFoundException якщо файл для запису логів не може бути відкрито
     */
    public Plane() throws FileNotFoundException {
        this(1000, 120.5, 50.0, 30.0);
    }

    /**
     * Запускає двигун літака.
     */
    public void startEngine() {
        fout.println("Engine started.");
        fout.flush();
        engine.start();
    }

    /**
     * Зупиняє двигун літака.
     */
    public void stopEngine() {
        fout.println("Engine stopped.");
        fout.flush();
        engine.stop();
    }

    /**
     * Перевіряє стан двигуна.
     * @return true, якщо двигун працює
     */
    public boolean isEngineRunning() {
        fout.println("Checking engine status.");
        fout.flush();
        return engine.isRunning();
    }

    /**
     * Перевіряє, чи ввімкнена система зв'язку.
     * @return true, якщо система зв'язку увімкнена
     */
    public boolean isCommsActive() {
        fout.println("Checking communication system status.");
        fout.flush();
        return comms.isActive();
    }

    /**
     * Вмикає систему зв'язку.
     */
    public void activateComms() {
        fout.println("Communication system activated.");
        fout.flush();
        comms.activate();
    }

    /**
     * Вимикає систему зв'язку.
     */
    public void deactivateComms() {
        fout.println("Communication system deactivated.");
        fout.flush();
        comms.deactivate();
    }

    /**
     * Отримує поточну позицію літака.
     * @return координати літака у форматі "широта, довгота"
     */
    public String getCurrentPosition() {
        fout.println("Getting current position.");
        fout.flush();
        return navigation.getPosition();
    }

    /**
     * Оновлює координати літака.
     * @param latitude нова широта
     * @param longitude нова довгота
     */
    public void updatePosition(double latitude, double longitude) {
        fout.println("Updating position to " + latitude + ", " + longitude + ".");
        fout.flush();
        navigation.updatePosition(latitude, longitude);
    }

    /**
     * Звільнює ресурси, які були використані для роботи з файлом.
     */
    public void dispose() {
        fout.close();
    }

    /**
     * Логує події в файл.
     * @param message повідомлення для логування
     */
    private void log(String message) {
        fout.println(message);
        fout.flush();
    }
}

/**
 * Клас <code>Engine</code> представляє двигун літака.
 */
class Engine {
    private int horsepower;
    private boolean running;

    public Engine(int horsepower) {
        this.horsepower = horsepower;
        this.running = false;
    }

    /**
     * Запускає двигун, враховуючи потужність.
     */
    public void start() {
        this.running = true;
        System.out.println("Engine started with " + horsepower + " horsepower.");
    }

    /**
     * Зупиняє двигун.
     */
    public void stop() {
        this.running = false;
        System.out.println("Engine stopped.");
    }

    /**
     * Перевіряє, чи працює двигун.
     * @return true, якщо двигун працює
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Отримує потужність двигуна.
     * @return потужність у кінських силах
     */
    public int getHorsepower() {
        return horsepower;
    }
}


/**
 * Клас <code>CommunicationSystem</code> представляє систему зв'язку літака.
 */
class CommunicationSystem {
    private double frequency;
    private boolean active;

    public CommunicationSystem(double frequency) {
        this.frequency = frequency;
        this.active = false;
    }

    /**
     * Активація системи зв'язку, враховуючи частоту зв'язку.
     */
    public void activate() {
        this.active = true;
        System.out.println("Communication system activated at frequency " + frequency + " MHz.");
    }

    /**
     * Вимкнення системи зв'язку.
     */
    public void deactivate() {
        this.active = false;
        System.out.println("Communication system deactivated.");
    }

    /**
     * Перевірка активності системи зв'язку.
     * @return true, якщо система зв'язку активна
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Отримання частоти системи зв'язку.
     * @return частота у мегагерцах
     */
    public double getFrequency() {
        return frequency;
    }
}


/**
 * Клас <code>NavigationSystem</code> представляє навігаційну систему літака.
 */
class NavigationSystem {
    private double latitude;
    private double longitude;

    public NavigationSystem(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getPosition() {
        return latitude + ", " + longitude;
    }

    public void updatePosition(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
