class Mission:
    """Клас, що представляє завдання."""

    def __init__(self):
        """Ініціалізує об'єкт Mission."""
        self.on_mission = False

    def is_on_mission(self):
        """
        Перевіряє, чи літак на завданні.
        
        Повертає:
        bool: True, якщо літак на завданні, інакше False.
        """
        return self.on_mission

    def set_mission(self):
        """Надає завдання."""
        self.on_mission = True

    def finish_mission(self):
        """Завершує завдання."""
        self.on_mission = False
