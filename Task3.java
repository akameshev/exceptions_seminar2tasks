import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Запишите в файл следующие строки:
 * <p>
 * Анна=4
 * Елена=5
 * Марина=6
 * Владимир=?
 * Полина=?
 * Константин=?
 * Иван=4
 * <p>
 * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap,
 * если студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных,
 * если сохранено значение ?, заменить его на соответствующее число.Если на каком-то месте
 * встречается символ, отличный от числа или ?, бросить подходящее исключение.
 * Записать в тот же файл данные с замененными символами ?.
 */
public class Task3 {
    private static final List<String> strings = List.of
            ("Анна=4", "Елена=5", "Марина=6", "Полина=?", "Владимир=?", "Константин=?", "Иван=4");
    //для проверки, заменить какое-то из значений на null

    public static void main(String[] args) {
        String path = "task3.txt";
        writeToFile(strings,path);
        //System.out.println(analyze(path));
        rewriteFile(path);
    }

    public static void writeToFile(List<String> list, String path) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            for (String str : list) {
                fileWriter.write(str + "\n");
            }
            fileWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Map<String,Integer> analyze(String path){
        BufferedReader bufferedReader = null;
        Map<String,Integer> result = new HashMap<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                String[] arr = line.split("=");//["Анна","4"]
                String key = arr[0];
                int value;

                try{
                    value = Integer.parseInt(arr[1]);

                } catch (NumberFormatException e){
                    if(arr[1].equals("?")) value = key.length();
                    else throw new RuntimeException("Ошибка");
                }
                result.put(key,value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
    public  static void rewriteFile(String path){
        Map<String,Integer> map = analyze(path);
        List <String> list = new ArrayList<>();
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            list.add(entry.toString());
        }
        writeToFile(list,path);
    }
}