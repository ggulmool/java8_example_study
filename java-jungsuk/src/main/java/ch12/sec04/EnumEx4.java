package ch12.sec04;

abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {

  static int id = 0;
  int ordinal;
  String name = "";

  public int ordinal() {
    return ordinal;
  }

  public MyEnum(String name) {
    this.name = name;
    ordinal = id++;
  }

  public int compareTo(T t) {
    return ordinal - t.ordinal();
  }
}

abstract class MyTransprotation extends MyEnum {

  static final MyTransprotation BUS = new MyTransprotation("BUS", 100) {
    @Override
    int fare(int distance) {
      return distance * BASIC_FARE;
    }
  };
  static final MyTransprotation TRAIN = new MyTransprotation("TRAIN", 150) {
    @Override
    int fare(int distance) {
      return distance * BASIC_FARE;
    }
  };
  static final MyTransprotation SHIP = new MyTransprotation("SHIP", 100) {
    @Override
    int fare(int distance) {
      return distance * BASIC_FARE;
    }
  };
  static final MyTransprotation AIRPLANE = new MyTransprotation("AIRPLANE", 100) {
    @Override
    int fare(int distance) {
      return distance * BASIC_FARE;
    }
  };

  abstract int fare(int distance);

  protected final int BASIC_FARE;

  public MyTransprotation(String name, int basicFare) {
    super(name);
    BASIC_FARE = basicFare;
  }

  public String name() {
    return name;
  }

  public String toString() {
    return name;
  }

}

public class EnumEx4 {

  public static void main(String[] args) {
    MyTransprotation t1 = MyTransprotation.BUS;
    MyTransprotation t2 = MyTransprotation.BUS;
    MyTransprotation t3 = MyTransprotation.TRAIN;
    MyTransprotation t4 = MyTransprotation.SHIP;
    MyTransprotation t5 = MyTransprotation.AIRPLANE;

    System.out.printf("t1=%s, %d%n", t1.name(), t1.ordinal());
    System.out.printf("t2=%s, %d%n", t2.name(), t2.ordinal());
    System.out.printf("t3=%s, %d%n", t3.name(), t3.ordinal());
    System.out.printf("t4=%s, %d%n", t4.name(), t4.ordinal());
    System.out.printf("t5=%s, %d%n", t5.name(), t5.ordinal());
    System.out.println("t1==t2 ? " + (t1==t2));
    System.out.println("t1.compareTo(t3) = " + t1.compareTo(t3));
  }
}
