package ch05.sec06;

import static ch04.Menu.menus;

import ch04.Dish;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberStreamExample {

  public static void main(String[] args) {
    int caloriesSum = menus().stream()
        .mapToInt(Dish::getCalories)
        .sum();
    System.out.println("caloriesSum = " + caloriesSum);

    int caloriesMax = menus().stream()
        .mapToInt(Dish::getCalories)
        .max().orElse(1);
    System.out.println("caloriesMax = " + caloriesMax);

    IntStream rangeCloseEvenNumbers = IntStream.rangeClosed(1, 100)
        .filter(n -> n % 2 == 0);
    System.out.println("rangeCloseEvenNumbers.count() = " + rangeCloseEvenNumbers.count());

    IntStream rangeEvenNumbers = IntStream.range(1, 100) // 1과 100 미포함
        .filter(n -> n % 2 == 0);
    System.out.println("rangeEvenNumbers.count() = " + rangeEvenNumbers.count());

    // 피타고라스
    Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
        .flatMap(a ->
            IntStream.rangeClosed(a, 100)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .filter(t -> t[2] % 1 == 0)
        );

    pythagoreanTriples.limit(5)
        .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
  }
}
