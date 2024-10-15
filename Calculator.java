/**
* Пакет лабораторної роботи №4
*/
package KI305.Havliuk.Lab4;

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
public class Calculator {
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
