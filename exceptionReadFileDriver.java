/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expcetionChapter1;

/**
 *
 * @author labsadmin
 */


public class exceptionReadFileDriver {
    
        public static void main (String[] args){
    
    
        readFile readDataFromFile = new readFile();
        readDataFromFile.readData();
        System.out.println("\n");
    
        System.out.println("Calculating mean ");
        System.out.println("-----------------------");
        readDataFromFile.calculateMean();
               
        System.out.println("\n");
        System.out.println("Calculating the median");

        System.out.println("----------------------");
        readDataFromFile.calculateMedian();
        
                
        System.out.println("\n");
        System.out.println("Calculating the mode");

        System.out.println("----------------------");
        readDataFromFile.calculateMost();
    
    }
    
}
