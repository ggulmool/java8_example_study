package ch04.sec01;

import static java.util.stream.Collectors.toList;

import ch04.Dish;
import ch04.Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java7And8Compare {

  public static void main(String[] args) {
    List<Dish> menus = Menu.menus();

    // 누적자로 요소 필터링
    List<Dish> lowCaloricDishes = new ArrayList<>();
    for (Dish d : menus) {
      if (d.getCalories() < 400) {
        lowCaloricDishes.add(d);
      }
    }

    // 익명클래스로 요리 정렬
    Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
      @Override
      public int compare(Dish o1, Dish o2) {
        return Integer.compare(o1.getCalories(), o2.getCalories());
      }
    });

    // 정렬된 리스트를 처리하면서 요리 이름 저장, lowCaloricDishes 중간변수, 결국 가비지변수
    List<String> java7LowCaloricDishesName = new ArrayList<>();
    for (Dish dish : lowCaloricDishes) {
      java7LowCaloricDishesName.add(dish.getName());
    }

    System.out.println("java7LowCaloricDishesName = " + java7LowCaloricDishesName);

    List<String> java8LowCaloricDishesName = menus.stream()
        .filter(d -> d.getCalories() < 400)
        .sorted(Comparator.comparing(Dish::getCalories))
        .map(Dish::getName)
        .collect(toList());

    System.out.println("java8LowCaloricDishesName = " + java8LowCaloricDishesName);
  }
}
