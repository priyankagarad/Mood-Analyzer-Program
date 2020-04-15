package com.analysismood;
public class MoodAnalyzerProblem
{
    String message;
    public MoodAnalyzerProblem()
    {
        this.message=null;
    }
    //created constructor and pass string parameter
    public MoodAnalyzerProblem(String message)
    {
        this.message=message;
    }
    //created method for checking mood
    public String moodAnalyzerMethod(String mood)
    {
        if (message.contains("Happy"))
        {
            return "Happy";
        } else if (message.contains("Sad"))
        {
            return "Sad";
        }
        return mood;
    }
    public static void main (String args[])
    {
        System.out.println("Welcome to Mood Analyzer");
    }
}
