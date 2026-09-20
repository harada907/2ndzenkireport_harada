public class Menu {
    private CardService cardService;

    public Menu(CardService cardService) {
        this.cardService = cardService;
    }

    public void displayMenu() {
        boolean isRunning = true;

        while (isRunning) { // 処理終了後、メニューへ戻るループ
            System.out.println("=== デュエル・マスターズデジタルファイリング ===");
            System.out.println("1. 登録");
            System.out.println("2. 検索・表示");
            System.out.println("3. 更新");
            System.out.println("4. 削除");
            System.out.println("0. 終了");

            int choice = InputUtil.readInt("番号を入力してください: ");

            switch (choice) {
                case 1: 
                    System.out.println("--- カード登録 ---");
                    String name = InputUtil.readString("カード名を入力: ");
                    String cost = InputUtil.readString("コストを入力: ");
                    String civilization = InputUtil.readString("文明を入力: ");
                    String race = InputUtil.readString("種族を入力: ");
                    String power = InputUtil.readString("パワーを入力: ");
                    String cardType = InputUtil.readString("カードタイプを入力: ");
                    int quantity = InputUtil.readInt("所持枚数を入力: ");

                    
                    int currentCount = cardService.getcardcount();
                    String autoID = String.valueOf(currentCount + 1);
                    Card newCard = new Card(autoID, name, cost, civilization, race, power, cardType, quantity);
                    
                    cardService.addCard(newCard);
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
        int searchChoice = InputUtil.readInt("表示方法を選択してください: ");
        
        if (searchChoice == 1) {
            cardService.displayAllCards();
        } else if (searchChoice == 2) {
            String keyword = InputUtil.readString("検索条件を指定してください(指定しない項目はそのままEnter)");
            String name = InputUtil.readString("カード名:");
            String cost = InputUtil.readString("コスト:");
            String civilization = InputUtil.readString("文明:");
            String race = InputUtil.readString("種族:");
            String power = InputUtil.readString("パワー:");
            String cardType = InputUtil.readString("カードタイプ:");
            
            System.out.println("検索します...");
            cardService.searchCards(name,cost,civilization,race,power,cardType);
        } else {
            System.out.println("  無効な選択です。");
        }
    }
}
