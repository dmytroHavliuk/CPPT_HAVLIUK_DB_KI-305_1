package KI305.Havliuk.Lab3;

/**
 * Абстрактний клас <code>Plane</code> представляє загальні властивості літака.
 * Містить базові характеристики і методи для різних типів літаків.
 * @author Dmytro Havliuk
 * @version 1.0
 */
public abstract class Plane {
	protected Engine engine;
    protected CommunicationSystem comms;
    protected NavigationSystem navigation;

    /**
     * Конструктор для ініціалізації літака.
     * @param horsepower потужність двигуна
     * @param frequency частота радіозв'язку
     * @param latitude початкова широта
     * @param longitude початкова довгота
     */
    public Plane(int horsepower, double frequency, double latitude, double longitude) {
        this.engine = new Engine(horsepower);
        this.comms = new CommunicationSystem(frequency);
        this.navigation = new NavigationSystem(latitude, longitude);
    }

    /**
     * Запускає двигун літака.
     */
    public void startEngine() {
        engine.start();
    }

    /**
     * Зупиняє двигун літака.
     */
    public void stopEngine() {
        engine.stop();
    }

    /**
     * Абстрактний метод для запуску місії літака. Має бути реалізований у підкласах.
     */
    public abstract void executeMission();

    /**
     * Вимикає всі системи літака.
     */
    public void shutdown() {
        engine.stop();
        comms.deactivate();
        System.out.println("Plane shutdown completed.");
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

    public void start() {
        this.running = true;
        System.out.println("Engine started with " + horsepower + " horsepower.");
    }

    public void stop() {
        this.running = false;
        System.out.println("Engine stopped.");
    }

    /**
     * Перевіряє, чи працює двигун.
     * @return true, якщо двигун працює, false — якщо зупинений
     */
    public boolean isRunning() {
        return running;
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

    public void activate() {
        this.active = true;
        System.out.println("Communication system activated at frequency " + frequency + " MHz.");
    }

    public void deactivate() {
        this.active = false;
        System.out.println("Communication system deactivated.");
    }

    /**
     * Перевіряє, чи активна система зв'язку.
     * @return true, якщо система активна, false — якщо вимкнена
     */
    public boolean isActive() {
        return active;
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
