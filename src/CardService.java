import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    	System.out.println("No. カード名 所持枚数");
    	for(Card card : cardList) {
    		System.out.println(card.getID() +" "+ card.getName()+" "+card.getQuantity() + "枚");
    	}
    	
    }
    public void searchCards(String searchName, String searchCost, String searchCivilization,
    						String searchRace, String searchPower, String searchType) {
    	
    	boolean found = false;
    	System.out.println("No. カード名　所持枚数");
    	
    	for(Card card : cardList) {
    		
    		boolean matchName = searchName.isEmpty() || card.getName().contains(searchName);
    		boolean matchCost = searchCost.isEmpty() || card.getCost().contains(searchCost);
    		boolean matchCivilization = searchCivilization.isEmpty() || card.getCivilization().contains(searchCivilization);
    		boolean matchRace = searchRace.isEmpty() || card.getRace().contains(searchRace);
    		boolean matchPower = searchPower.isEmpty() || card.getPower().contains(searchPower);
    		boolean matchCardType = searchType.isEmpty() || card.getCardType().contains(searchType);
    		
    		if(matchName && matchCost && matchCivilization && matchRace && matchPower && matchCardType) {
    			System.out.println(card.getID() + " " + card.getName() +" "+ card.getQuantity() + "枚");
    			found = true;
    		}
    		
    	}
    }

    // 3. Update (更新)
    public void updateQuantity(String id, int newQuantity) {
    	boolean found = false;
    	
    }

    // 4. Delete (削除)
    public void removeCard(String id) {
    }
    
    
    public int getcardcount(){
    	return cardList.size();
    }
    
    // CSV
    public void saveToCsv() {
    	String filePath = "card.csv";
    	try(PrintWriter writer = new PrintWriter(new FileWriter(filePath))){
    		writer.println("ID,名前,コスト,文明,種族,パワー,カードタイプ,所持枚数");
    		for(Card card : cardList) {
    			String line = card.getID()+","+card.getName()+","+card.getCost()+","+
    					card.getCivilization()+","+card.getRace()+","+card.getPower()+","+
    					card.getCardType()+","+card.getQuantity();
    					
    			writer.println(line);
    		}
    		System.out.println("データをCSVファイル("+ filePath +")に保存しました。");
    	} catch(IOException e) {
    		System.out.println("ファイルの保存中にエラーが発生しました:"+ e.getMessage());
    	}
    }
    public void loadFromCsv() {
    	String filePath = "card.csv";
    	File file = new File(filePath);
    	if(!file.exists()) {
    		return;
    	}
    	try(BufferedReader reader = new BufferedReader(new FileReader(file))){
    		String line = reader.readLine();
    		
    		while((line = reader.readLine()) != null) {
    			String[] data = line.split(",");
    			
    			String id = data[0];
    			String name = data[1];
    			String cost = data[2];
    			String civilization = data[3];
    			String race = data[4];
    			String power = data[5];
    			String cardType = data[6];

    			int quantity = Integer.parseInt(data[7]);
    			Card loadedCard = new Card(id, name, cost, civilization, race, power, cardType, quantity);
    			cardList.add(loadedCard);
    		}
    	}catch(Exception e) {
    		System.out.println("読み込み中にエラーが発生しました"+ e.getMessage());
    	}
    }
}
