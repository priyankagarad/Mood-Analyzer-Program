package com.analysismood;
public class MoodAnalyzerProblem
{
    String message;
    //default constructor
    public MoodAnalyzerProblem()
    {
    }
    //created parameterized constructor and pass string parameter
    public MoodAnalyzerProblem(String message)
    {
        this.message=message;
    }
    //created method for checking mood
    //try and catch block use for handle nullPointer exception
    public String moodAnalyzerMethod(String mood)
    {
        try
        {
            if (message.contains("Happy"))
            {
                return "Happy";
            }
            else if (message.contains("Sad"))
            {
                return "Sad";
            }
        }
        catch(NullPointerException e)
        {
            return "Happy";
        }
            return mood;
    }
    public static void main (String args[])
    {
        System.out.println("Welcome to Mood Analyzer");
    }
}
