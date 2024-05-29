/**
 * NumberFormatException
 * Обработайте возможные исключительные ситуации. "Битые" значения
 * в исходном массиве считайте нулями. Можно внести в код правки,
 * которые считаете необходимыми
 */
public class Task2 {
    public static void main(String[] args) {
        String[][] arr = new String[][] {
                {"1", "1"},
                {"1", "1", "1", "1", "1"},
                {"1", "2"},
                {"3", "3"},
                {"2", "6"}
        };
        System.out.println(sum2d(arr));
    }

    private static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int val = Integer.parseInt(arr[i][j]);
                    sum += val;
                }catch (NumberFormatException e){
                    throw  new RuntimeException("Не валидные данные");
//                    System.out.println("Не валидные данные");
                }

            }
        }
        return sum;
    }
}