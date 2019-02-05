package expcetionChapter1;

/**
 *
 * @author Wayne A Davies
 */

import java.io.*; // import java package so as to import Buffered reader and File Reader and FileInputSreamReader classes
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

        try{//outer try

                    
            readFileData = new BufferedReader(new FileReader(getFileName)); // read data from a stream
            
            System.out.println("");//creates an empty space
          
            String data;//data stores the data or values in a file
            
            try{//inner try
                

                
            while((data = readFileData.readLine()) != null){ // while loop assigns the data of readFile to data variable 
                                                             // file is                                                       
                lines++; // increments lines as long as file is not empty
                System.out.println(lines+".Reading File Data : " + data);//displays the data to the screen 
                System.out.println("");//creates an empty space
       
                }

            returnCounted += lines; // adds lines to return Counted and assigns the value to return Counted
            
            }
            catch(FileNotFoundException e){ // handle  for file not found exception nested catch
            
                System.out.println("could not find File.");        // display message to screen
                System.out.println("message : " + e.getMessage());
            
            }
            catch(IOException ioe){  // handles IOException  . nested catch
            
                System.out.println("Encounted a problem ");// displays message
                System.out.println("message : " + ioe.getMessage() );
            
            }
            
            finally{ // finally block excutes whethere the conditions were met or not
            
                System.out.println("");
                System.out.println("Finished reading File Total Lines : " + returnCounted );//Displays results on screen
                
            
            }

        }
        catch(FileNotFoundException fnfe){ // outer catch handles File not found Exception
        
            System.out.println("File not found "); // display results
        
            System.out.println("message  : " + fnfe.getMessage());//gets the objects message
        }
   
        
        finally{//finnaly in the outer try excutes wethere the conditions are met or not
        
            
            System.out.println("");//creates an empty space
        
            System.out.println("Complete processing file : " + getFileName);// displays the name
        
        }
        
       return lines;//returns the number of lines counted lines

    }
    

    
    
    
    
    

  
    // method readData reads from file and dislplays results
    void readData(){ 

        try{ // trying code
        
            getFileData = new File("C:\\Users\\labsadmin\\Desktop\\Prac 8\\dataset"); // created  an object getFileData which reads from the stream
            System.out.println("File Opened ");//If the file is opened than the message is displayed
            countNumbers(getFileData);//counts the number of each line

        }

        catch(NullPointerException e){ // if empty spaces are encounted
        
            // do nothing
        
        }

        finally { // the finally block excutes wether the conditions were met or not
            
            try
            {//trying code in a finally block
                
                
            
            readFileData.close(); // closing the the file
            System.out.println("Document closed ."); // displays the message if successfull
            
            }
            
            catch(IOException ioe){// if file fails to close than the JVM handles the exception
            
                
                System.out.println("Encountered an Error while closing a file ");//displaying results
                System.out.println("message : " + ioe.getMessage());//displays the results
         
            }
        }

            

        }
    
    
    // method calculate Mean sorts the data in ascending order and calcuate mean
    int calculateMean(){
    
        int mean = 0; // variable mean will hold the mean value
        String data;// variable data will contain the location of the file
        int countsWithOutEmptySpaces = 0;//
        int changeDataType = 0;
          
        try{
        
        
         readFileData = new  BufferedReader(new FileReader("C:\\Users\\labsadmin\\Desktop\\Prac 8\\dataset")); // data from file
            
            while((data = readFileData.readLine()) != null){ // while the file is not empty
                                                             // this body will excute 

                if("".equals(data)){ // if encounted an empty space
                    
                    // do nothing

                }
                
                else{ // if encouted a line with a number

                    countsWithOutEmptySpaces ++; // than the countsWithNumbers incremments
                    
            //        System.out.println("lines counted with no spaces : "+countsWithOutEmptySpaces );
 

                 //   System.out.println("Reading File : " + data);

                    changeDataType += Integer.parseInt(data); // change the data from sting to an int using wrapper classes

                 //   System.out.println("Total "+changeDataType);
               
                    
                    mean = changeDataType / countsWithOutEmptySpaces; // the total divided by the number of counts
                   
                }

            }
            
           // System.out.println("Total counted with  "+changeDataType);
            
            System.out.println("Calculating mean");
            System.out.println("----------------");
            System.out.println("Mean : " + mean);
        } 
        catch(FileNotFoundException fnfe){ // handles file not found exception
        
            System.out.println("File was not found ");//displays message to screen
            System.out.println("message : " + fnfe.getMessage());
        
        }
        catch(IOException ioe){ // handles file not found exception
        
            System.out.println("Encountered a problem while processing file ");//display message
            System.out.println("message " + ioe.getMessage());
        
        }
        
        finally{// finally excutes wether condition was met or not
        
        System.out.println("Finishing calculating mean .");//displays the final rmessage of the method
        System.out.println("----------------------------");
            
        
        }

        return mean;// return the mean calculated
        
    }
    
    
    
    //--------------method that calculates the median 
    
    int calculateMedian(){

        String data; // stores the file location 
        int changeDataType; // stores the data type which has been parsed to an int
        int median = 0;     // stores the median
        ArrayList<Integer> addFileData = new ArrayList<>(); // stores the data of a file
        int sortedData; // stores the sorted data
    
        int calculateMedian;//  stores the calculated mdian
      
        try{// trying the code

                    readFileData = new  BufferedReader(new FileReader("C:\\Users\\labsadmin\\Desktop\\Prac 8\\dataset")); // opening file

                    while((data = readFileData.readLine()) != null){  // if data does not encounter an empty space

                        if("".equals(data)){// if data encounters an empty line
                                            //than
                            // do nothing
                        
                        }

                        else{//else this body excutes

                            changeDataType = Integer.parseInt(data); // changing the data type to a type of int
                            
                            addFileData.add(changeDataType);// adding the object to an ArrayList  addFileData
  
                        }// closing the else body
                        
            
                    }// closing the while body

 

                Collections.sort(addFileData);//sorting the addFile data to ascending order
              
                if (addFileData.size()/2 == 1){  //if the addFile data is divisible 2 and leaves a remainder
                                                 // than this body excutes

                    int sizeLower =  addFileData.size()/2;//stores the  half of the addFileData
                    int sizeHigher = sizeLower+1;         // stores the half + 1 of addFileData
                
                    System.out.println("Size :" + sizeLower );// Displays the vale fro sizeLower
                
                
                    int outPut = (sizeLower + sizeHigher) / 2; // calculates the  meddle size
                
                    System.out.println("Median : "+addFileData.get(outPut));//gets the index of the middle position
                
                
                }
                
                else {
                
                
                    int sizeLower =  addFileData.size()/2;// gets the half a size of addFileData
                    int sizeHigher = addFileData.size()/2;// gets the half a size of addFileData
                
                    System.out.println(" "); // creates an empty space
                    calculateMedian = (addFileData.get(sizeLower - 1)+addFileData.get(sizeHigher));//calculates the mean
                    
                    System.out.println("Meadian : " +calculateMedian);// displays results
                
                } // closing the else statement
                

                
        } // closing the try body // closing the try body
        
        catch(FileNotFoundException fnfe){ //  handles file not found exception

            System.out.println("File was not found ");//displays the message
            System.out.println("message : " + fnfe.getMessage());
        
        }
        catch(IOException ioe){// handling IOException body
        
            System.out.println("Encountered a problem while processing file ");//displays the exception message
            System.out.println("message " + ioe.getMessage());
        
        }//closing IOExeption
        
        finally{//finally  block excutes wethere the condition is met or not
            
            System.out.println("Finished calculating median");//displays the text
            System.out.println("---------------------------");// displays the text
           

        }// closing the finally block

        return median;// return the calculated middle number
        
    }//closing the calculateMedian class
     

    
    
    
    // method mode reads a file and calculates the 
    // most number that appears in the array
    public void calculateMost(){ 
    
        
        
        String data;
        int changeDataType; // will store the parsed data type 
        ArrayList<Integer> storeFileData = new ArrayList<>(); // stores the data that is read fromthe file
        int sortedData;
      
        try{ // try  statement trys code of block

            
            //Opening file  
                    readFileData = new  BufferedReader(new FileReader("C:\\Users\\labsadmin\\Desktop\\Prac 8\\dataset")); // reading from file

                    while((data = readFileData.readLine()) != null){ // if the file not being read is not empty

                        if("".equals(data)){// if an empty space is encounted in the data
                            // do nothing
                        }
                        else{// if the selection statement in first condtion failed than this selection statement excutes

                            changeDataType = Integer.parseInt(data); // changing the data type to an interger
                            
                            storeFileData.add(changeDataType);//adds the change data to an ArrayList

                        }//closing the else body

                    }//closing the while body

                    Collections.sort(storeFileData); // sorted the Data File with Collections java class with the sort method


                    int mode = 0 ; // stores the most counted value
                    int maximumCount = 0; // stores the maximum Count

                    for (int i = 0 ; i < storeFileData.size();i++){// if i is smaller than the size of storeFileData than i increments
                        
                        int count = 0 ; // count holds the number of counts
                        
                        for (int j = 0 ; j < storeFileData.size(); j++){//in a nested loop if j is smaller than the size of FileData than j incremments
                            
                            if(Objects.equals(storeFileData.get(i), storeFileData.get(j)))// if the condition is true
                            {
                                                                                         // this body excutes
                                count++;//increment count
	
                            }//cloese if body
	
                        }//close nested for loop



                        if(count > maximumCount){ // if count is bigger than maximumCount
                                                  // this body excutes
	
                            maximumCount = count; // than the program assigns the count to the variable maximumCount

                            mode = storeFileData.get(i);//storing the mode

                        }// closing the if body

                    }//closes the  for loop
                    
                 System.out.println("Mode : " + mode);//displays the mode
        }

        catch(FileNotFoundException fnfe){ // Handles a file not found exception
            
            System.out.println("Encountered a problem while opening file . ");// displays the message
            System.out.println("Message : " + fnfe.getMessage());// dislplays the from the object exception
            
        }
        catch(IOException ioe ){ // handles Input and OutPut Exception
            
            System.out.println("Could not read file .");//displays message
            System.out.println("message " + ioe.getMessage());
            
        }  
        
        finally {//finally excutes wether the condition was met
        
            System.out.println("\n");// create a empty line
            System.out.println("Finished calculating Mode");// displays text
            System.out.println("-------------------------");//displays text
        
        }//closing the finally block
                    
        
        
    
        }// closes the calculateMode bode
    
    

}//closes the readFile class
        
        

        

     

    
    
    
    

    

