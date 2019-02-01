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

import java.io.*; // import java package io
import java.util.ArrayList; // immporting arrayList  for storing file data
import java.util.*;

/*

readFile : class readFile reads the file being opened and 
           counts the number of files till the end of the file 
           it than calculates the mean,median and mode and displays the result

*/

      
class nullSpaceException extends Exception{} // created own exception class 
       
public class readFile { // main class
    
    File  getFileData = null ; //  instance variable name assigine to null
    BufferedReader   readFileData      = null ; //  instance variable that reads characters from a file
   

    
    //method countNumbers counts the numbers in a file
    int countNumbers(File getFileName){ 

        
         int lines = 0;// stores the number of lines in a file
         int returnCounted = 0;//returns the total number of lines counted
         int countsWithOutNubers = 0;

        try{//trying the code

                    
            readFileData = new BufferedReader(new FileReader(getFileName)); // 
            
            System.out.println("");//creates an empty space
          
            String data;//data stores the data or values in a file
            
            try{//trying the code
                

                
            while((data = readFileData.readLine()) != null){ // while loop assigns the data of readFile to data variable 
                                                             // file is not empty

                                                             
                lines++;
                System.out.println("line Number   : "+ lines+"  Reading File Data : " + data); 
                System.out.println("");
               
                
                

                }
            

            
            returnCounted += lines;
            
            }
            catch(FileNotFoundException e){}
            catch(IOException e){}
            
            finally{
            
                System.out.println("");
                System.out.println("Finished reading File Total Lines : " + returnCounted );
                
            
            }

        }
        catch(FileNotFoundException fnfe){
        
            System.out.println("File not found ");
        
            System.out.println("message  : " + fnfe.getMessage());
        }
   
        
        finally{
        
            
            System.out.println("");
        
            System.out.println("Complete processing file : " + getFileName);
        
        }
        
       return lines;

    }
    
    
    
    
    
    void readData(){
    
        
        
        try{
        
            getFileData = new File("C:\\Users\\labsadmin\\Desktop\\Prac 8\\dataset");
            System.out.println("File Opened ");
            countNumbers(getFileData);
            
 
        }
        
        
        catch(NullPointerException e){
        
            // do nothing
        
        }

        finally {
            
            try{
                
            System.out.println("Document closed .");
            readFileData.close();
            
            }
            
            catch(IOException ioe){
            
                System.out.println("Encountered an Error while closing a file ");
         
            }
        }

            

        }
    
    int calculateMean(){
    
        int mean = 0;
        String data;
        int countsWithOutNubers = 0;
        int changeDataType = 0;
        
        
        
        try{
        
        
         readFileData = new  BufferedReader(new FileReader("C:\\Users\\labsadmin\\Desktop\\Prac 8\\dataset")); // 
            
            while((data = readFileData.readLine()) != null){
                

                if("".equals(data)){
                    
                    
                
                }
                
                else{
                    
                    
                
                    countsWithOutNubers ++;
                    
                    System.out.println("lines counted with no spaces : "+countsWithOutNubers );
                   System.out.println("");
                   System.out.println("Reading File : " + data);
                    
                 
  
                    changeDataType += Integer.parseInt(data);
                    
                    
                    System.out.println("Total "+changeDataType);
                    System.out.println("");
                    
                    mean = changeDataType / countsWithOutNubers;
                   
                }

                
               
            }
            
            System.out.println("Total counted with  "+changeDataType);
            
            System.out.println("Calculating mean");
            System.out.println("----------------");
            System.out.println("Mean : " + mean);
        } 
        catch(FileNotFoundException fnfe){
        
            System.out.println("File was not found ");
            System.out.println("message : " + fnfe.getMessage());
        
        }
        catch(IOException ioe){
        
            System.out.println("Encountered a problem while processing file ");
            System.out.println("message " + ioe.getMessage());
        
        }
        
        finally{
        
        System.out.println("Finishing calculating mean .");
        System.out.println("----------------------------");
            
        
        }

        return mean;
        
    }
    
    
    
    //--------------method that calculates the median 
    
