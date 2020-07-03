import java.awt.event.*;

import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class Board   {
    
    private String str = " ";
    private Random rand;
    private String[] moviesList = {"captain america", "iron man", "die hard", "cars", "call me by your name", "venom", "super bad", "parasite", "joker"};
    private String phrase = "";
    private char[] arr;
    private char[] answer; 
    private char a;
    String guesses = "";
    String hello = "";
    private boolean check = false;
    private boolean check2 = false;
    private int pos;
    
    public Board()
    {
        rand = new Random();


    }
        
    public void init()
    {
        int num = rand.nextInt(moviesList.length);
        phrase = moviesList[num];
        arr = phrase.toCharArray();
        answer = new  char[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            answer[i] = '*';
            if (Character.toString(arr[i]).equals(" ")) 
            {
                answer[i] = ' ';
            }
            if (Character.toString(arr[i]).equals("a")) 
            {
                answer[i] = 'a';
            }
            if (Character.toString(arr[i]).equals("e")) 
            {
                answer[i] = 'e';
            }            
            if (Character.toString(arr[i]).equals("u")) 
            {
                answer[i] = 'u';
            }



            hello = hello + answer[i]; 
        }
    }

    public void takeInput()
    {
        str = JOptionPane.showInputDialog("Enter a letter in lowercase");
        guesses += str;
        a = str.charAt(0);
        if(str.equals(null))
        {
            str = "";
        }
    }
    public void reset()
    {

        hello = "";
        init();
        

    }


    public boolean checkIfPresent()
    {

            if(phrase.indexOf(a) != -1)
            {
                check = true;

            }
            else 
            {
                check = false;
            }
        
        return check;
    }


    public char[] getAns()
    {
        return answer;
    }
    public String getEntry()
    {
        return str;

    }

    public String initialDisplay()
    {

        for(int i = 0; i<arr.length; i++)
        {
            if (arr[i] == a) {
                
                answer[i] = a;
                hello = hello.substring(0,i) + a + hello.substring(i+1);
            }
        }

        return hello ;

    }

    public boolean checkifComplete()
    {

            if(hello.indexOf("*") != -1)
            {
                check2 = false;
            }
            else
            {
                check2 = true;
            }
        return check2;
        
    }



}