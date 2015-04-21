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
public class MyStack {
   private int maxSize;
   private int[] stackArray;
   private int top;
   public MyStack(int s) {
      maxSize = s;
      stackArray = new int[maxSize];
      top = -1;
   }

    /**
     *
     * @param j
     */
   public void push(int j) {
      stackArray[++top] = j;
   }
   public int pop() {
      return stackArray[top--];
   }
   public int peek() {
      return stackArray[top];
   }
   public boolean isEmpty() {
      return (top == -1);
   }
   public boolean isFull() {
      return (top == maxSize - 1);
   }
}