import board.*;
import player.*;
import game.*;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("___________________________GAME_______________________________\n     ___________________Tic Tac Toc ____________________");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter board size (NxN)");
        int s=sc.nextInt();
        Board b =new Board(s,'_');
       System.out.println("Enter player 1 Details (name & symbol)");
       String p1name=sc.next();
       char p1symbol=sc.next().charAt(0); 
       System.out.println("Enter player 2 Details (name & symbol)");
       String p2name=sc.next();
       char p2symbol=sc.next().charAt(0);
       Player p1=new Player();
       Player p2=new Player();
       p1.setDetails(p1name,p1symbol);
       p1.showDetails();
       p2.setDetails(p2name,p2symbol);
       p2.showDetails();
       Game g=new Game(new Player[]{p1,p2},b);
       g.play();
    }
}
