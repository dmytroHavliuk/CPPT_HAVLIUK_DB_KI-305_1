package KI305.Havliuk.Lab3;

/**
 * Інтерфейс <code>WeaponSystem</code> визначає функціонал системи зброї.
 */
interface WeaponSystem {
    void armWeapons();
    void dropBombs();
}

/**
 * Клас <code>Bomber</code> представляє бомбардувальник, що розширює базовий клас <code>Plane</code>.
 * Реалізовує інтерфейс <code>WeaponSystem</code> для управління зброєю.
 * @author Dmytro Havliuk
 * @version 1.0
 */
public class Bomber extends Plane implements WeaponSystem {

    private boolean weaponsArmed;

    /**
     * Конструктор для ініціалізації бомбардувальника.
     * @param horsepower потужність двигуна
     * @param frequency частота радіозв'язку
     * @param latitude початкова широта
     * @param longitude початкова довгота
     */
    public Bomber(int horsepower, double frequency, double latitude, double longitude) {
        super(horsepower, frequency, latitude, longitude);
        this.weaponsArmed = false;
    }

    /**
     * Озброює бомби на борту.
     */
    @Override
    public void armWeapons() {
        this.weaponsArmed = true;
        System.out.println("Weapons armed.");
    }

    /**
     * Викидає бомби під час місії.
     */
    @Override
    public void dropBombs() {
        if (weaponsArmed) {
            System.out.println("Dropping bombs...");
            this.weaponsArmed = false;
        } else {
            System.out.println("Weapons not armed.");
        }
    }

    /**
     * Виконує місію бомбардувальника.
     * У цьому випадку бомби скидаються.
     */
    @Override
    public void executeMission() {
        System.out.println("Bomber executing mission...");
        startEngine();
        armWeapons();
        dropBombs();
        shutdown();
    }
}
