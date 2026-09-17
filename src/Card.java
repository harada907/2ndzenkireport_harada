public class Card {
    private String id;
    private String name;
    private String cost;
    private String civilization;
    private String race;
    private String power;
    private String cardType;
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
}