    int calculateMedian(){

        String data;
        int changeDataType;
        int median = 0;
        ArrayList<Integer> addFileData = new ArrayList<>();
        int sortedData;
        
        
               
        try{

                    readFileData = new  BufferedReader(new FileReader("C:\\Users\\labsadmin\\Desktop\\Prac 8\\dataset")); // 

                    while((data = readFileData.readLine()) != null){

                        if("".equals(data)){}

                
                        else{

                            changeDataType = Integer.parseInt(data);
                            
                            addFileData.add(changeDataType);

                            
                        }
                        
            
                    }

 

                Collections.sort(addFileData);

                
            
                                
                if (addFileData.size()/2 == 1){
                
                
                    int sizeLower =  addFileData.size()/2;
                    int sizeHigher = sizeLower+1;
                
                    System.out.println("Size :" + sizeLower );
                
                
                    int outPut = (sizeLower + sizeHigher) / 2;
                
                    System.out.println("Median : "+addFileData.get(outPut));
                
                
                }
                
                else {
                
                
                    int sizeLower =  addFileData.size()/2;
                    int sizeHigher = addFileData.size()/2;
                
                    System.out.println(" ");
                    int calculateMean;
                    calculateMean = (addFileData.get(sizeLower - 1)+addFileData.get(sizeHigher));
                    
                    System.out.println("Meadian : " +calculateMean);
                
                } 
                

                
        } 
        
        catch(FileNotFoundException fnfe){

            System.out.println("File was not found ");
            System.out.println("message : " + fnfe.getMessage());
        
        }
        catch(IOException ioe){
        
            System.out.println("Encountered a problem while processing file ");
            System.out.println("message " + ioe.getMessage());
        
        }
        
        finally{
            
            System.out.println("Finished calculating median");
            System.out.println("---------------------------");
           

        }

        return median;
        
    }
     
    int calculateMode(){

        int modeReturn = 1;
        String data;
        int changeDataType;
        ArrayList<Integer> addFileData = new ArrayList<>();
        int sortedData;
      
        try{

                    readFileData = new  BufferedReader(new FileReader("C:\\Users\\labsadmin\\Desktop\\Prac 8\\dataset")); // 

                    while((data = readFileData.readLine()) != null){

                        if("".equals(data)){
                        
       
                            // do nothing
                        
                        }

                
                        else{

                            changeDataType = Integer.parseInt(data);
                            
                            addFileData.add(changeDataType);

                        }
                        
            
                    }

              
                    Collections.sort(addFileData);
              
            
                    int[] array = {1,1,2,2,3,4,5,5,5,5};

                int firstCount = 1;
                int secondCount = 1;
                int previous = array[0];
                int next     = array[1];
                int mode     = array[0];
                
                
                System.out.println("First comparaed value : " + previous);
                System.out.println("Second compared value : " + next);
                
                for (int i = 1 ; i < array.length;i++)
                {
                
                    if (previous==next){
                    
                        System.out.println("count : " + firstCount);

                        firstCount++;
                        previous = next;
                        next = array[i+1];
                        
                        System.out.println("First comparaed value : " + previous);
                        System.out.println("Second compared value : " + next);
                        
                       // System.out.println("Success counts : " + firstCount );
                      
                    
                    }
                    
                    else
                    {
                        
                        System.out.println("Not accessing else statement ");
                        
                        previous = array[i];
                        next = array[i + 1];
                        
                        if(previous == next){
                          
                            
                            secondCount++;
                            
                            System.out.println("Second count : " + secondCount);

                            if (secondCount > firstCount){
                            
                                firstCount  = secondCount;
                                secondCount = 1 ;
                                
                                System.out.println("Do u see me : ");

                            }
                            
                            else {
                                
                                firstCount  = secondCount;
                                secondCount = 1 ;
                            
                                System.out.println("Data failed  : ");
                            
                            }
                        
                        }
                        
                    }

                }
                System.out.println("Checking : " + firstCount);

    }
        
        catch(FileNotFoundException fnfe){
            
            System.out.println("Encountered a problem while opening file . ");
            System.out.println("Message : " + fnfe.getMessage());
            
        }
        catch(IOException ioe ){
            
            System.out.println("Could not read file .");
            System.out.println("message " + ioe.getMessage());
            
        }  
        
        finally {
        
        
            System.out.println("\n");
            System.out.println("Finished calculating Mode");
            System.out.println("-------------------------");
        
        }
        
        return modeReturn;
    }
    
    
    
