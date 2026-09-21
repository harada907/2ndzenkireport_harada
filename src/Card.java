public class Card {
    private String id;
    private String name;
    private String cost;
    private String civilization;//文明
    private String race;//種族
    private String power;
    private String cardType;//クリーチャー,呪文,ツインパクト等
    private int quantity; //量

    // コンストラクタ
    public Card(String id, String name, String cost, String civilization, 
                String race, String power, String cardType, int quantity) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.civilization = civilization;
        this.race = race;
        this.power = power;
        this.cardType = cardType;
        this.quantity = quantity;
    }

    //ゲッターとセッター
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getID() { return id; }
    public String getCost() {return cost; }
    public String getCivilization() {return civilization; }
    public String getRace() {return race; }
    public String getPower() {return power; }
    public String getCardType() {return cardType ;}
    
    public void setName(String name) {this.name = name;}
    public void setCost(String cost) {this.cost = cost;}
    public void setCivilization(String civilization) {this.civilization = civilization;}
    public void setRace(String race) {this.race = race;}
    public void setPower(String power) {this.power = power;}
    public void setCardType(String cardType) {this.cardType = cardType;}
    
}
