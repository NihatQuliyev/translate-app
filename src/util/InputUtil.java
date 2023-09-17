package util;

import java.util.Scanner;

public class InputUtil {
    private static  InputUtil instance;

    private InputUtil() {
    }

    public static InputUtil getInstance() {
        return instance == null ? instance = new InputUtil() : instance;
    }

    public int inputInt(String title){
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextInt();
    }
    public String inputString(String title){
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextLine();
    }
}
