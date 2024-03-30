package player;
public class Player {
    String name;
    char symbol;
    public void setDetails(String name,char symbol){
        this.name=name;
        this.symbol=symbol;
    }
    public void showDetails(){
        System.out.println("Name: "+this.name);
        System.out.println("symbol: "+this.symbol);
    }
    public String getPlayerName(){
        return this.name;
    }
    public char getPlayerSymbol(){
        return this.symbol;
    }
}
