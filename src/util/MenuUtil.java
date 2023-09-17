package util;

public class MenuUtil {
    private static MenuUtil instance;
    private MenuUtil(){}

    public static MenuUtil getInstance() {
        return instance == null ? instance = new MenuUtil() : instance;
    }
    public int entryMenu(){
        System.out.println(
                "[0]. Exit\n" +
                "[1]. Azerbaijan to English\n" +
                "[2]. English to Azerbaijan\n" +
                "[3]. Show Word\n" +
                "[4]. Add word");
        return InputUtil.getInstance().inputInt("Choose option: ");
    }

}
