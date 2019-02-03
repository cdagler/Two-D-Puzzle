/** This class represents a Two-D puzzle piece. The puzzle piece consists of a dimension 
 * [row by column] with each square being a color [represted by a single letter] or a space 
 * [represted by '-']. For example:
 *      R -
 *      R -
 *      R R
 * is a 3 by 2 red puzzle piece that is the shape of an 'L'.
 * 
 * @author Clay Dagler
 */
public class PuzzlePiece {
   private char[][] puzzlePice;

   public PuzzlePiece(char[][] puzzlePice) {
      this.puzzlePice = new char[puzzlePice.length][puzzlePice[0].length];
      for (int i = 0; i < puzzlePice.length; i++)
         for (int j = 0; j < puzzlePice[0].length; j++)
            this.puzzlePice[i][j] = puzzlePice[i][j];
   }

   /**
    * Returns the square value at a given peice.
    * 
    * @param r The row of the peice to be retrun.
    * @param c The column of the peice to be return
    * @return The value at the given peice.
    */
   public char getSquare(int r, int c) {

      return puzzlePice[r][c];
   }

   /**
    * @return The number of rows in the puzzle.
    */
   public int getWidth() {
      return puzzlePice.length;
   }

   /**
    * @return The number of columns in the puzzle.
    */
   public int getLength() {
      return puzzlePice[0].length;
   }

   public String toString()
   {
      String ans = "";
      for (int i = 0; i < puzzlePice.length; i++){
         for (int j = 0; j < puzzlePice[0].length; j++)
            ans += puzzlePice[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }
}