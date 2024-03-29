package com.cavisson.ata.utils;
import java.util.LinkedList;

//Java program to implement solution of producer
//consumer problem.


public class ProducerConsumerEx
{
  public static void main(String[] args) throws InterruptedException
  {}
  
  public String startProdCon()
  {

    // Object of a class that has both produce()
    // and consume() methods
     PC pc = new PC();

     try 
     {
    // Create producer thread
    Thread t1 = new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        try
        {
          pc.produce();
        }
        catch(InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    });

    // Create consumer thread
    Thread t2 = new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        try
        {
          pc.consume();
        }
        catch(InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    });

    // Start both threads
    t1.start();
    t2.start();

    // t1 finishes before t2
    t1.join();
    t2.join();
     }
     catch(Exception e)
     {
       e.printStackTrace();
     }
  
    return "Producer Consumer started";
  }

  // This class has a list, producer (adds items to list
  // and consumber (removes items).
  public static class PC
  {

    // Create a list shared by producer and consumer
    // Size of list is 2.
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;

    // Function called by producer thread
    public void produce() throws InterruptedException
    {
      int value = 0;
      while(value <= 300)
      {
        synchronized(this)
        {
          // producer thread waits while list
          // is full
          while(list.size() == capacity)
            wait();

          System.out.println("Producer produced-" + value);

          // to insert the jobs in the list
          list.add(value++);

          // notifies the consumer thread that
          // now it can start consuming
          notify();

          // makes the working of program easier
          // to understand
          Thread.sleep(1000);
        }
      }
    }

    // Function called by consumer thread
    public void consume() throws InterruptedException
    {
      int val = 0;
      while(val <= 300)
      {
        synchronized(this)
        {
          // consumer thread waits while list
          // is empty
          while(list.size() == 0)
            wait();

          // to retrive the ifrst job in the list
          val = list.removeFirst();

          System.out.println("Consumer consumed-" + val);

          // Wake up producer thread
          notify();

          // and sleep
          Thread.sleep(1000);
        }
      }
    }
  }
}

