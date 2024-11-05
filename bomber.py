from Bombs import Bombs
from Coordinates import Crew
from Plane import Plane
from Mission import Mission

class Bomber(Plane):
    """Клас, що представляє бомбардувальник з функціональністю літака."""

    def __init__(self, latitude=60, longitude=11, height=1500, crew=Crew.C2, state=False):
        """
        Ініціалізує об'єкт Bomber.
        
        Аргументи:
        latitude (int): Широта в градусах. За замовчуванням 60.
        longitude (int): Довгота в градусах. За замовчуванням 11.
        height (int): Висота польоту в метрах. За замовчуванням 1500.
        crew (Crew): Екіпаж літака. За замовчуванням 1.
        state (bool): Початковий стан двигуна (увімкнено/вимкнено). За замовчуванням False.
        """
        super().__init__(latitude, longitude, height, crew, state)
        self.bombs = Bombs(10)
        self.mission = Mission()

    def load_bombs(self, count):
        """
        Завантажує бомби у відсік.
        
        Повертає:
        int: кількість завантажених бомб.
        """
        return self.bombs.load_bombs(count)

    def drop_bombs(self):
        """
        Скидає всі бомби.
        
        Повертає:
        int: кількість скинутих бомб.
        """
        return self.bombs.drop_bombs()

    def get_bomb_count(self):
        """Повертає поточну кількість бомб у відсіку."""
        return self.bombs.get_bomb_count()

    def is_on_mission(self):
        """Повертає True, якщо літак на завданні, інакше False."""
        return self.mission.is_on_mission()

    def set_mission(self):
        """Надає завдання."""
        self.mission.set_mission()

    def finish_mission(self):
        """Завершує завдання."""
        self.mission.finish_mission()
