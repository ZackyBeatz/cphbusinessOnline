/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

import java.util.Random;

/**
 *
 * @author Zack
 */
public class Dice {
    
    int value;
    
    
    public int roll() {
        Random rand = new Random();
        
        value = rand.nextInt(6)+1;
        
        return value;
    }
    
    
    
    
    
    
    
}
