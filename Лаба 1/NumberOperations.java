import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOperations {

    public static void main(String[] args) {
        // створюємо масив Number
        Number[] array = {10.0, 20.5, 30.0, 40.7, 50.0, 60.3, 70.0, 80.1, 90.0, 100.9};

        // створюємо список з масиву
        ArrayList<Number> mixedNumbers = new ArrayList<>(Arrays.asList(array));

        // виводимо вміст списку
        System.out.println(mixedNumbers);

        // Додаємо числа різних типів
        mixedNumbers.add((byte) 10);                     // byte
        mixedNumbers.add((short) 20);                    // short
        mixedNumbers.add(30);                          // int
        mixedNumbers.add(40L);                         // long
        mixedNumbers.add(50.5f);                       // float
        mixedNumbers.add(60.6);                        // double
        mixedNumbers.add(BigDecimal.valueOf(80.1));  // BigDecimal
        mixedNumbers.add((byte) 70);                     // byte
        mixedNumbers.add((short) 80);                    // short
        mixedNumbers.add(90);                          // int
        mixedNumbers.add(100L);                        // long
        mixedNumbers.add(BigDecimal.valueOf(50));    // BigDecimal

        // Виводимо числа на екран в початковому форматі
        System.out.println("Числа у початковому форматі:");
        System.out.println(mixedNumbers);

        // Виводимо числа у форматі цілих чисел
        System.out.println("\nЧисла у форматі цілих чисел:");
        for (Number num : mixedNumbers) {
            System.out.println(num.intValue());  // Перетворення в ціле число
        }

        // Виводимо числа у форматі дробних чисел з 2 знаками після коми
        System.out.println("\nЧисла у форматі дробних чисел (2 знаки після коми):");
        for (Number num : mixedNumbers) {
            System.out.printf("%.2f%n", num.doubleValue());  // Форматування з 2 знаками після коми
        }

        // Сортуємо числа в залежності від їх типу та додаємо до окремих списків
        Map<String, ArrayList<Number>> numbersByType = new HashMap<>();
        numbersByType.put("Byte", new ArrayList<>());
        numbersByType.put("Short", new ArrayList<>());
        numbersByType.put("Integer", new ArrayList<>());
        numbersByType.put("Long", new ArrayList<>());
        numbersByType.put("Float", new ArrayList<>());
        numbersByType.put("Double", new ArrayList<>());
        numbersByType.put("BigDecimal", new ArrayList<>());

        for (Number num : mixedNumbers) {
            if (num instanceof Byte) {
                numbersByType.get("Byte").add(num);
            } else if (num instanceof Short) {
                numbersByType.get("Short").add(num);
            } else if (num instanceof Integer) {
                numbersByType.get("Integer").add(num);
            } else if (num instanceof Long) {
                numbersByType.get("Long").add(num);
            } else if (num instanceof Float) {
                numbersByType.get("Float").add(num);
            } else if (num instanceof Double) {
                numbersByType.get("Double").add(num);
            } else if (num instanceof BigDecimal) {
                numbersByType.get("BigDecimal").add(num);
            }
        }

        // Виводимо числа за типами
        System.out.println("\nЧисла за типами:");
        for (String type : numbersByType.keySet()) {
            System.out.println(type + ": " + numbersByType.get(type));
        }

        // Знаходимо найбільше число у списку
        Number maxNumber = mixedNumbers.get(0);
        for (Number num : mixedNumbers) {
            if (num.doubleValue() > maxNumber.doubleValue()) {
                maxNumber = num;
            }
        }
        System.out.println("\nНайбільше число у списку: " + maxNumber);
    }
}
