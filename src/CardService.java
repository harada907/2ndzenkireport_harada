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
    public void displayCardById(String id) {
    	boolean found = false;
    	
    	for(Card card:cardList) {
    		if(card.getID().equals(id)) {
    			System.out.println(" カード詳細情報------");
                System.out.println("ID: " + card.getID());
                System.out.println("カード名: " + card.getName());
                System.out.println("コスト: " + card.getCost());
                System.out.println("文明: " + card.getCivilization());
                System.out.println("種族: " + card.getRace());
                System.out.println("パワー: " + card.getPower());
                System.out.println("カードタイプ: " + card.getCardType());
                System.out.println("所持枚数: " + card.getQuantity() + "枚");
                System.out.println("---------------------");
                found = true;
                break;
    		}
    	}
    	if(!found) {
    		System.out.println("エラー:指定されたID("+ id +"のカードは見つかりませんでした。" );
    	}
    
    }

    // 3. Update (更新)
    public void updateCard(String id, String name, String cost, String civilization,
    				String race, String power, String cardType, String quantityStr) {
    	boolean found = false;
    	
    	for(Card card : cardList) {
    		if(card.getID().equals(id)) {
    			
    			if(!name.isEmpty()) {card.setName(name);}
    			if(!cost.isEmpty()) {card.setCost(cost);}
    			if(!civilization.isEmpty()) {card.setCivilization(civilization);}
    			if(!race.isEmpty()) {card.setRace(race);}
    			if(!power.isEmpty()) {card.setPower(power);}
    			if(!cardType.isEmpty()) {card.setCardType(cardType);}
    			//str→int変換
    			if(!quantityStr.isEmpty()) {
				card.setQuantity(Integer.parseInt(quantityStr));
    			}
    			System.out.println("カードID:" + id + "の情報を更新しました");
    			found = true;
    			break;
    		}
    	}
    	if(!found) {
    		System.out.println("指定されたID("+ id +")のカードは見つかりませんでした");
    	}
    }

    // 4. Delete (削除)
    public void removeCard(String id) {
    	Card tergetCard = null;
    	
    	for(Card card : cardList) {
    		if(card.getID().equals(id)) {
    			tergetCard = card;
    			break;
    		}
    	}
    	
    	if(tergetCard != null) {
    		cardList.remove(tergetCard);
    		System.out.println("カードID: "+ id +"のデータを削除しました。");
    	}else {
			System.out.println("エラー:指定されたID("+ id +")のカードは見つかりませんでした。");
		}
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
