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
public class Business
{
    private String name;
    private int shiftMatrix[][];
    
    public Business(String name, int shiftMatrix[][])
    {
        this.name = name;
        this.shiftMatrix = new int[3][7];
        for(int i = 0; i < shiftMatrix.length;i++)
        {
            System.arraycopy(shiftMatrix[i], 0, this.shiftMatrix[i], 0,
                    this.shiftMatrix[0].length);
        }
    }
    
    public int numberOfShifts(int i, int j)
    {
        return shiftMatrix[i][j];
    }
    
    public String name()
    {
        return this.name;
    }
}
