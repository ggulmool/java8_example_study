package ch04.sec04;

import static ch04.Menu.menus;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class OperationsExample {

  public static void main(String[] args) {
    List<String> names = menus().stream()
        .filter(d -> {
          System.out.println("filtering " + d.getName());
          return d.getCalories() > 300;
        })
        .map(d -> {
          System.out.println("mapping " + d.getName());
          return d.getName();
        })
        .limit(3)
        .collect(toList());

    // limit 에 의해 3개만 필터링이 작동하고 그 이후는 작동하지 않음 : short circuit
    // filter/map은 다른 연산이지만 하나로 병합되었다 : loop fusion
    System.out.println("names = " + names);
  }
}
