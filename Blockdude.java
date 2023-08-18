/******************************************************* 
  * Blockdude.java
  * 
  * the classic TI 84 game recreated using Java
  * Utilizes 2d arrays. NOTE: PLEASE MAKE SURE YOU SAVE
  * THE IMAGES PROPERLY, OTHERWISE IT WONT WORK
  * *************************************************/

import java.awt.*; // graphics
import java.awt.event.*; // actions
import javax.swing.*; // panels

public class Blockdude extends JPanel implements KeyListener{
  
  static int level1[][] = // 6 x 20
  { { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
    { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1 },
    { 1, 4, 0, 0, 1, 0, 0, 0, 1, 0, 2, 0, 1, 0, 2, 0, 0, 3, 0, 1 },
    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, };
  
  static int level2[][] = // 10 x 22
  { { 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
    { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
    { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
    { 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
    { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
    { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 1 },
    { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 2, 2, 0, 3, 0, 1 },
    { 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
    { 0, 0, 0, 0, 0, 1, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
  
  // 10 x 19
  static int level3[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1 },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 1 },
    { 1, 0, 1, 1, 1, 0, 0, 0, 0, 3, 0, 0, 0, 1, 2, 0, 1, 1, 0 },
    { 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0 },
    { 1, 0, 1, 0, 1, 2, 2, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
    { 1, 4, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
    { 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 }, };
  
  // 12 x 24
  static int level4[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
    { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
    { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
    { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1 },
    { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 1 },
    { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 1, 1, 1 },
    { 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
    { 1, 4, 0, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 },
    { 1, 1, 1, 1, 1, 0, 1, 0, 2, 0, 0, 0, 2, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 1, 0, 1, 0, 2, 0, 1, 0, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
  
  
  static int level5[][] = // 9 x 21
  {{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 4, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 2, 1},
    {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 2, 2, 1},
    {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 2, 2, 2, 1},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
  
  
  static int level6[][] = // 13 x 21
  { { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
    { 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1 },
    { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
    { 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
    { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
    { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 1, },
    { 0, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 1, 1, 1, },
    { 0, 1, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 1, 3, 2, 2, 2, 0, 1, 0, 0, },
    { 0, 1, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, },
    { 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, },
    { 0, 0, 0, 0, 0, 1, 0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, } };
  
  
  static int level7[][] = // 12 x 24
  {{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
    {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
    {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 1},
    {1, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
    {1, 1, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0},
    {0, 1, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 1, 1, 0, 2, 0, 3, 1, 1, 1, 1, 0, 0},
    {0, 1, 1, 0, 0, 1, 0, 2, 2, 2, 0, 0, 1, 1, 0, 2, 2, 2, 1, 0, 0, 0, 0, 0},
    {0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
    {0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0} };
  
  
  static int level8[][] =  // 17  x 27
  {{0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
    {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
    {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 2, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1},
    {1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1},
    {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4, 0, 1},
    {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1},
    {0, 0, 1, 0, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
    {0, 0, 1, 0, 0, 0, 0, 2, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
    {0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
    {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 2, 2, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
    {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 3, 0, 0, 2, 2, 2, 1},
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
  
  private int[][] map; // map to be used in program
  private int lvlNum; // you created it here
  private int guyX, guyY, rows, columns, rockX, rockY, direction; // bunch of int variables to be used
  boolean openLeft, openRight, openUp, openDown, inGame, blockOnTop; // booleans for direction and rocks
  private Image block, duderino, dudeL, rock, door; // images to be used
  
  JFrame frame = new JFrame(); // frame with stuff on it (empty atm)
  
  
  /******************************************************* 
    * public Blockdude(int lvlNumz)
    * 
    * The constructor. Here we decide on which level to 
    * use, the starting location of the character, and
    * we add key listeners to the panel
    * *************************************************/
  
  public Blockdude(int lvlNumz){ 
    super(); // call the constructor of parent
    addKeyListener(this); // add key listener to the panel
    
    if (lvlNumz == 1) // if parameter is 1
    {
      map = level1; // make map equal level1
      rows = 6; // num of rows
      columns = 20; // num of columns 
      lvlNum = lvlNumz; // store num of level 
      
      Coordinatefinder coordinate = new Coordinatefinder(level1, 6, 20);
      guyX = coordinate.getCharX(); // get the x coordinate of character
      guyY = coordinate.getCharY(); // get the y coordinate of character
    }
    
    else if(lvlNumz == 2) // if paramter is 2
    {
      map = level2;  // use lvl2 map
      rows = 10; // num of rows
      columns = 22; // num of columns
      lvlNum = lvlNumz; // the level number for later
      
      Coordinatefinder coordinate = new Coordinatefinder(level2, 10, 22);
      guyX = coordinate.getCharX(); // get the x coordinate of character
      guyY = coordinate.getCharY(); // get the y coordinate of character
    }
    
    else if(lvlNumz == 3) // if parameter is 3
    {
      map = level3;  // use level 3 map
      rows = 10; // num rows
      columns = 19; // num columns
      lvlNum = lvlNumz;
      
      Coordinatefinder coordinate = new Coordinatefinder(level3, 10, 19);
      guyX = coordinate.getCharX(); // get the x coordinate of character
      guyY = coordinate.getCharY(); // get the y coordinate of character
    }
    
    else if(lvlNumz == 4) // if paramter is 4
    {
      map = level4;  // use level 4 map
      rows = 12; // rows num
      columns = 24; // col num
      lvlNum = lvlNumz;
      
      Coordinatefinder coordinate = new Coordinatefinder(level4, 12, 24);
      guyX = coordinate.getCharX(); // get the x coordinate of character
      guyY = coordinate.getCharY(); // get the y coordinate of character
    }
    
    else if(lvlNumz == 5) // if paramter is 5
    {
      map = level5;  // use level 5 map
      rows = 9; // rows num
      columns = 21; // col num
      lvlNum = lvlNumz;
      
      Coordinatefinder coordinate = new Coordinatefinder(level5, 9, 21);
      guyX = coordinate.getCharX(); // get the x coordinate of character
      guyY = coordinate.getCharY(); // get the y coordinate of character
    }
    
    else if(lvlNumz == 6) // if paramter is 6
    {
      map = level6;  // use level 6 map
      rows = 13; // rows num
      columns = 21; // col num
      lvlNum = lvlNumz;
      
      Coordinatefinder coordinate = new Coordinatefinder(level6, 13, 21);
      guyX = coordinate.getCharX(); // get the x coordinate of character
      guyY = coordinate.getCharY(); // get the y coordinate of character
    }
    
    else if(lvlNumz == 7) // if paramter is 7
    {
      map = level7;  // use level 7 map
      rows = 12; // rows num
      columns = 24; // col num
      lvlNum = lvlNumz;
      
      Coordinatefinder coordinate = new Coordinatefinder(level7, 12, 24);
      guyX = coordinate.getCharX(); // get the x coordinate of character
      guyY = coordinate.getCharY(); // get the y coordinate of character
    }
    
    else if(lvlNumz == 8) // if paramter is 8
    {
      map = level8;  // use level 4 map
      rows = 17; // rows num
      columns = 27; // col num
      lvlNum = lvlNumz;
      
      Coordinatefinder coordinate = new Coordinatefinder(level8, 17, 27);
      guyX = coordinate.getCharX(); // get the x coordinate of character
      guyY = coordinate.getCharY(); // get the y coordinate of character
    }
    setBackground(Color.WHITE); // make background white
    setFocusable(true); // allow the keys to do stuff to panel
    direction = 10; // face left
    
    loadImages(); // import images
  }
  
  
  /******************************************************* 
    * public void createGame()
    * 
    * based on the level, this method chooses which object
    * to create, and which object to put into the frame
    * *************************************************/
  
  public void createGame(){
    if(lvlNum == 1) // if lvl is 1
    {
      Blockdude panelTest = new Blockdude(lvlNum); // create object
      frame.setSize(1000, 600); // set size of frame
      frame.repaint(); // repaint it
      frame.setContentPane(panelTest); // add object to panel
      frame.setVisible(true); // let is show
    }
    else if(lvlNum == 2) // if 2nd level
    { 
      Blockdude dude = new Blockdude(lvlNum); // new object
      frame.setSize(1000,600); // same dimension
      frame.setContentPane(dude); // add object to panel
      frame.setVisible(true); // set it visible
    }
    
    else if(lvlNum == 3) // if third level
    {
      Blockdude three = new Blockdude(lvlNum); // level 3 object
      frame.setSize(1000,600); // size
      frame.setContentPane(three); // add it to frame
      frame.setVisible(true); // let is show (go)
    }
    
    else if(lvlNum == 4) // if fourth level
    {
      Blockdude four = new Blockdude(lvlNum); // level 4 object
      frame.setSize(1000, 600); // set size of frame
      frame.setContentPane(four); // add panel object to the frame
      frame.setVisible(true); // let it show
    }
    
    else if(lvlNum == 5) // if fourth level
    {
      Blockdude five = new Blockdude(lvlNum); // level 4 object
      frame.setSize(1000, 600); // set size of frame
      frame.setContentPane(five); // add panel object to the frame
      frame.setVisible(true); // let it show
    }
    
    else if(lvlNum == 6) // if fourth level
    {
      Blockdude six = new Blockdude(lvlNum); // level 4 object
      frame.setSize(1000, 600); // set size of frame
      frame.setContentPane(six); // add panel object to the frame
      frame.setVisible(true); // let it show
    }
    
    else if(lvlNum == 7) // if fourth level
    {
      Blockdude seven = new Blockdude(lvlNum); // level 4 object
      frame.setSize(1000, 600); // set size of frame
      frame.setContentPane(seven); // add panel object to the frame
      frame.setVisible(true); // let it show
    }
    
    else if(lvlNum == 8) // if fourth level
    {
      Blockdude eight = new Blockdude(lvlNum); // level 4 object
      frame.setSize(1000, 600); // set size of frame
      frame.setContentPane(eight); // add panel object to the frame
      frame.setVisible(true); // let it show
    }
  }
  
  
  /*******************************************************
    * public int getLvlNum()
    * 
    * returns the current level
    * *************************************************/
  
  public int getLvlNum(){
    return lvlNum; // return the current level number
  }
  
  public void watLevel(){ 
    ExitAction action = new ExitAction(); // the god. closes the frame
    action.actionPerformed(null);
    createGame(); // need to make a game when you delete a frame... no?
  }
  
  /*******************************************************
    * public void loadImages()
    * 
    * get the images from the same folder as these files
    * Save the images to variables to use later
    * *************************************************/
  public void loadImages(){
    
    // get block image
    ImageIcon iid = new ImageIcon("block.png"); 
    block = iid.getImage();
    
    // get dude facing right image
    ImageIcon iia = new ImageIcon("duderino.jpg");
    duderino = iia.getImage();
    
    // get dude facing left image
    ImageIcon iib = new ImageIcon("dudeL.jpg");
    dudeL = iib.getImage();
    
    // get rock image (NOT A GIF)
    ImageIcon iih = new ImageIcon("rock.gif");
    rock = iih.getImage();
    
    // get door image
    ImageIcon iii = new ImageIcon("door.png");
    door = iii.getImage();
  }
  
  
  /******************************************************* \
    * public void paintComponent (Graphics g)
    * 
    * do the painting stuff
    * *************************************************/
  public void paintComponent(Graphics g){
    super.paintComponent(g); // paint the stuff
    doDrawing(g); // do the drawing (method below)
  }
  
  
  /******************************************************* 
    * private void doDrawing(Graphics g)
    * 
    * what needs to be drawn and where it needs to be drawn
    * can all be found here. it is based off of the 2d array
    * layout of the map, and uses the icons from above
    * *************************************************/
  private void doDrawing(Graphics g){
    // 2 variables for resizing our stuff
    int ab = 0;
    int bc = 0;
    
    for (int r = 0; r < rows; r++){ // for the rows
      for (int c = 0; c < columns; c++){ // for the columns
        // multiply the coordinates of the image placement by 32 since each image is 32 pixels
        ab = 32 * (r + 1); 
        bc = 32 * (c + 1);
        
        if (map[r][c] == 1){ // if current location is a 1
          g.drawImage(block, bc, ab, this); // put a block (wall)
        }
        else if (map[r][c] == 2){ // if its a 2
          g.drawImage(rock, bc, ab, this); // put a rock (pickable stuff)
        }
        else if (map[r][c] == 3){ // if its a 3
          if (direction == 10){ // if facing left
            g.drawImage(dudeL, bc, ab, this); // use the dude left image
          }
          else // otherwise
            g.drawImage(duderino, bc, ab, this); // use the duderino pasterino me gustarino pls no gankerino image
        }
        else if (map[r][c] == 4){ // if 4 (door) hehe
          g.drawImage(door, bc, ab, this); // draw the door
        }
      }
    }
    
    Toolkit.getDefaultToolkit().sync(); // do some syncing stuff
    g.dispose();
  }
  
  /*************************************************************
    * public void move()
    * 
    * the core of the program. this method uses booleans to see
    * which action should occur, and the booleans are set by the 
    * actionlisteners below. Also, the complicated series of 
    * if statemtents decides what do do and what not to do
    * *********************************************************/
  public void move(){ 
    if (openLeft == true){ // if the left key is pressed 
      
      if (map[guyX][guyY - 1] == 0){ // if the position to the left is an open space 
        
        map[guyX][guyY] = 0; // set the current location to be an open space 
        map[guyX][guyY - 1] = 3; // set the space to the left to be the player 
        
        if (blockOnTop == true){ // if theres a rock on top of the character's head 
          
          map[guyX - 1][guyY] = 0; // change the old rock location to be 0 
          map[guyX - 1][guyY - 1] = 2; // move the new rock to be on top of the character's current location 
        } 
        
        guyY = guyY - 1; // update the guyY coordinate accordingly 
        
        while (map[guyX + 1][guyY] == 0){ // whle there is empty space below the guy 
          
          map[guyX + 1][guyY] = 3; // move the guy down one space 
          map[guyX][guyY] = 0; // make the guy's old position to be blank 
          
          if (blockOnTop == true){ // if theres a rock on top of the character's head 
            
            map[guyX - 1][guyY] = 0; // change the old rock location to be 0 
            map[guyX][guyY] = 2; // move the new rock to be on top of the character's current location 
          } 
          
          guyX = guyX + 1; // update the new x coordinate for the guy 
        } 
        if (map[guyX + 1][guyY] == 4){ 
          lvlNum++; 
          watLevel();
        } 
      } 
      
      else if (map[guyX][guyY - 1] == 4){ 
        lvlNum++;
        watLevel();
      } 
    } 
    
    if (openRight == true){ // if the right key is pressed 
      
      if (map[guyX][guyY + 1] == 0){ // if the location to the right is 0 (air) 
        
        map[guyX][guyY] = 0; // set the current location to be air 
        map[guyX][guyY + 1] = 3; // set the location to the right to be a 0 
        
        if (blockOnTop == true){ // if theres a rock on top of the character's head 
          
          map[guyX - 1][guyY] = 0; // change the old rock location to be 0 
          map[guyX - 1][guyY + 1] = 2; // move the new rock to be on top of the character's current location 
        } 
        
        guyY = guyY + 1; // update the y location of the guy (moving to the right) 
        
        while (map[guyX + 1][guyY] == 0){ // if the guy ends up going right, and there's space below him that's empty 
          
          map[guyX + 1][guyY] = 3; // move the character down one location 
          map[guyX][guyY] = 0; // set the old location to be 0 
          
          if (blockOnTop == true){ // if theres a rock on top of the character's head 
            
            map[guyX - 1][guyY] = 0; // change the old rock location to be 
            // 0 
            map[guyX][guyY] = 2; // move the new rock to be on top of the character's current location 
          } 
          
          guyX = guyX + 1; // update the x location of the character, since he moved down 
        } 
      } 
      
      else if (map[guyX][guyY + 1] == 4){ 
        lvlNum++;
        watLevel();
      } 
    } 
    
    // THE DOWN BUTTON DOES THE FOLLOWING: 
    if (openDown == true){ // if the down button is pressed 
      // 10 = LEFT 
      // 20 = RIGHT 
      // x = rows 
      // y = columns 
      
      if (direction == 10){ // if the character's direction is 10, in other words, the last directional key was left 
        //THIS IS CODE I CHANGED, SHOULD'VE TESTD IF ROCK WAS ON TOP OF HEAD FIRST, THEN TEST IF THERE IS STUFF LEFT OF HIM DID NOT CHANGE COMMENT ON PURPOSE 
        if (map[guyX - 1][guyY] == 0){ // if the guy has a rock to the left of him (since that is the directon he's facing INCORRECT COMMENT 
          if (map[guyX][guyY - 1] == 2){ // if there's an open space above his head (no rock or platform) INCORRECT COMMENT 
            if (map[guyX - 1][guyY - 1] == 0){ // if the space above the rock is open as well (no platform, etc) 
              map[guyX][guyY - 1] = 0; // set the current location of the rock to be an open space 
              map[guyX - 1][guyY] = 2; // put the rock on top of the character's head 
              blockOnTop = true; // there IS a rock on top of your head 
            } 
          } 
        } else if (map[guyX - 1][guyY] == 2){ // if the space on top of the guy's head has a rock 
          if (map[guyX][guyY - 1] == 0){ // if the space to the left of the guy is air 
            if (map[guyX - 1][guyY - 1] == 0){ // check diagonal space immediately to the left & up tambien          
              rockX = guyX; //set rock coordinates equal to dude 
              rockY = guyY; 
              
              map[guyX - 1][guyY] = 0; //set space above dude to air 
              map[guyX][guyY - 1] = 2; //set space to the left of dude to rock 
              
              while (map[rockX + 1][rockY - 1] == 0){ 
                map[rockX + 1][rockY - 1] = 2; 
                map[rockX][rockY - 1] = 0; 
                rockX += 1; 
              } 
              blockOnTop = false; 
            } 
          } else if (map[guyX][guyY - 1] != 0){ //if left of guy is not air 
            if (map[guyX - 1][guyY - 1] == 0){ //if diagonal left and up of guy is air 
              map[guyX - 1][guyY] = 0; //set space on top of guy to air 
              map[guyX - 1][guyY - 1] = 2; //set space diagonal left and up of guy to rock 
              blockOnTop = false; 
            } 
          } 
        } 
      } 
      
      if (direction == 20){ // if the player last pressed the right key 
        //COMMENTS ARE CORRECT HERE 
        if (map[guyX - 1][guyY] == 0){ // if there is space on top of him 
          if (map[guyX][guyY + 1] == 2){ // if there's a rock to his right 
            if (map[guyX - 1][guyY + 1] == 0){ // if there's a an open space on top of the rock 
              map[guyX][guyY + 1] = 0; // space to right is now 0 
              map[guyX - 1][guyY] = 2; // rock is placed on top of head 
              blockOnTop = true; // let program know there s a rock on top of the guy's head 
            } 
          } 
        }  
        else if (map[guyX - 1][guyY] == 2){ // if the space on top of the character's head is a rock 
          if (map[guyX][guyY + 1] == 0){ // if the space to the right of the character is air 
            if (map[guyX - 1][guyY + 1] == 0){ 
              rockX = guyX; 
              rockY = guyY; 
              
              map[guyX - 1][guyY] = 0; // set the location above the character to be air (0) 
              map[guyX][guyY + 1] = 2; // location to the right of character is now a rock 
              
              while (map[rockX + 1][rockY + 1] == 0){ 
                map[rockX + 1][rockY + 1] = 2; 
                map[rockX][rockY + 1] = 0; 
                rockX += 1; 
              } 
              blockOnTop = false; // let program know that there's no rock on top of the character's head anymore 
            } 
          } 
          //EFFICIENT CODE 
          else if ((map[guyX][guyY + 1] != 0) 
                     && (map[guyX - 1][guyY + 1] == 0)){ //if space right of guy is not air and space diagonal to the right and up is air 
            map[guyX - 1][guyY] = 0; //set space on top of guy to air 
            map[guyX - 1][guyY + 1] = 2; //move rock on top of that wall/rock 
            blockOnTop = false; //boolean update 
          } 
        } 
      } 
    } 
    
    if (openUp == true){ // if the up key is pressed 
      if (direction == 10){ // if facing left 
        if (map[guyX][guyY - 1] != 0){ // if the space to the left is NOT an empty space 
          if (map[guyX - 1][guyY - 1] == 0){ // if the space one unit above and to the left is open 
            map[guyX][guyY] = 0; // set the current location to be 0 (blank) 
            map[guyX - 1][guyY - 1] = 3; // set the new location, which is diagonal, to be the new character location 
            
            if (blockOnTop == true){ // if he happens to have a block on top of his head 
              
              map[guyX - 1][guyY] = 0; // remove the rock 
              map[guyX - 2][guyY - 1] = 2; // move the rock to above the guy's head at the new location 
            } 
            guyX = guyX - 1; //update coordinates 
            guyY = guyY - 1; 
          } 
          
          else if (map[guyX - 1][guyY - 1] == 4){ 
            lvlNum ++;
            watLevel();
          } 
        } 
      } 
      
      else if (direction == 20){ // if facing right 
        
        if (map[guyX][guyY + 1] != 0){ // if the space to the right is not a 0 
          
          if (map[guyX - 1][guyY + 1] == 0){ // if the space diagonal (to the right) is open 
            
            map[guyX][guyY] = 0; // remove the character from the map 
            map[guyX - 1][guyY + 1] = 3; // put the character at the location checked above 
            
            if (blockOnTop == true){ // if theres a block on his head 
              
              map[guyX - 1][guyY] = 0; // remove the rock 
              map[guyX - 2][guyY + 1] = 2; // put block on top of character at new location 
            } 
            guyX = guyX - 1; // update the x coordinate 
            guyY = guyY + 1; // update the y coordinate 
          } 
          
          else if (map[guyX - 1][guyY + 1] == 4){ 
            lvlNum++;
            watLevel();
          } 
        } 
      } 
    } 
    
    repaint(); 
  } 
  
  
  /******************************************************* 
    * public void keyPressed (KeyEvent key)
    * 
    * checks to see which key is pressed, changes some booleans
    * around, and then runs the move method and repaints the frame
    * *************************************************/
  
  public void keyPressed(KeyEvent key){
    if (key.getKeyCode() == KeyEvent.VK_LEFT){ // if left pressed
      openLeft = true; // move left
      openDown = false; // dont pick up stuff
      openRight = false; // dont go right
      openUp = false; // dont go up
      direction = 10; // face left
      move(); // move
    }
    
    if (key.getKeyCode() == KeyEvent.VK_RIGHT){ // if right pressed
      openLeft = false; // dont go left
      openRight = true; // do go right
      openDown = false; // dont pick up stuff
      openUp = false; // dont go up
      direction = 20; // face right
      move(); // move
    }
    
    if (key.getKeyCode() == KeyEvent.VK_UP){ // if up pressed
      openLeft = false; // dont move left
      openRight = false; // dont right
      openDown = false; // dont down
      openUp = true; // pls do go up
      move(); // move
    }
    
    if (key.getKeyCode() == KeyEvent.VK_DOWN){ // if down
      openLeft = false; // no left
      openRight = false; // no right
      openDown = true; // yes down (pick up or put down stuff)
      openUp = false; // dont go up
      move(); // do move pls.
    }
    repaint();// as if we dont repaint enough, do it again
  }
  
  public void keyTyped(KeyEvent key){ // since we use an interface, we need this method (but blank b/c we dont use)
  }
  
  public void keyReleased(KeyEvent e){ // because of interface, we need this, but dont actually use it.
  }
  
  
  /******************************************************* 
    * public void displayDirections
    * 
    * show the directions to the user
    * *************************************************/
  
  public void displayDirections()
  {
    String instructions = ("The instructions are as follows: \n\n" 
                             + "Move left and right using the arrow keys \n\n"
                             + "You CAN move on top of rocks/ platforms as long as the space above the platform is empty \n\n"
                             + "Rocks can be picked up and put down using the down arrow key \n\n"
                             + "There is no restart button since I do not expect you to mess up\n\n"
                             + "Good Luck and Have Fun!!");  
    JOptionPane.showMessageDialog(null, instructions,"Instructions",JOptionPane.INFORMATION_MESSAGE);
  }
  
}