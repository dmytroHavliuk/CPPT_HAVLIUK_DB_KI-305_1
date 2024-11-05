class Bombs:
    """Клас, що представляє систему управління бомбами."""

    def __init__(self, capacity):
        """
        Ініціалізує об'єкт Bombs.
        
        Аргументи:
        capacity: Вмістимість арсеналу літака.
        """
        self.capacity = capacity
        self.loaded_bombs = 0

    def load_bombs(self, count):
        """
        Завантажує бомби у відсік.
        
        Аргументи:
        count: кількість бомб для завантаження.

        Повертає:
        str: скільки бомб завантажено та скільки в арсеналі.
        """
        if self.loaded_bombs + count <= self.capacity:
            self.loaded_bombs += count
            return f"Завантажено {count} бомб(и). Відсік містить {self.loaded_bombs} бомб."
        else:
            return "Перевищено місткість бомбового відсіку."

    def drop_bombs(self):
        """
        Скидає всі бомби.
        
        Повертає:
        str: скільки бомб скинуто.
        """
        if self.loaded_bombs > 0:
            dropped = self.loaded_bombs
            self.loaded_bombs = 0
            return f"Скинуто {dropped} бомб."
        else:
            return "Бомб немає в бомбовому відсіку."

    def get_bomb_count(self):
        """Повертає поточну кількість бомб у відсіку."""
        return self.loaded_bombs
