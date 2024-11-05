class Engine:
    """Клас, що представляє двигун з двома станами."""

    def __init__(self, state=False):
        """
        Ініціалізує об'єкт Engine.
        
        Аргументи:
        state (bool): Початковий стан двигуна. За замовчуванням False.
        """
        self.state = state

    def start(self):
        """Запускає двигун."""
        self.state = True

    def stop(self):
        """Зупиняє двигун."""
        self.state = False

    def set_state(self, state):
        """Встановлює стан двигуна."""
        self.state = state

    def get_state(self):
        """Отримує поточний стан двигуна."""
        return self.state
