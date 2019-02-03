/** This is the first test for the classes PuzzlePiece and PuzzleBoard. To do this, the 
 * program, using file redirection, reads in the contents from in1.txt which creates a 4 
 * by 4 board and add four different shapes to it. 
 * 
 * @author Clay Dagler
 */
import java.util.Scanner; 

public class Main1 {
   public static void main(String[] args) {
      PuzzleBoard puzzleBoard;
      Scanner in = new Scanner(System.in);
      int r, c, pieceNum;
      char[][] currentPeice;

      /* Setting up the board */
      r = in.nextInt();
      c = in.nextInt();
      puzzleBoard = new PuzzleBoard(r,c);
      System.out.println(puzzleBoard);

      /* Getting all of the pieces */
      r = in.nextInt();
      c = in.nextInt();
      while(r!=0 || c!=0) {
         currentPeice = new char[r][c];
         for(int i=0; i<r; i++)
            for(int j=0; j<c; j++)
               currentPeice[i][j] = in.next().charAt(0);
         puzzleBoard.addPiece(currentPeice);
         r = in.nextInt();
         c = in.nextInt();
      }

      /* Adding the pieces to the board and outputting the board each time */
      for(int i=0; i<puzzleBoard.getNumPeices(); i++) {
         pieceNum = in.nextInt();
         r = in.nextInt();
         c = in.nextInt();

         if(puzzleBoard.setPiece(pieceNum, r, c))
            System.out.println(puzzleBoard);
         else 
            System.out.println("Sorry, I could not add the peice.");
      }
   }
}