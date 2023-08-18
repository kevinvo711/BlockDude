/******************************************************* 
    * Driver.java
    * Ali Afzal and Kevin Vo 
    * 
    * We did stuff and did other stuff to make this stuff
    * work. In other words, we used 2d arrays, and this is
    * the driver class (for more detail, go to other class)
    * *************************************************/
import javax.swing.*;
public class Driver{
  
  
  /******************************************************* 
    * public static void main(String[] args)
    *  
    * The main method. Quite short since everything happens
    * in the other class
    * *************************************************/
  public static void main(String[] args){
    
    // for macs
    try {  
      UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );  
    } catch (Exception e) {  
      e.printStackTrace();  
    }
    
    Blockdude dude = new Blockdude(1); // make blockdude object
    dude.displayDirections();
    dude.createGame(); // begin the chain reaction 
  }
}