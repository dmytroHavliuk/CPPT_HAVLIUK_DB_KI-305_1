/**
* Пакет лабораторної роботи №6
*/
package KI305.Havliuk.Lab6;

/**
* Клас-драйвер для тестування класу <code>Wardrobe</code>.
*/
public class WardrobeApp {
	
	/**
	* Головний метод для тестування <code>Wardrobe</code>
	* @param args у даній програмі не використовується
	*/
    public static void main(String[] args) {
        // Створюємо екземпляр шафи
        Wardrobe<Clothing> wardrobe = new Wardrobe<>();
        
        // Створюємо кілька предметів одягу
        Shirts shirt = new Shirts("Сорочка", "M");
        Pants pants = new Pants("Штани", "L");
        Jackets jacket = new Jackets("Куртка", "XL");
        Hats hat = new Hats("Капелюх", "S");

        // Додаємо предмети одягу до шафи
        wardrobe.addClothing(shirt);
        wardrobe.addClothing(pants);
        wardrobe.addClothing(jacket);
        wardrobe.addClothing(hat);

        // Виводимо всі предмети одягу в шафі
        System.out.println("Одяг в шафі:");
        for (Clothing item : wardrobe.getClothingItems()) {
            System.out.println(item);
        }

        // Знаходимо мінімальний одяг за розміром
        Clothing smallestItem = wardrobe.findMinClothing();
        System.out.println("\nПредмет одягу з найменшим розміром: " + smallestItem);

        // Шукаємо предмет одягу за назвою
        Clothing foundItem = wardrobe.findClothingByName("Куртка");
        System.out.println("\nЗнайдений предмет одягу: " + foundItem);

        // Підраховуємо загальну кількість предметів одягу
        int totalItems = wardrobe.getTotalClothingCount();
        System.out.println("\nЗагальна кількість предметів одягу: " + totalItems);

        // Видаляємо один предмет одягу
        wardrobe.removeClothing(hat);

        // Виводимо оновлену інформацію про шафу
        System.out.println("\nПісля видалення капелюха:");
        for (Clothing item : wardrobe.getClothingItems()) {
            System.out.println(item);
        }
    }
}
