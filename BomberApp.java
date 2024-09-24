package KI305.Havliuk.Lab3;

/**
 * Клас <code>BomberApp</code> тестує функціональність бомбардувальника.
 */
public class BomberApp {
    public static void main(String[] args) {
        // Створення бомбардувальника
        Bomber bomber = new Bomber(2000, 150.0, 40.7, 74.9);
        
        // Виконання місії
        bomber.executeMission();
    }
}
