public class Main {
    public static void main(String[] args) {
        CardService cardService = new CardService();
        
        cardService.loadFromCsv();
        Menu menu = new Menu(cardService);
        menu.displayMenu();
    }
}
