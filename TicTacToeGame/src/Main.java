import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board=new char[3][3];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
        char player='X';
        boolean gameover=false;
        Scanner sc=new Scanner(System.in);
        while(!gameover){
            printboard(board);
            System.out.println("Player "+ player+ " enter: ");
            int row=sc.nextInt();
            int col=sc.nextInt();
            System.out.println();

            if(board[row][col]==' '){
                board[row][col]=player;
                gameover=havewon(board,player);
                if(gameover){
                    System.out.println("Player "+ player+ " has won: ");
                }
                else{
                    if(player=='X'){
                        player='O';
                    }else{
                        player='X';
                    }
                }
            }
            else{
                System.out.println("Invalid move ! Try again");
            }
        }
    }

    private static boolean havewon(char[][] board, char player) {
        for(int i=0;i<board.length;i++){
            if(board[i][0]==player && board[i][1]==player && board[i][2]==player){
                return true;
            }
        }
        for(int i=0;i<board.length;i++){
            if(board[0][i]==player && board[1][i]==player && board[2][i]==player){
                return true;
            }
        }
        if (board[0][0]==player && board[1][1]==player && board[2][2]== player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;
    }

    private static void printboard(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+ " | ");
            }
            System.out.println();
        }
    }
}