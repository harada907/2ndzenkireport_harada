public class Main {
    public static void main(String[] args) {
        CardService cardService = new CardService();
        
        // 必要であれば起動時にCSVを読み込む
        // cardService.loadFromCsv("cards.csv");

        Menu menu = new Menu(cardService);
        menu.displayMenu(); // 開始 -> メニュー表示のフロー呼び出し
    }
}
