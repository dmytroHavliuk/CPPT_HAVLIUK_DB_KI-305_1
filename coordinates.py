from enum import Enum


class Crew(Enum):
    """Перелік членів екіпажу."""
    C1 = 1
    C2 = 2


class Coordinates:
    """Клас, що представляє координати."""

    def __init__(self, latitude=60, longitude=11, height=1500, crew=Crew.C1):
        """
        Ініціалізує об'єкт Coordinates.
        
        Аргументи:
        latitude (int): Широта в градусах. За замовчуванням 60.
        longitude (int): Довгота в градусах. За замовчуванням 11.
        height (int): Висота польоту в метрах. За замовчуванням 1500.
        crew (Crew): Екіпаж літака. За замовчуванням 1.
        """
        self.set_latitude(latitude)
        self.set_longitude(longitude)
        self.height = height
        self.crew = crew

    def get_latitude(self):
        """
        Отримує широту.
        
        Повертає:
        int: широту в градусах.
        """
        return self.latitude

    def get_longitude(self):
        """
        Отримує довготу.
        
        Повертає:
        int: довготу в градусах.
        """
        return self.longitude

    def get_height(self):
        """
        Отримує висоту.
        
        Повертає:
        int: висоту польоту в метрах.
        """
        return self.height

    def get_crew(self):
        """
        Отримує екіпаж.
        
        Повертає:
        int: кількість членів екіпажу.
        """
        return self.crew.value

    def set_latitude(self, latitude):
        """
        Встановлює широту.
        
        Аргументи:
        latitude (int): Нова широта в градусах.
        """
        if -90 <= latitude <= 90:
            self.latitude = latitude
        else:
            raise ValueError("Широта повинна бути в діапазоні [-90, 90]")

    def set_longitude(self, longitude):
        """
        Встановлює довготу.
        
        Аргументи:
        longitude (int): Нова довгота в градусах.
        """
        if -180 <= longitude <= 180:
            self.longitude = longitude
        else:
            raise ValueError("Довгота повинна бути в діапазоні [-180, 180]")

    def set_height(self, height):
        """
        Встановлює висоту.
        
        Аргументи:
        height (int): Нова висота в метрах.
        """
        self.height = height

    def set_crew(self, crew):
        """
        Встановлює екіпаж.
        
        Аргументи:
        crew (int): нова кількість членів екіпажу.
        """
        self.crew = crew
