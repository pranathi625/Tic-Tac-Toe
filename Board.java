package board;
public class Board {
    public char mat[][];
    public int size;
    public Board(int size,char sy){
        this.size=size;
        mat=new char[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                mat[i][j]=sy;
            }
        }
    }  
}
