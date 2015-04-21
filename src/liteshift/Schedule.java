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
public class Schedule 
{
    private Employee schedule[][][];
    
    public Schedule(int maxShifts)
    {
        schedule = new Employee[3][7][maxShifts];
    }
    
    void updateSchedule(int i, int j, int k, Employee x)
    {
        schedule[i][j][k] = x;
        x.updateShifts();
    }
    void showName(int i, int j, int k)
    {
        System.out.print(schedule[i][j][k].name() + " ");
    }
    public boolean ScoreCheck(int i, int j, int k)
    {
        return schedule[i][j][k].availability[i][j] == schedule[i][j][k].preference[i][j];
    }
}
