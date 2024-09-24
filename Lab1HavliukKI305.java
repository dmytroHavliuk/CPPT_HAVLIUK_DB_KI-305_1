import java.io.*;
import java.util.*;

/**
* Клас <code>Lab1HavliukKI305</code> виконує програму до завдання 
* лабораторної роботи №1.
* Програма створює матрицю з символів, заданого користувачем, 
* і зберігає її у файл.
* @author Dmytro Havliuk
* @version 2.0
*/

public class Lab1HavliukKI305 {
	
	/**
	 * <code>main</code> є точкою входу в програму.
	 * Програма запитує розмір матриці та символ-заповнювач,
	 * створює зубчасту матрицю з цими даними, виводить її в консоль
	 * і записує в файл.
	 * @param args Аргументи командного рядка (не використовуються в даній програмі).
	 * @throws FileNotFoundException Якщо файл не може бути створений або відкритий для запису.
	 */
    public static void main(String[] args) throws FileNotFoundException {
        int nRows;
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);
        
        System.out.print("Введіть розмір матриці: ");
        nRows = in.nextInt();
        in.nextLine();

        int a = nRows % 2 == 0 ? 1 : 0;

        char[][] arr = new char[nRows][];

        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();
        
        if (filler.length() != 1) {
            System.out.println("Неправильний символ-заповнювач.");
            System.exit(1);
        }

        int topRows = nRows % 2 == 0 ? nRows / 2 : nRows / 2 + 1;

        for (int i = 0; i < topRows; i++) {
            arr[i] = new char[nRows];
            for (int j = 0; j < nRows; j++) {
                if (j < i + 1 || j >= nRows - i - 1) {
                    arr[i][j] = filler.charAt(0);
                } else {
                    arr[i][j] = ' ';
                }
            }
        }

        for (int x = 0; x < topRows - 1; x++) {
            arr[topRows + x] = arr[topRows - 2 - x];
        }

        for (int i = 0; i < nRows - a; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                fout.print(arr[i][j] + " ");
            }
            fout.print("\n");
            System.out.print("\n");
        }

        fout.flush();
        fout.close();
    }
}
