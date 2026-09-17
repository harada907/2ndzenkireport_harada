import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    // 文字列の入力を受け取る
    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // 数値受け取って文字入力エラー
    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("エラー: 数字を入力してください。");
            }
        }
    }
}
