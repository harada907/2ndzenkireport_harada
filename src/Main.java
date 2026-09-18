public class Main {
    public static void main(String[] args) {
        CardService cardService = new CardService();
        
        cardService.loadFromCsv("cards.csv");
        Menu menu = new Menu(cardService);
        menu.displayMenu();
    }
}
