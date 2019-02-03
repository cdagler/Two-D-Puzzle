/** This class represents a Two-D puzzle board. A space on the board is represented 
 * by a '-'. Puzzle pieces can be added to this board using the PuzzlePiece class. 
 * 
 * @author Clay Dagler
 */

import java.util.ArrayList;

public class PuzzleBoard {
   char[][] board;
   ArrayList<PuzzlePiece> pieces = new ArrayList<PuzzlePiece>();

   /** Setting up the board.
    * 
    * @param width The width of the board, must be less than 10.
    * @param length The length of the board, must be less than 10.
    */
   public PuzzleBoard(int width, int length) {
      if(width>=10 || length>=10){
         System.out.println("Sorry the board can not be that big.");
         System.exit(1);
      }
      board = new char[width][length];
      clearBoard();
   }

   /**
    * This adds a puzzle piece to the game but does not place it on the board.
    *
    * @parm puzzlePiece The puzzle piece to be added to the game.
    */
   public void addPiece(char[][] puzzlePiece) {
      pieces.add(new PuzzlePiece(puzzlePiece));
   }

   public int getNumPeices() {
      return pieces.size();
   }

   /** This removes all of the pieces from the board */
   public void clearBoard() {
      for (int i = 0; i < board.length; i++)
         for (int j = 0; j < board[0].length; j++)
            board[i][j] = '-';
   }

   /**
    * This attempts to set a piece on the board where the upper left-hand corner of
    * the piece is at (row, col). Note that the square at (row, col) may be empty. A
    * piece cannot be added to the board if it will cover an existing piece on the
    * board or if part of the piece lies outside of the board.
    * 
    * @param num The piece number to be placed on the board. with the first piece
    *            being number 0.
    * @param row The row where the top of the piece is to be placed.
    * @param col The column where the left most part of the piece is to be placed.
    * @return false if the piece can not be placed on the board, true otherwise.
    */
   public boolean setPiece(int num, int row, int col) {
      if (row+pieces.get(num).getWidth()>board.length || col+pieces.get(num).getLength()>board[0].length)
         return false;

      for (int i=0; i<pieces.get(num).getWidth(); i++)
         for (int j=0; j<pieces.get(num).getLength(); j++) {
            if(board[row+i][col+j]!='-' && pieces.get(num).getSquare(i, j)!='-')
               return false;
            else if(board[row+i][col+j]=='-')
               board[row+i][col+j] = pieces.get(num).getSquare(i, j);
         }
      return true;
   }

   public String toString() {
      String ans = "  ";

      for(int i = 0; i < board[0].length; i++)
         ans += i + " ";
      ans += "\n";

      for (int i = 0; i < board.length; i++) {
         ans +=  i + " " ;
         for (int j = 0; j < board[0].length; j++)
            ans += board[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }
}