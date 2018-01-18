package ch12.sec01;

enum Direction {
  EAST, SOUTH, WEST, NORTH
}

public class EnumEx1 {

  public static void main(String[] args) {
    Direction d1 = Direction.EAST;
    Direction d2 = Direction.valueOf("WEST");
    Direction d3 = Direction.valueOf(Direction.class, "EAST");

    System.out.println("d1=" + d1);
    System.out.println("d2=" + d2);
    System.out.println("d2=" + d3);

    System.out.println("d1==d2 = " + (d1 == d2)); // false
    System.out.println("d1==d3 = " + (d1 == d3)); // true
    System.out.println("d1.equals(d3) = " + d1.equals(d3)); // true
    //System.out.println("d1>d3 = " + (d1 > d3)); compile error
    System.out.println("d1.compareTo(d3) = " + d1.compareTo(d3));
    System.out.println("d1.compareTo(d2) = " + d1.compareTo(d2));

    switch (d1) {
      case EAST:
        System.out.println("The dirction is EAST."); break;
      case WEST:
        System.out.println("The dirction is WEST."); break;
      case NORTH:
        System.out.println("The dirction is NORTH."); break;
      case SOUTH:
        System.out.println("The dirction is SOUTH."); break;
    }

    Direction[] values = Direction.values();
    for (Direction direction : values) {
      System.out.printf("%s=%d%n", direction.name(), direction.ordinal());
    }
  }
}
