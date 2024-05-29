import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 * InputMismatchException
 * Изучите данный код. Все ли с ним хорошо? Если нет,
 * скорректируйте код, попробуйте обосновать свое решение.
 */
public class Task1 {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println(
                "Укажите индекс от 0 до 9 элемента массива, " +
                        "в который хотите записать значение 1");
        try {
            int index = scanner.nextInt();
            arr[index] = 1;
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Указан индекс за пределами массива");
        } catch (InputMismatchException e){
            System.err.println("Индекс должен быть числом");
            String x = null;
            while (!scanner.hasNextInt()){
               x = scanner.next();
                System.err.println("Вы снова ввели не число");
            }
            int y = Integer.parseInt(x);
            arr[y] = 1;
        }
    }
}