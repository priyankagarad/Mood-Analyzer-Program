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
    public String moodAnalyzerMethod() throws MoodAnalyzerException
    {
        try
        {
            if (message.isEmpty())
            {
                throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.EMPTY,"Message is Empty");
            }
            if (message.contains("Sad"))
            {
                return "Sad";
            }
            return "Happy";
        }
        catch(NullPointerException e)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NULL,"Null Message");
        }
    }
    public static void main (String args[])
    {
        System.out.println("Welcome to Mood Analyzer");
    }
}
