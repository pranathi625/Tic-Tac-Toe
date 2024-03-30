package game;
import board.Board;
import java.util.*;
import player.Player;
public class Game {
        Player[] player;
        Board board;
        int turn;
        int noOfMoves;
        boolean gameOver;
        String zero;
        String cross;
        private int size;
        public Game(Player[] player,Board board){
                this.player=player;
                this.board=board;
                this.turn=0;
                this.noOfMoves=0;
                this.gameOver=false;
                StringBuilder z=new StringBuilder();
                StringBuilder c=new StringBuilder();
                for(int i=0;i<board.size;i++){
                        z.append('0');
                        c.append('X');
                }
                this.zero=z.toString();
                this.cross=c.toString();

        }
        public void printBoardconfig(){
                int sz=this.board.size;
                for(int i=0;i<sz;i++){
                        for(int j=0;j<sz;j++){
                                System.out.print(board.mat[i][j]+" ");
                        }
                        System.out.println();
                }
        }
        public void play(){
                printBoardconfig();
                int s=board.size;
                while(!gameOver){
                        noOfMoves++;
                        int ind=getIndex();
                        int r=ind/s;
                        int c=ind%s;
                        board.mat[r][c]=player[turn].getPlayerSymbol();
                        if(noOfMoves>=s*s){
                                System.out.println("Game Draw");
                                return; 
                        }
                        if(noOfMoves>=2*s-1 && checkcombination()){
                                gameOver=true;
                                printBoardconfig();
                                System.out.println("Winner is: "+player[turn].getPlayerName());
                                return;
                        }
                        turn=(turn+1)%2;
                        printBoardconfig();
                }
        }
        public int getIndex() {
                while(true){
                        System.out.println("Player: "+player[turn].getPlayerName()+" give one position ");
                        Scanner sc=new Scanner(System.in);
                        int pos=sc.nextInt()-1;
                        int s=board.size;
                        int row=pos/s;
                        int col=pos%s;
                        if(row<0 || row>=s || col<0 || col>=s ){
                                System.out.println("Invalid position");
                                continue;
                        }
                        if(board.mat[row][col]!='_'){
                                System.out.println("Position already occupied");
                                continue;
                        }
                        return pos;
                }
        }
        public boolean checkcombination(){
                int s=board.size;
                //row wise
                for(int i=0;i<s;i++){
                        StringBuilder sb=new StringBuilder();
                        for(int j=0;j<s;j++){
                              sb.append(board.mat[i][j]);  
                        }
                        String p=sb.toString(); 
                        if(p.equals(zero) || p.equals(cross)){
                                return true;
                        }
                }
                //column wise
                for(int i=0;i<s;i++){
                      StringBuilder sb=new StringBuilder();
                      for(int j=0;j<s;j++){
                        sb.append(board.mat[j][i]);
                      }
                      String p=sb.toString(); 
                      if(p.equals(zero) || p.equals(cross)){
                              return true;
                      }
                }
                //diagonal wise
                int i=0,j=0;
                StringBuilder sb=new StringBuilder();
                while(i<s){
                        sb.append(board.mat[i][j]);

                        i++;
                        j++;
                }
                String p=sb.toString();
                if(p.equals(zero) || p.equals(cross)){
                        return true;
                }
                //anti diagonal
                i=0;
                j=s-1;
                sb=new StringBuilder();
                while(i<s){
                        sb.append(board.mat[i][j]);

                        i++;
                        j--;
                }
                p=sb.toString();
                if(p.equals(zero) || p.equals(cross)){
                        return true;
                }
                return false;
        }
}
