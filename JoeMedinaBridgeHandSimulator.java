/* BridgeHandSimulator class
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class JoeMedinaBridgeHandSimulator
{
  public static void main( String [] args ){
  
    // # of simulation runs
    int RUNS = 100000;
    JoeMedinaBridgeHand bh;
    int count = 0;
    
    int sumOfHighCardPoints = 0;
    int timesRegularOpening = 0;
    int timesNoTrump1 = 0;
    int timesBalanced = 0;
    int timesWeak3 = 0;
    int timesWeak4 = 0;
    int sumOfSumOfLengths = 0;
    String lastHand = "";
    
    while( count < RUNS ){
      // generate a new hand of cards
      bh = new JoeMedinaBridgeHand( );
      // add high card points of new hand to total
      sumOfHighCardPoints += bh.highCardPoints( );
      // if the hasRegularOpening method is true
      if(bh.hasRegularOpening())
         // increase that count by 1
         timesRegularOpening++;
      // if the has1NoTrump method is true
      if(bh.has1NoTrump())
         // increase that count by 1
         timesNoTrump1++;
      // calls the typeOfHand method
      String handType = bh.typeOfHand();
      // if that hand is "BALANCED"
      if(handType.equals("BALANCED"))
         // increase the count by 1
         timesBalanced++;
      // if the weak3 method is true
      if(bh.weak3())
         // increase that count by 1
         timesWeak3++;
      // if the weak4 method is true
      if(bh.weak4())
         // increase that count by 1
         timesWeak4++;
      sumOfSumOfLengths += bh.sumOfLengthsOfTwoLongestSuits();
      count++;
      
      // stores the last hand generated to be output later
      lastHand = bh.toString();
    } 
    
    DecimalFormat percent = new DecimalFormat("0.0#%");
    // expected results: 10 +/- 0.02
    // there are 40 points in the deck of cards
    // a hand has 1/4 of the deck
    // on average, it will have 1/4 of the points, 10 points
    // calculate and output average of high card points
    double averageHighCardPoints = ( double ) sumOfHighCardPoints / RUNS;
    System.out.println( "average high card points = " + averageHighCardPoints );
    
    // calculate and output percent average of hands with a regular opening
    double averageTimesRegularOpening = ( (double) timesRegularOpening / RUNS);
    System.out.println("percent average of hands with a regular opening: " + percent.format(averageTimesRegularOpening));
    
    // calculate and output percent average of hands with a regular opening
    double averageTimesNoTrump1 = ( (double) timesNoTrump1 / RUNS);
    System.out.println("percent average of hands that have a 1 No Trump: " + percent.format(averageTimesNoTrump1));
    
    // calculate and output percent average of Balanced hands
    double averageTimesBalanced = ( (double) timesBalanced / RUNS);
    System.out.println("percent average of Balanced hands: " + percent.format(averageTimesBalanced));
    
    // calculate and output percent average of hands with weak 3 opening
    double averageTimesWeak3 = ( (double) timesWeak3 / RUNS);
    System.out.println("percent average of hands with weak 3 opening: " + percent.format(averageTimesWeak3));
    
    // calculate and output percent average of hands with weak 4 opening
    double averageTimesWeak4 = ( (double) timesWeak4 / RUNS);
    System.out.println("percent average of hands with weak 4 opening: " + percent.format(averageTimesWeak4));
    
    // calculate and output average sum of lengths
    double averageSumOfSumOfLengths = (double) sumOfSumOfLengths / RUNS;
    System.out.println("average sum of lengths = " + averageSumOfSumOfLengths);
    
    // outputs the last hand generated
    System.out.println(lastHand);

    
  }
  
}