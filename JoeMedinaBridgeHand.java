import java.util.Random;

public class JoeMedinaBridgeHand{

  public final int CARDS_PER_HAND = 13;
  public final int CARDS_PER_SUIT = 13;
  public final int CARDS_PER_DECK = 52;
  private int [] cards = {1,2,3,4,5,6,7,8,47,10,11,45,50};; // has size CARDS_PER_HAND 
 
  /*
   * Default constructor
   * Fills the array cards with random, non-duplicate cards
   */   
  public JoeMedinaBridgeHand( ){
  
    // randomly generate a hand
    Random random = new Random( );
    cards = new int[CARDS_PER_HAND]; // all 0s (aces of spade) at this point
    for( int i = 0; i < CARDS_PER_HAND; i++ )
      cards[i] = -1;
    
    int number = -1;
    // generate the hand
    for( int i = 0; i < CARDS_PER_HAND; i++ )
    {
      // draw a new card
      number = random.nextInt( CARDS_PER_DECK );
      
      while( isDuplicate( number ) ) // duplicate, keep drawing
        number = random.nextInt( CARDS_PER_DECK );
      // non-duplicate card, add to hand
      cards[i] = number;  
    }
    
    sort(cards);
  }
 
  
  /*
   * isDuplicate method
   * @param number an int, represents a card, an int between 0 and CARDS_PER_DECK - 1
   * @return a boolean, true if number is already present in the array cards, false otherwise
   */
  private boolean isDuplicate( int number ){
    
      for( int i = 0; i < cards.length; i++ )
      {
        if( cards[i] == number )
          return true;
      }
      return false;
  }
  
  /*
   * highCardPoints method
   * @return an int, the sum of all high card points in cards
   * ace = 4, king = 3, queen = 2, jack = 1, all other cards are worth 0
   */
  public int highCardPoints( ){
  
    int points = 0;
    for( int i = 0; i < cards.length; i++ ){
    
      if( cards[i] % CARDS_PER_SUIT < 4 ) // Ace, King, Queen, or Jack
      points += ( 4 - cards[i] % CARDS_PER_SUIT ) ;
    }
    return points;
  }
  
  /*
   * sorts the elements of arr in ascending order
   * @param an array of ints
   */
   public static void sort(int[] arr) {
       for (int i = 0; i < arr.length; i++) {
           int min = arr[i];
           int minId = i;
           for (int j = i+1; j < arr.length; j++) {
               if (arr[j] < min) {
                   min = arr[j];
                   minId = j;
               }
           }
           // swapping
           int temp = arr[i];
           arr[i] = min;
           arr[minId] = temp;
       }
   }
   
