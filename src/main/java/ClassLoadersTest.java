public class ClassLoadersTest {
  public static void main(String[] args) {
    var boot = ModuleLayer.boot();
    boot.modules().forEach(module -> {
      var classLoader = module.getClassLoader();
      System.out.println(classLoader + ": " + module.getName());
    });
  }
}
