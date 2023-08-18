/******************************************************* 
  * Coordinatefinder.java
  * 
  * finds the coordinates for various stuff on the map
  ******************************************************/

public class Coordinatefinder {
  int[][] gMap;
  int rows, columns; // int variables
  private int guyX, guyY; // stuff that i dont want you to change
  
  
  /**************************************************************
    * public Coordinatefinder (int[][]maps, int rowN, int colN)
    * 
    * look for the guy's starting x and y locations based 
    * on the map and the number of rows and columns
    * ***********************************************************/
  
  public Coordinatefinder(int[][] maps, int rowN, int colN) {
// set values to values from constructor
    gMap = maps;
    rows = rowN;
    columns = colN;
    
    for (int r = 0; r < rows; r++) { // loops through the rows
      
      for (int c = 0; c < columns; c++) { // loops through the columns
        
        if (gMap[r][c] == 3) { // looks for the player
          
          guyX = r; // set the x coordinate
          guyY = c; // set the y coordinate
        }
      }
    }
  }
  
  
  /******************************************************* 
    * public int getCharX()
    * 
    * return the starting x location of character
    * *************************************************/
  
  public int getCharX() {
    return guyX; // return the guy x location
  }
  
  
  /******************************************************* 
    * public int getCharY()
    * 
    * return the starting y location of character
    * *************************************************/
  public int getCharY() {
    return guyY; // return guy y location
  }
}