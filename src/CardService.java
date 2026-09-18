import java.util.ArrayList;
import java.util.List;

public class CardService {
    private List<Card> cardList = new ArrayList<>(); 

    // 1. Create (登録)
    public void addCard(Card card) {
        cardList.add(card);
        System.out.println(card.getName() + "を登録しました。");
    }

    // 2. Read (一覧・検索)
    public void displayAllCards(){
    	if(cardList.isEmpty()){
    		System.out.println("現在、ストレージに登録されているカードはありません。");
    		return;
    	}
    	System.out.println("No. カード名");
    	for(Card card : cardList) {
    		System.out.println(card.getID() +"　　"+ card.getName());
    	}
    	
    }
    public void searchCards(String keyword) {
    }

    // 3. Update (更新)
    public void updateQuantity(String id, int newQuantity) {
    }

    // 4. Delete (削除)
    public void removeCard(String id) {
    }
    
    
    public int getcardcount(){
    	return cardList.size();
    }
    
    // CSV
    public void saveToCsv(String filePath) {}
    public void loadFromCsv(String filePath) {}
}