   /*
   * outputArray method
   * @param arr an int array, the cards in hand
   * outputs the array to the user
   */
   public static void outputArray(int [] arr){
      
      for(int i = 0; i < arr.length; i++){
         
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }
   
   /*
   * spades method
   * @return an int array, all cards in cards that are of the spades suit
   */
   public int [] spades(){
    
      int [] spadesInHand;
      int count = 0;
      for(int i = 0; i < cards.length -1; i++){
         if(cards[i] >= 0 && cards[i] <= 12){
            count++;
         }
      }
      spadesInHand = new int[count];
      int k = 0;
      for(int j = 0; j < cards.length && k < count ; j++){
         if(cards[j] >= 0 && cards[j] <= 12){
               spadesInHand[k] = cards[j];
               k++;
         }
      }
      return spadesInHand;
   }
   
   /*
   * spades method
   * @return an int array, all cards in cards that are of the hearts suit
   */
   public int [] hearts(){
   
      int [] heartsInHand;
      int count = 0;
      for(int i = 0; i < cards.length-1; i++){
         if(cards[i] > 12 && cards[i] <= 25){
            count++;
         }
      }
      heartsInHand = new int[count];
      int k = 0;
      for(int j = 0; j < cards.length && k < count ; j++){
         if(cards[j] > 12 && cards[j] <= 25){
               heartsInHand[k] = cards[j];
               k++;
         }
      }
      return heartsInHand;
   }
   
   /*
   * spades method
   * @return an int array, all cards in cards that are of the diamonds suit
   */
   public int [] diamonds(){
   
      int [] diamondsInHand;
      int count = 0;
      for(int i = 0; i < cards.length-1; i++){
         if(cards[i] > 25 && cards[i] <= 38){
            count++;
         }
      }
      diamondsInHand = new int[count];
      int k = 0;
      for(int j = 0; j < cards.length && k < count ; j++){
         if(cards[j] > 25 && cards[j] <= 38){
               diamondsInHand[k] = cards[j];
               k++;
         }
      }
      return diamondsInHand;
   }
   
   /*
   * spades method
   * @return an int array, all cards in cards that are of the clubs suit
   */
   public int [] clubs(){
   
      int [] clubsInHand;
      int count = 0;
      for(int i = 0; i < cards.length; i++){
         if(cards[i] > 38 && cards[i] <= 51){
            count++;
         }
      }
      
      clubsInHand = new int[count];
      int k = 0;
      for(int j = 0; j < cards.length && k < count ; j++){
         if(cards[j] > 38 && cards[j] <= 51){
               clubsInHand[k] = cards[j];
               k++;
         }
      }
      return clubsInHand;
   }
   
   /*
   * value method
   * @param an int, a specific card
   * @return an int, the value of that card
   * ace = 4, king = 3, queen = 2, jack = 1, all other cards are worth 0
   */
   public int value(int v){
    
         if( v % CARDS_PER_SUIT < 4 ) // Ace, King, Queen, or Jack
            return ( 4 - v % CARDS_PER_SUIT );
         else
            return 0;
   }
   
   /*
   * shape method
   * @param arr an int array
   * @return an int array, the number of each suit in hand
   */
   public int [] shape(int [] arr){
      int [] suitInHand = new int[4];
      suitInHand[0] = spades().length;
      suitInHand[1] = hearts().length;
      suitInHand[3] = diamonds().length;
      suitInHand[2] = clubs().length;
      
      return suitInHand;

   }
   
   /*
   * sumOfLengthsOfTwoLongestSuits method
   * @return an int, the sum of the two highest cards in cards
   */
   public int sumOfLengthsOfTwoLongestSuits(){
      
      int [] suitInHand = shape(cards);
      int maxVal = 0;
      int lessMaxVal = 1;
      for(int i = 0; i < suitInHand.length; i++){
         if(suitInHand[i] > suitInHand[maxVal])
            maxVal = i;
      }
      for(int i = 0; i < suitInHand.length; i++){
         if(suitInHand[i] > suitInHand[maxVal] && suitInHand[i] > suitInHand[lessMaxVal])
            lessMaxVal = i;
      }
      
      return maxVal + lessMaxVal;
   }
   
   /*
   * ruleOf20 method
   * @return an int, the sum of the two highest cards in cards and the high card points
   */
   public int ruleOf20(){
   
      return highCardPoints() + sumOfLengthsOfTwoLongestSuits();
   }
   
   /*
   * hasRegularOpening method
   * @return a boolean, true if ruleOf20 method is greater than or equal to 20, false otherwise
   */
   public boolean hasRegularOpening(){
      int num = ruleOf20();
      if( num >= 20)
         return true;
      else
         return false;  
   }
   
   /*
   * hasRegularOpening method
   * @return a String, 
   *     "BALANCED" if no void suits, no singleton suits, and at most one doubleton suit, "UNBALANCED" otherwise
   */
   public String typeOfHand(){
      int [] suitsInHand = shape(cards);
      int count = 0;
      for(int i = 0; i < suitsInHand.length; i++){
         
         if(suitsInHand[i] == 0 || suitsInHand[i] == 1)
            return "UNBALANCED";
         else if(suitsInHand[i] == 2)
            count++;
         else if(count >= 2)
            return "UNBALANCED";
      }
      return "BALANCED";   
   }
   
   /*
   * hasRegularOpening method
   * @return a boolean, 
   *     true if 
   *            the hand has 7 cards of a suit
   *            between 6 and 10 high card points
   *            has at least 2 honors in that 7 card suit, false otherwise
   */
   public boolean weak3(){
      
      int [] suitsInHand = shape(cards);
      int count = 0;
      int numHonors = 0;
      int suit = 0;
      for(int i = 0; i < suitsInHand.length; i++){
         
         if((suitsInHand[i] == 7) && (highCardPoints() >= 6 && highCardPoints() <= 10)){
            suit = i;
            if(suit == 0){
               int [] spades = spades();
               for( int j = 0; j < spades.length; j++ ){
    
                  if( spades[j] % CARDS_PER_SUIT < 4 ) // Ace, King, Queen, or Jack
                  numHonors++;
               }
            }
            else if(suit == 1){
               int [] hearts = hearts();
               for( int j = 0; j < hearts.length; j++ ){
    
                  if( hearts[j] % CARDS_PER_SUIT < 4 ) // Ace, King, Queen, or Jack
                  numHonors++;
               }
            }
            else if(suit == 2){
               int [] diamonds = diamonds();
               for( int j = 0; j < diamonds.length; j++ ){
    
                  if( diamonds[j] % CARDS_PER_SUIT < 4 ) // Ace, King, Queen, or Jack
                  numHonors++;
               }
            }
            if(suit == 3){
            int [] clubs = clubs();
               for( int j = 0; j < clubs.length; j++ ){
    
                  if( clubs[j] % CARDS_PER_SUIT < 4 ) // Ace, King, Queen, or Jack
                  numHonors++;
               }
            }   
         }
            
      }
      if(numHonors >= 2)
         return true;
      else
         return false;
   }
   
   /*
   * hasRegularOpening method
   * @return a boolean, 
   *     true if 
   *            the hand has 8 cards of a suit
   *            between 6 and 10 high card points
   *            has at least 2 honors in that 8 card suit, false otherwise
   */
   public boolean weak4(){
      int [] suitsInHand = shape(cards);
      int count = 0;
      int numHonors = 0;
      int suit = 0;
      for(int i = 0; i < suitsInHand.length; i++){
         
         if((suitsInHand[i] == 8) && (highCardPoints() >= 6 && highCardPoints() <= 10)){
            suit = i;
            if(suit == 0){
               int [] spades = spades();
               for( int j = 0; j < spades.length; j++ ){
    
                  if( spades[j] % CARDS_PER_SUIT < 4 ) // Ace, King, Queen, or Jack
                  numHonors++;
               }
            }
            else if(suit == 1){
               int [] hearts = hearts();
               for( int j = 0; j < hearts.length; j++ ){
    
                  if( hearts[j] % CARDS_PER_SUIT < 4 ) // Ace, King, Queen, or Jack
                  numHonors++;
               }
            }
            else if(suit == 2){
               int [] diamonds = diamonds();
               for( int j = 0; j < diamonds.length; j++ ){
    
                  if( diamonds[j] % CARDS_PER_SUIT < 4 ) // Ace, King, Queen, or Jack
                  numHonors++;
               }
            }
            if(suit == 3){
            int [] clubs = clubs();
               for( int j = 0; j < clubs.length; j++ ){
    
                  if( clubs[j] % CARDS_PER_SUIT < 4 ) // Ace, King, Queen, or Jack
                  numHonors++;
               }
            }
         }
      }
      
      if(numHonors >= 2)
         return true;
      else
         return false;
   }
   
   /*
   * has1NoTrump method
   * @return a boolean, true if hasRegularOpening is "BALANCED" and highCardPoints method is between 15 and 17, false otherwise
   */
   public boolean has1NoTrump(){
      int points = highCardPoints();
      String bal = typeOfHand();
      boolean pnts = false;
      if(points >= 15 && points <= 17)
         pnts = true;
      if( pnts && bal.equals("BALANCED"))
         return true;
      else
         return false;
   }
   
   /*
   * has2NoTrump method
   * @return a boolean, true if hasRegularOpening is "BALANCED" and highCardPoints method is between 20 and 21, false otherwise
   */
   public boolean has2NoTrump(){
      int points = highCardPoints();
      String bal = typeOfHand();
      boolean pnts = false;
      if(points == 20 || points == 21)
         pnts = true;
      if( pnts && bal.equals("BALANCED"))
         return true;
      else
         return false;
   }
   
   /*
   * weHaveGame method
   * @param an int, a specific card
   * @return a boolean, true if highCardPoints method plus int v is greater tha or equal to 25, false otherwise
   */
   public boolean weHaveGame(int v){
      int points = highCardPoints();
      int sum = points + v;
      if(sum >= 25)
         return true;
      else
         return false;
   }
   
   /*
   * weHaveGame method
   * @param an object, a seperate hand of cards
   * @return a boolean, true if the sum of highCardPoints method of both hands is greater than or equal to 33, false otherwise
   */
   public boolean weHaveSlam(Object o){
      
      int points = 0;
      if(o instanceof JoeMedinaBridgeHand){
         JoeMedinaBridgeHand objBridgeHand = (JoeMedinaBridgeHand) o;
         points += (highCardPoints() + objBridgeHand.highCardPoints());
         if(points >= 33)
            return true;
         
      }
      return false;
   }
   
   /*
   * weHaveAFit method
   * @param an object and char, a seperate hand of cards and a char representing suit
   * @return a boolean, true if the sum cards of that suit in both hands is greater than or equal to 8, false otherwise
   */
   public boolean weHaveAFit(Object o, char suit){
      
      int num = 0;
      if(o instanceof JoeMedinaBridgeHand){
         JoeMedinaBridgeHand objBridgeHand = (JoeMedinaBridgeHand) o;
         
         if(suit == 'S'){
            int [] spades = spades();
            int [] objSpades = objBridgeHand.spades();
            if((spades.length + objSpades.length) >= 8)
               return true; 
         }
            
         else if(suit == 'H'){
            int [] hearts = hearts();
            int [] objHearts = objBridgeHand.hearts();
            if((hearts.length + objHearts.length) >= 8)
               return true;
         }
         else if(suit == 'D'){
            int [] diamonds = diamonds();
            int [] objDiamonds = objBridgeHand.diamonds();
            if((diamonds.length + objDiamonds.length) >= 8)
               return true;
         }
         else if(suit == 'C'){
            int [] clubs = clubs();
            int [] objClubs = objBridgeHand.clubs();
            if((clubs.length + objClubs.length) >= 8)
               return true;
         }
      }
      return false;
   }
   
   /*
   * weHaveGame method
   * @param a char, a suit
   * @return an int, number of key card in hand of that suit
   */
   public int romanKeyCard(char suit){
      
      int count = 0;
      for(int i = 0; i < CARDS_PER_HAND; i++){
         if(cards[i] == 0 || cards[i] == 13 || cards[i] == 26 || cards[i] == 39)
            count++;
      }
      
      if(suit == 'S'){
         int [] spades = spades();
         for(int j = 0; j < spades.length; j++){
            if(spades[j] == 1)
               count++;
         }
      }      
      else if(suit == 'H'){
         int [] hearts = hearts();
            for(int j = 0; j < hearts.length; j++){
               if(hearts[j] == 14)
                  count++;
            }
         }
      else if(suit == 'D'){
         int [] diamonds = diamonds();
         for(int j = 0; j < diamonds.length; j++){
            if(diamonds[j] == 27)
               count++;
            }
         }
      else if(suit == 'C'){
         int [] clubs = clubs();
         for(int j = 0; j < clubs.length; j++){
            if(clubs[j] == 40)
               count++;
         }
      }
      return count;
   }
   
   /*
   * has2Clubs method
   * @return a boolean, true if highCardPoints method is greater than or equal to 22, false otherwise
   */
   public boolean has2Clubs(){
      int points = highCardPoints();
      if(points >= 22)
         return true;
      else
         return false;       
   }
   
   /*
   * hasMichaels method
   * @param a char, a suit
   * @return a boolean, true if this hand contains two suits different from the char perameter of atleast 5 cards each, false otherwise
   */
   public boolean hasMichaels(char suit){
      
      int [] spades = copyArray(spades());
      int [] hearts = copyArray(hearts());
      int [] diamonds = copyArray(diamonds());
      int [] clubs = copyArray(clubs());
      int count = 0;
      if(suit == 'S'){
         if(hearts.length >= 5)
            count++;
         if(diamonds.length >= 5)
            count++;
         if(clubs.length >= 5)
            count++;
      }
      else if(suit == 'H'){
         if(spades.length >= 5)
            count++;
         if(diamonds.length >= 5)
            count++;
         if(clubs.length >= 5)
            count++;
      }
      else if(suit == 'D'){
         if(hearts.length >= 5)
            count++;
         if(spades.length >= 5)
            count++;
         if(clubs.length >= 5)
            count++;
      }
      else if(suit == 'C'){
         if(hearts.length >= 5)
            count++;
         if(diamonds.length >= 5)
            count++;
         if(spades.length >= 5)
            count++;
      }      
     
      if(count >= 2)
         return true;
      else 
         return false;           
   }
   
   /*
   * toString method
   * @return a String, outputs the hand to the uer seperated by suit and in order from greatest to least
   */
   public String toString(){
      int [] spades = copyArray(spades());
      int [] hearts = copyArray(hearts());
      int [] diamonds = copyArray(diamonds());
      int [] clubs = copyArray(clubs());
      String outSpades = "";
      String outHearts = "";
      String outDiamonds = "";
      String outClubs = "";
      for( int i = 0; i < spades.length; i++){
         if (spades[i] == 0){
            outSpades += "A ";
         }
         else if (spades[i] == 1){
            outSpades += "K ";
         }
         else if (spades[i] == 2){
            outSpades += "Q ";
         }
         else if (spades[i] == 3){
            outSpades += "J ";
         }
         else if (spades[i] == 4){
            outSpades += "T ";
         }
         else if (spades[i] == 5){
            outSpades += "9 ";
         }
         else if (spades[i] == 6){
            outSpades += "8 ";
         }
         else if (spades[i] == 7){
            outSpades += "7 ";
         }
         else if (spades[i] == 8){
            outSpades += "6 ";
         }
         else if (spades[i] == 9){
            outSpades += "5 ";
         }
         else if (spades[i] == 10){
            outSpades += "4 ";
         }
         else if (spades[i] == 11){
            outSpades += "3 ";
         }
         else if (spades[i] == 12){
            outSpades += "2 ";
         }
      }
      for (int i = 0; i < hearts.length; i++){
         if (hearts[i] - 13 == 0){
            outHearts += "A ";
         }
         else if (hearts[i] - 13 == 1){
            outHearts += "K ";
         }
         else if (hearts[i] - 13 == 2){
            outHearts += "Q ";
         }
         else if (hearts[i] - 13 == 3){
            outHearts += "J ";
         }
         else if (hearts[i] - 13 == 4){
            outHearts += "T ";
         }
         else if (hearts[i] - 13 == 5){
            outHearts += "9 ";
         }
         else if (hearts[i] - 13 == 6){
            outHearts += "8 ";
         }
         else if (hearts[i] - 13 == 7){
            outHearts += "7 ";
         }
         else if (hearts[i] - 13 == 8){
            outHearts += "6 ";
         }
         else if (hearts[i] - 13 == 9){
            outHearts += "5 ";
         }
         else if (hearts[i] - 13 == 10){
            outHearts += "4 ";
         }
         else if (hearts[i] - 13 == 11){
            outHearts += "3 ";
         }
         else if (hearts[i] - 13 == 12){
            outHearts += "2 ";
         }
      }
      for (int i = 0; i < diamonds.length; i++){
         if (diamonds[i] - 26 == 0){
            outDiamonds += "A ";
         }
         else if (diamonds[i] - 26 == 1){
            outDiamonds += "K ";
         }
         else if (diamonds[i] - 26 == 2){
            outDiamonds += "Q ";
         }
         else if (diamonds[i] - 26 == 3){
            outDiamonds += "J ";
         }
         else if (diamonds[i] - 26 == 4){
            outDiamonds += "T";
         }
         else if (diamonds[i] - 26 == 5){
            outDiamonds += "9 ";
         }
         else if (diamonds[i] - 26 == 6){
            outDiamonds += "8 ";
         }
         else if (diamonds[i] - 26 == 7){
            outDiamonds += "7 ";
         }
         else if (diamonds[i] - 26 == 8){
            outDiamonds += "6 ";
         }
         else if (diamonds[i] - 26 == 9){
            outDiamonds += "5 ";
         }
         else if (diamonds[i] - 26 == 10){
            outDiamonds += "4 ";
         }
         else if (diamonds[i] - 26 == 11){
            outDiamonds += "3 ";
         }
         else if (diamonds[i] - 26 == 12){
            outDiamonds += "2 ";
         }
      }
      for (int i = 0; i < clubs.length; i++){
         if (clubs[i] - 39 == 0){
            outClubs += "A ";
         }
         else if (clubs[i] - 39 == 1){
            outClubs += "K ";
         }
         else if (clubs[i]  - 39 == 2){
            outClubs += "Q ";
         }
         else if (clubs[i]  - 39 == 3){
            outClubs += "J ";
         }
         else if (clubs[i]  - 39 == 4){
            outClubs += "T ";
         }
         else if (clubs[i] - 39 == 5){
            outClubs += "9 ";
         }
         else if (clubs[i] - 39 == 6){
            outClubs += "8 ";
         }
         else if (clubs[i] - 39 == 7){
            outClubs += "7 ";
         }
         else if (clubs[i] - 39 == 8){
            outClubs += "6 ";
         }
         else if (clubs[i] - 39 == 9){
            outClubs += "5 ";
         }
         else if (clubs[i] - 39 == 10){
            outClubs += "4 ";
         }
         else if (clubs[i] - 39 == 11){
            outClubs += "3 ";
         }
         else if (clubs[i] - 39 == 12){
            outClubs += "2 ";
         }
      }

      
      String returnStatement = "S: " + outSpades + "\nH: " + outHearts + "\nD: " + outDiamonds + "\nC: " + outClubs;
      return returnStatement;
   }
   
   /*
   * copyArray method
   * @param arr, an int array, the cards in hand
   * copies the param array
   * @return int array, copied array
   */
   public int [] copyArray(int [] arr){
      int [] copiedArray = new int[arr.length];
      for(int i = 0; i <arr.length; i++)
         copiedArray[i] = arr[i];
      return copiedArray;
   }
   
}