/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liteshift;

/**
 *
 * @author TEE
 */
public class Employee
{
    private String name;
    private boolean fullTime;
    public boolean availability[][];
    public boolean preference[][];
    private int currentShifts;
    private boolean full;
    
    public Employee()
    {
        currentShifts = 0;
        availability = new boolean[3][7];
        preference = new boolean[3][7];
    }
    
    public Employee(String name, int fullTime, boolean availability[][],
            boolean preference[][])
    {
        this.name = name;
        this.full = false;
        if(fullTime == 1)
            this.fullTime = true;
        else
            this.fullTime = false;
        this.availability = new boolean[3][7];
        this.preference = new boolean[3][7];
        currentShifts = 0;
        for(int i = 0; i < availability.length;i++)
        {
            System.arraycopy(availability[i], 0, this.availability[i], 0,
                    this.availability[0].length);
            System.arraycopy(preference[i], 0, this.preference[i], 0, 
                    this.availability[0].length);
        }
    }
    
    public String name()
    {
        return name;
    }
    
    public boolean fullTime()
    {
        return fullTime;
    }
    void reset()
    {
        currentShifts = 0;
        this.full = false;
    }
    
    void updateShifts()
    {
        ++currentShifts;
        if(fullTime){
            if(currentShifts>=10)
                full = true;
            
        }
        else
            if(currentShifts>=7)
                full = true;          
    }
    public boolean isFull()
    {
            return full;
    }
       
}
