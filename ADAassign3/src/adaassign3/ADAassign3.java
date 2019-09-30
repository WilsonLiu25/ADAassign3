/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaassign3;

import java.util.Stack;

/**
 *
 * @author will2
 */
public class ADAassign3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<String> stackOfCards = new Stack<>();
        
        stackOfCards.push("1");
        stackOfCards.push("2");
        stackOfCards.push("3");
        stackOfCards.push("4");
        
        System.out.println(stackOfCards);
        
        System.out.println(stackOfCards.peek());
        
        System.out.println(stackOfCards.search("3"));

        

    }

}
