/**
* Пакет лабораторної роботи №6
*/
package KI305.Havliuk.Lab6;

import java.util.ArrayList;
import java.util.HashMap;

/**
* Клас <code>Wardrobe</code> - контейнер для зберігання одягу.
* Реалізує можливість додавання, видалення одягу, пошук одягу
* з мінімальним розміром, пошук за назвою та підрахунок
* загальної кількості одягу.
*/
public class Wardrobe<T extends Clothing> {
    private ArrayList<T> clothingItems;
    
    /**
    * Конструктор класу <code>Wardrobe</code>
    */
    public Wardrobe() {
        clothingItems = new ArrayList<>();
    }
    
    /**
    * Метод для додавання одягу до шафи.
    * @param item Одяг, який потрібно додати.
    */
    public void addClothing(T item) {
        clothingItems.add(item);
    }
    
    /**
    * Метод для видалення одягу з шафи.
    * @param item Одяг, який потрібно видалити.
    */
    public void removeClothing(T item) {
        clothingItems.remove(item);
    }
    
    /**
    * Метод для пошуку одягу з найменшим розміром.
    * @return Одяг з найменшим розміром.
    */
    public T findMinClothing() {
        if (clothingItems.isEmpty()) {
            return null;
        }
        T minItem = clothingItems.get(0);
        for (T item : clothingItems) {
            if (item.compareSize(minItem) < 0) {
                minItem = item;
            }
        }
        return minItem;
    }

    /**
    * Метод для пошуку одягу за назвою.
    * @param name Назва одягу для пошуку.
    * @return Одяг з відповідною назвою або null, якщо такого немає.
    */
    public T findClothingByName(String name) {
        for (T item : clothingItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    /**
    * Метод для підрахунку загальної кількості одягу в шафі.
    * @return Загальна кількість одягу.
    */
    public int getTotalClothingCount() {
        return clothingItems.size();
    }

    /**
    * Метод для отримання всього одягу в шафі.
    * @return Список всього одягу.
    */
    public ArrayList<T> getClothingItems() {
        return clothingItems;
    }
}

/**
* Абстрактний клас <code>Clothing</code> є базовим класом для всього одягу.
*/
abstract class Clothing {
    protected String name;
    protected String size;

    // Мапа для визначення порядку розмірів
    private static final HashMap<String, Integer> sizeOrder;
    
    static {
        sizeOrder = new HashMap<>();
        sizeOrder.put("XS", 1);
        sizeOrder.put("S", 2);
        sizeOrder.put("M", 3);
        sizeOrder.put("L", 4);
        sizeOrder.put("XL", 5);
        sizeOrder.put("XXL", 6);
    }

    /**
    * Конструктор класу <code>Clothing</code>
    * @param name назва одягу
    * @param size розмір одягу
    */
    public Clothing(String name, String size) {
        this.name = name;
        this.size = size;
    }

    /**
    * Метод для отримання назви одягу
    * @return назва одягу
    */
    public String getName() {
        return name;
    }

    /**
     * Метод для отримання розміру
     * @return розмір
     */
    public String getSize() {
        return size;
    }

    /**
     * Метод для порівняння розміру
     * @return найменший розмір
     */
    public int compareSize(Clothing other) {
        return Integer.compare(sizeOrder.getOrDefault(this.size, Integer.MAX_VALUE), 
                               sizeOrder.getOrDefault(other.size, Integer.MAX_VALUE));
    }

    @Override
    public String toString() {
        return name + " (Розмір: " + size + ")";
    }
}

/**
* Клас <code>Shirts</code> - сорочка.
*/
class Shirts extends Clothing {
	/**
	 * Конструктор класу <code>Shirts</code>
	* @param name назва одягу
	* @param size розмір одягу
	*/
    public Shirts(String name, String size) {
        super(name, size);
    }
}

/**
* Клас <code>Pants</code> - штани.
*/
class Pants extends Clothing {
	/**
	 * Конструктор класу <code>Pants</code>
	* @param name назва одягу
	* @param size розмір одягу
	*/
    public Pants(String name, String size) {
        super(name, size);
    }
}

/**
* Клас <code>Jackets</code> - куртка.
*/
class Jackets extends Clothing {
	/**
	 * Конструктор класу <code>Jackets</code>
	* @param name назва одягу
	* @param size розмір одягу
	*/
    public Jackets(String name, String size) {
        super(name, size);
    }
}

/**
* Клас <code>Hats</code> - капелюх.
*/
class Hats extends Clothing {
	/**
	 * Конструктор класу <code>Hats</code>
	* @param name назва одягу
	* @param size розмір одягу
	*/
    public Hats(String name, String size) {
        super(name, size);
    }
}

