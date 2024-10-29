import sys

def get_matrix_size():
    """
    Отримує розмір квадратної матриці від користувача.
    Повертає:
    int: Розмір матриці.
    """
    while True:
        size = int(input("Введіть розмір квадратної матриці (парне число): "))
        if size <= 0:
            print("Розмір має бути більше нуля.")
        elif size % 2 != 0:
            print("Розмір має бути парним числом.")
        else:
            return size

def get_fill_char():
    """
    Отримує символ-заповнювач від користувача.
    Повертає:
    str: Символ-заповнювач.
    """
    fill_char = input("Введіть символ-заповнювач: ")
    if len(fill_char) != 1:
        print("Введіть тільки один символ.")
        sys.exit(1)
    return fill_char

def gen_arr(matrix_size, fill_char):
    """
    Генерує зубчастий масив з патерном відповідно до заданого розміру та символу заповнювача.
    Параметри:
    matrix_size (int): Розмір квадратної матриці.
    fill_char (str): Символ-заповнювач.
    Повертає:
    list: Зубчастий масив із символами-заповнювачами.
    """
    arr = []
    
    for i in range(matrix_size):
        row = []
        for j in range(matrix_size):
            if i == j or j == matrix_size - i - 1 or (j < i and j < matrix_size - i - 1) or (j > i and j > matrix_size - i - 1):
                row.append(fill_char)
        arr.append(row)
    
    return arr

def print_pattern(arr, matrix_size, fill_char):
    """
    Виводить зубчастий масив у вигляді квадратного патерну з пробілами.
    Параметри:
    arr (list): Зубчастий масив для виведення.
    matrix_size (int): Розмір квадратної матриці.
    fill_char (str): Символ-заповнювач.
    """
    for i in range(matrix_size):
        row_output = []
        fill_index = 0
        for j in range(matrix_size):
            if (i == j or j == matrix_size - i - 1 or 
                (j < i and j < matrix_size - i - 1) or 
                (j > i and j > matrix_size - i - 1)):
                row_output.append(arr[i][fill_index])
                fill_index += 1
            else:
                row_output.append(" ")
        print("".join(row_output))

