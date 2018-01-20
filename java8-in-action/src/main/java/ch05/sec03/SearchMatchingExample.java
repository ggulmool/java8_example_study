package ch05.sec03;

import static ch04.Menu.menus;

import ch04.Dish;
import java.util.Arrays;
import java.util.List;

public class SearchMatchingExample {

  public static void main(String[] args) {
    if (menus().stream().anyMatch(Dish::isVegetarian)) {
      System.out.println("vegetarian friendly!!");
    }

    //boolean isHealthy = menus().stream().allMatch(d -> d.getCalories() < 1000);
    boolean isHealthy = menus().stream().noneMatch(d -> d.getCalories() >= 1000);
    System.out.println("isHealthy = " + isHealthy);

    // findAny 임의의 요소를 반환한다.
    menus().stream()
        .filter(Dish::isVegetarian)
        .findAny()
        .ifPresent(System.out::println);

    List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
    someNumbers.stream()
        .map(x -> x * x)
        .filter(x -> x % 3 == 0)
        .findFirst()
        .ifPresent(n -> System.out.println("first % 3 number = " + n));

  }
}
