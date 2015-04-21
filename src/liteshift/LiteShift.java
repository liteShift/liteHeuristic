/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liteshift;
import java.io.*;
import java.util.*;

/**
 *
 * @author TEE
 */
public class LiteShift {
    

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        int fullTime, maxShifts = 0;
        int shifts[][] = new int [3][7];
        int r = 0; //stores the number of employees
        boolean availability[][] = new boolean [3][7];
        boolean preference[][] = new boolean [3][7];
        String line;
        
        try (Scanner scanner = new Scanner(new File("/Users/N/desktop/storedata/Business.txt"))) {
            line = scanner.nextLine();
            for(int i = 0; i < 3; i++)
                for(int j = 0; j < 7; j++)
                {
                    shifts[i][j] = scanner.nextInt();
                    if(shifts[i][j] > maxShifts)
                        maxShifts = shifts[i][j];
                }
        }
        Business myBusiness = new Business(line,shifts);
        
        File dir = new File("/Users/N/desktop/storedata/Employees/");
        File[] directoryListing = dir.listFiles();
        Employee[] employees = new Employee[directoryListing.length];
        for(File child : directoryListing)
        {
            try(Scanner scanner = new Scanner(child)){
                line = scanner.nextLine();
                fullTime = scanner.nextInt();
                for(int i = 0; i < 3; i ++)
                    for(int j = 0; j < 7; j++)
                    {   
                        if(scanner.nextInt() == 1)
                            availability[i][j] = true;
                        else
                            availability[i][j] = false;
                    }
                for(int i = 0; i < 3; i ++)
                    for(int j = 0; j < 7; j++)
                    {   
                        if(scanner.nextInt() == 1)
                            preference[i][j] = true;
                        else
                            preference[i][j] = false;
                    }
            
                }
            employees[r++] = new Employee(line,fullTime,availability,preference);
            
        }
        
        //Create the schedule using maxShifts to define the 3rd dimension
        Schedule schedule = new Schedule(maxShifts);
        Schedule bestSchedule = new Schedule(maxShifts);
        MyStack theStack = new MyStack(r);
       
        
        int topScore = 0;
        for(int runTime = 0; runTime < 1000000; runTime++)
        {
            Collections.shuffle(Arrays.asList(employees));
            for(int j = 0; j < 7; j++)
                for(int i = 0; i < 3; i ++)
                {
                    int check = 0;
                    for(int k = 0; k < directoryListing.length; k++)
                    {
                        
                        if((employees[k].availability[i][j]==true) && (!employees[k].isFull()))
                        {
                            check++;
                            theStack.push(k);
                        }
                    }
                    if(check < maxShifts)
                    {
                        System.out.println(runTime);
                    }
                    for(int d = 0; d < maxShifts; d++)
                    {
                        if(!theStack.isEmpty())
                            schedule.updateSchedule(i, j, d, employees[(theStack.pop())]);
                    }
                    
                    while(!theStack.isEmpty())
                        theStack.pop();
                }
            for(int i =0; i< directoryListing.length;i++)
                employees[i].reset();
        
            
        
        
            int score = 0;
            for(int i = 0; i < 3; i ++)
                for(int j = 0; j < 7; j++)
                    for(int k = 0; k < maxShifts; k++)
                    {
                        if(schedule.ScoreCheck(i, j, k))
                            score+=2;
                    }
            if(score > topScore)
            {
                
                bestSchedule = schedule;
                topScore = score;
            
            }
            
        }
        System.out.println(topScore);
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                for(int k = 0; k < maxShifts;k++)
                    bestSchedule.showName(j, i, k);
                
                System.out.println();
            }
            
            System.out.println("\n");
        }
            
            
        
        
       
        
                    
                    
        
        
        
        
        
        
        
        //END OF FILE I/O and employee object creation
        //Begin creating availability matrices
        
      
       
        
        
        
        
        
        
         
    
  }
        
        
        
      
}
        
       
    

