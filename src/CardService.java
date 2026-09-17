import java.util.ArrayList;
import java.util.List;

public class CardService {
    private List<Card> cardList = new ArrayList<>(); // コレクションを利用

    // 1. Create (登録)
    public void addCard(Card card) {
        cardList.add(card);
        System.out.println("カードを登録しました。");
    }

    // 2. Read (一覧・検索)
    public void displayAllCards() {
        // 全表示モード
    }
    public void searchCards(String keyword) {
        // 検索表示モード
    }

    // 3. Update (更新)
    public void updateQuantity(String id, int newQuantity) {
        // 所持枚数の更新処理
    }

    // 4. Delete (削除)
    public void removeCard(String id) {
        // カード削除処理
    }

    // CSV
    public void saveToCsv(String filePath) {}
    public void loadFromCsv(String filePath) {}
}