    public int calculateMost(){
    
        int mode = 0;
        
                String data;
        int changeDataType;
        ArrayList<Integer> addFileData = new ArrayList<>();
        int sortedData;
      
        try{

                    readFileData = new  BufferedReader(new FileReader("C:\\Users\\labsadmin\\Desktop\\Prac 8\\dataset")); // 

                    while((data = readFileData.readLine()) != null){

                        if("".equals(data)){
                        
       
                            // do nothing
                        
                        }

                
                        else{

                            changeDataType = Integer.parseInt(data);
                            
                            addFileData.add(changeDataType);

                        }
                        
            
                    }

              
                    Collections.sort(addFileData); // sorted the Data File with Collections java class with the sort method
                    
                                

                int firstCount = 1; // variable firstCount  increments if two variables have the same vaue
                int secondCount = 1;// variable secondCount increments if two variables do not equal
                int previous = addFileData.get(0);// holds the previous values
                int next     = addFileData.get(1);// holds the next value
            
                
                System.out.println(addFileData.toString());
                
                
                System.out.println("First comparaed value : " + previous); // displays the first value of previous
                System.out.println("Second compared value : " + next);     // displays the second value of next
                
                for (int i = 1 ; i < addFileData.size()-1;i++)// in the for loop i increments until i  is no longer smaller than addFileData.size
                {
                    

                
                    // enterd if statement
                    if (previous==next){ // if previous values is equal next 
                                         // this line of code excutes
                    
                        System.out.println("count : " + firstCount); // displays the firstCount Value

                        firstCount++;// incremments firstCount
                        previous = next;  // assigining next to previous
                        next = addFileData.get(i+1); //  assigning  value from addFileData at position i and increment
                        
                        System.out.println("First comparaed value : " + previous); // displays the value store in previous
                        System.out.println("Second compared value : " + next); //  displays the value stored in next
                        
                       // System.out.println("Success counts : " + firstCount );
                      
                    
                    }// close if body
                    
                    else//else first selection statements is not true this else selection statement excutes
                    {// open body
                        
                            
                        System.out.println("");// creating space between two lines                            
                        
                        System.out.println("Compare Failed . count : " + previous + " not equal to " + next);// Displays the previous value and the
                                                                                                             // next value
                        System.out.println("");// creates an empty space
                            
                        previous = addFileData.get(i); // assigning previous a value of addFileData at position
                        next = addFileData.get(i + 1);// assigning  next a value of addFile at position i + 1
                        
                        if(previous == next){// if previous is equal to next is true

                            secondCount ++;//  increment secondCount
                           
                            System.out.println("Not accessing else statement ");                
                           
                             if (secondCount > firstCount){
                            
                                firstCount  = secondCount;
                                secondCount = 1 ;
                                
                                System.out.println("Do u see me : ");

                            }
                             else{
                             
       
                                 firstCount = secondCount;
                                 previous = addFileData.get(i); // assigning previous a value of addFileData at position
                        
                                 next = addFileData.get(i + 1);// assigning  next a value of addFile at position i + 1
                             
                             }

                        }
                        
                    }

                }
                
                System.out.println("");

                System.out.println("Count : " + firstCount);
                System.out.println("Count : " + secondCount);

    }
        
        catch(FileNotFoundException fnfe){
            
            System.out.println("Encountered a problem while opening file . ");
            System.out.println("Message : " + fnfe.getMessage());
            
        }
        catch(IOException ioe ){
            
            System.out.println("Could not read file .");
            System.out.println("message " + ioe.getMessage());
            
        }  
        
        finally {
        
        
            System.out.println("\n");
            System.out.println("Finished calculating Mode");
            System.out.println("-------------------------");
        
        }
                    
        
        return mode;
    
        }
}
        
        

        

     

    
    
    
    

    

