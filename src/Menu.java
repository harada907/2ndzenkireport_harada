public class Menu {
    private CardService cardService;

    public Menu(CardService cardService) {
        this.cardService = cardService;
    }

    public void displayMenu() {
        boolean isRunning = true;

        while (isRunning) { // 処理終了後、メニューへ戻るループ
            System.out.println("\n=== デュエル・マスターズデジタルファイリング ===");
            System.out.println("1. 登録");
            System.out.println("2. 検索・表示");
            System.out.println("3. 更新");
            System.out.println("4. 削除");
            System.out.println("0. 終了");

            int choice = InputUtil.readInt("番号を入力してください: ");

            switch (choice) {
                case 1: // 登録_cardService.addCard
                    break;
                case 2: // 検索・表示
                    handleSearchMenu();
                    break;
                case 3: // 更新_cardService.updateQuantity
                    break;
                case 4: // 削除_cardService.removeCard
                    break;
                case 0: // 終了
                    isRunning = false;
                    System.out.println("終了します。");
                    break;
                default:
                    System.out.println("正しい番号を入力してください。");
            }
        }
    }

    // 検索・表示の分岐
    private void handleSearchMenu() {
        System.out.println("  1. 全表示");
        System.out.println("  2. 検索表示");
        int searchChoice = InputUtil.readInt("  表示方法を選択してください: ");
        
        if (searchChoice == 1) {
            cardService.displayAllCards();
        } else if (searchChoice == 2) {
            String keyword = InputUtil.readString("  検索キーワードを入力: ");
            cardService.searchCards(keyword);
        } else {
            System.out.println("  無効な選択です。");
        }
    }
}
