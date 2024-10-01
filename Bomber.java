/**
* Пакет лабораторної роботи №3
*/
package KI305.Havliuk.Lab3;

import java.io.FileNotFoundException;

/**
 * Інтерфейс Flyable визначає контракт для об'єктів, що можуть літати
 * @author Dmitry Havliuk
 * @version 1.0
 */
interface Flyable {
    /**
     * Метод для початку польоту
     */
    void takeOff();

    /**
     * Метод для посадки
     */
    void land();
    
    /**
     * Метод для виконання спеціальної дії літака
     */
    void performSpecialFunction();
}

/**
 * Клас Bomber успадковує Plane і додає функціонал для скидання бомб
 */
public class Bomber extends Plane {
    private int bombs;

    public Bomber(int speed, int altitude, String model, int bombs) throws FileNotFoundException {
        super(speed, altitude, model);
        this.bombs = bombs;
        logAct("Створено бомбардувальник " + model + " з кількістю бомб: " + bombs);
    }
    
    public int getBombs() {
        logAct("Отримано кількість бомб: " + bombs);
        return bombs;
    }
    
    public void setBombs(int bombs) {
        this.bombs = bombs;
        logAct("Кількість бомб змінена на " + bombs);
    }
    
    @Override
    public void performSpecialFunction() {
        if (bombs > 0) {
            logAct("Скидання бомби. Залишилось бомб: " + (bombs - 1));
            System.out.println("Скидання бомби! Залишилося бомб: " + --bombs);
        } else {
            logAct("Спроба скинути бомбу, коли немає бомб.");
            System.out.println("Немає бомб для скидання.");
        }
    }
    
    public void dropBomb() {
        performSpecialFunction();
    }
    
    public void takeOff() {
        logAct("Бомбардувальник " + getModel() + " злітає.");
        System.out.println("Бомбардувальник " + getModel() + " злітає.");
    }

    public void land() {
        logAct("Бомбардувальник " + getModel() + " приземляється.");
        System.out.println("Бомбардувальник " + getModel() + " приземляється.");
    }
}
