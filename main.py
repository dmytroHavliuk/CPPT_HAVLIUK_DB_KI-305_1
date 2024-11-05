from Bomber import Bomber

def main():
    """Головна функція для демонстрації роботи класу Bomber."""
    print("Створення Bomber...")
    bomber = Bomber()

    print("\n--- Демонстрація базових властивостей ---")
    print(f"Стан двигуна: {'Заведений' if bomber.is_flying() else 'Не заведений'}")

    if not bomber.is_flying():
        bomber.start_engine()
        print("Запуск двигуна: Успішно")
    else:
        print("Запуск двигуна: Двигун вже заведений")

    print(f"Координати: ({bomber.get_latitude()}, {bomber.get_longitude()}), висота польоту: {bomber.get_height()} метрів")
    print(f"Екіпаж складається з: {bomber.get_crew()} пілота(ів)")

    if bomber.is_flying():
        bomber.stop_engine()
        print("Зупинка двигуна: Успішно")
    else:
        print("Зупинка двигуна: Двигун вже зупинений")

    print("\n--- Демонстрація спеціальних можливостей ---")

    print(bomber.load_bombs(10))
    print(f"Кількість споряджених бомб: {bomber.get_bomb_count()}")

    print("\n--- Відправка на завдання ---")
    bomber.start_engine()
    print("Запуск двигуна: Успішно")

    bomber.set_mission()
    print(f"Завдання встановлено: {'Так' if bomber.is_on_mission() else 'Ні'}")

    print("\n--- Скидання бомб ---")
    print(bomber.drop_bombs())
    print(f"Кількість споряджених бомб: {bomber.get_bomb_count()}")

    bomber.stop_engine()
    print("Зупинка двигуна: Успішно")

    print("\n--- Завершення завдання ---")
    bomber.finish_mission()
    print(f"Завдання виконано: {'Ні' if bomber.is_on_mission() else 'Так'}")


if __name__ == "__main__":
    main()
