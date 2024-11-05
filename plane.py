from Engine import Engine
from Coordinates import Coordinates, Crew

class Plane:
    """Клас, що представляє літак."""

    def __init__(self, latitude=60, longitude=11, height=1500, crew=Crew.C2, state=False):
        """
        Ініціалізує об'єкт Plane.
        
        Аргументи:
        latitude (int): Широта в градусах. За замовчуванням 60.
        longitude (int): Довгота в градусах. За замовчуванням 11.
        height (int): Висота польоту в метрах. За замовчуванням 1500.
        crew (Crew): Екіпаж літака. За замовчуванням 1.
        state (bool): Початковий стан двигуна (увімкнено/вимкнено). За замовчуванням False.
        """
        self.engine = Engine(state)
        self.coordinates = Coordinates(latitude, longitude, height, crew)

    def is_flying(self):
        """
        Перевіряє, чи в польоті.
        
        Повертає:
        bool: True, якщо в польоті, інакше False.
        """
        return self.engine.get_state()

    def start_engine(self):
        """Заводить двигун."""
        self.engine.start()

    def stop_engine(self):
        """Зупиняє двигун."""
        self.engine.stop()

    def get_longitude(self):
        """
        Отримує довготу.
        
        Повертає:
        int: Довжина в градусах.
        """
        return self.coordinates.get_longitude()

    def get_latitude(self):
        """
        Отримує широту.
        
        Повертає:
        int: Широта в градусах.
        """
        return self.coordinates.get_latitude()

    def get_height(self):
        """
        Отримує висоту польоту.
        
        Повертає:
        int: Висота польоту в метрах.
        """
        return self.coordinates.get_height()

    def get_crew(self):
        """
        Отримує екіпаж.
        
        Повертає:
        int: кількість членів екіпажу.
        """
        return self.coordinates.get_crew()

    def set_latitude(self, latitude):
        """
        Встановлює широту.
        
        Аргументи:
        latitude (int): Нова широта в градусах.
        """
        self.coordinates.set_latitude(latitude)

    def set_longitude(self, longitude):
        """
        Встановлює довготу.
        
        Аргументи:
        longitude (int): Нова довгота в градусах.
        """
        self.coordinates.set_longitude(longitude)

    def set_height(self, height):
        """
        Встановлює висоту.
        
        Аргументи:
        height (int): Нова висота в метрах.
        """
        self.coordinates.set_height(height)

    def set_crew(self, crew):
        """
        Встановлює екіпаж.
        
        Аргументи:
        crew (int): Нова кількість членів екіпажу.
        """
        self.coordinates.set_crew(crew)
