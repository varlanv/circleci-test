import java.util.List;

public class JavaClazz {

  public static void main(String[] args) {
    new JavaClazz().smth();
  }

  void smth() {
    List.of(1).stream().forEach((it) -> {

      List.of(1).stream().forEach((itt) -> {
        System.out.println(this);
      });

      System.out.println(this);
    });
  }
}
