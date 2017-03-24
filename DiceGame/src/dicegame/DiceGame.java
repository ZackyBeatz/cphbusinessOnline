/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;
import dicegame.Dice;
import dicegame.Player;
import java.util.Scanner;

/**
 *
 * @author Zack
 */
public class DiceGame {

    /**
     * @param args the command line arguments
     */
    // Start Function
    public static void startGame(){
        
    }
    
    
    // GameStats Function
    public static void gameStats(int turn, double reward, double credit, double averageFaceValue, double averageBet, double averageReward, int won, int lost) {
        System.out.println("");
        System.out.println("GAME STATISTICS");
        System.out.println("Your Game Ended");
        System.out.println("You have used "+turn+" turns");
        System.out.println("You won in total "+reward+" ");
        System.out.println("Your total credit is "+credit+" ");
        System.out.println("The dice average face value "+averageFaceValue+" ");
        System.out.println("Your average bet was "+averageBet+" ");
        System.out.println("Your average reward was "+averageReward+" ");
        System.out.println("You won "+won+" turns");
        System.out.println("You lost "+lost+" turns");    
     }
    
    public static void main(String[] args) {
       
        // declare our variables
        Dice dice = new Dice();
        Player player1 = new Player("Zakaria", 100);
        Scanner scan = new Scanner(System.in);
        String userInput;
        int turn = 0;
        double reward = 0;
        boolean play = true;
        String yn = "yes";
        int userGuess1;
        int dice1 = 0;
        int dice2 = 0;
        int sum = 0;
        int userGuess2;
        int userBet = 0;
        double gameWin = 0;
        double betting = 0.0;
        double averageFaceValue = 0;
        double averageBet = 0;
        double allBets = 0;
        double averageReward;
        double totalReward = 0;
        int diceHits = 0;
        int turnWon = 0;
        int turnLost = 0;

    
            
        
        System.out.println("Welcome to the Dice Game");
        
        while(yn.equalsIgnoreCase("yes"))
        {
            dice1 = dice.roll();
            dice2 = dice.roll();
            sum = dice1 + dice2;
            turn += 1;
            diceHits += sum;
            allBets+= userBet;
            totalReward += gameWin;
            averageFaceValue = diceHits/turn;
            averageBet = allBets / turn;
            averageReward = totalReward/turn;
            
            System.out.println("");
            System.out.println("You Have "+player1.getCredit()+" Credits");
       
            switch(sum) {
                case 2: case 3: case 11: case 12:
                    betting = 1.5;
                    break;
                case 4: case 5: case 9: case 10:
                    betting = 2;
                    break;
                case 6: case 7: case 8:
                    betting = 3;
                    break;
            }
             
            System.out.println("the sum of the dice is: "+ sum);
            //BETTING
            System.out.println("Your current credit is: "+player1.getCredit());
            System.out.println("How much do you wanna bet");
            userBet = scan.nextInt();
            
             
            // 
            while(userBet>player1.getCredit()){
               System.out.println("Your credit is less than your userbet");
               System.out.println("How much do you wanna bet");
               userBet = scan.nextInt();
            } 
            
            
            System.out.println("Guess the number of the first or second dice");
            userGuess1 = scan.nextInt();
            
            userGuess2 = userGuess1 - sum;
            // calculates amount won
            gameWin = userBet * betting; 
            
            // user guess for first dice
            if(userGuess1 == dice1 || userGuess1 == dice2) {
                System.out.println("You are correct !! ");
                player1.setCredit(player1.getCredit()+gameWin-userBet);
                System.out.println("You won: "+gameWin+ " your bet");
                reward += gameWin;
                turnWon += 1;
                // ASK USER IF HE WANNA TRY AGAIN
                
                System.out.println("Do you wanna play again write yes or no");
                scan.nextLine();
                userInput = scan.nextLine();
                yn = userInput.toLowerCase();
                 if(yn.equalsIgnoreCase("no")){
                        gameStats(turn, reward, player1.getCredit(), averageFaceValue, averageBet, averageReward, turnWon, turnLost);
                    }
            } 
            
            else {
                System.out.println("You guessed wrong");
                player1.setCredit(player1.getCredit()-userBet);
                System.out.println("Your remaining credit: "+player1.getCredit());
                turnLost +=1;
                // ASK USER IF HE WANNA TRY AGAIN
                if (player1.getCredit()>0){
                    System.out.println("Do you wanna play again write yes or no");
                    scan.nextLine();
                    userInput = scan.nextLine();
                    yn = userInput.toLowerCase();
                    if(yn.equalsIgnoreCase("no")){
                        gameStats(turn, reward, player1.getCredit(), averageFaceValue, averageBet, averageReward, turnWon, turnLost);
                    }
                } else {
                    System.out.println("You have no more credit left, game ends");
                    yn = "no";
                       gameStats(turn, reward, player1.getCredit(), averageFaceValue, averageBet, averageReward, turnWon, turnLost);
                       
                }
                 
                
            } 
            
            
       }
        
        
            
        
      
    }
    
}
