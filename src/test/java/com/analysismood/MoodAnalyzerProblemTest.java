package com.analysismood;
import org.junit.Assert;
import org.junit.Test;
public class MoodAnalyzerProblemTest
{
    //TC:1.1
    @Test
    public void givenSadMoodMessage_shouldReturnSad() throws MoodAnalyzerException
    {
        MoodAnalyzerProblem mood = new MoodAnalyzerProblem("I am in Sad Mood");
        String result = mood.moodAnalyzerMethod();
        Assert.assertEquals("Sad", result);
    }
    //TC:1.2
    @Test
    public void givenHappyMoodMessage_shouldReturnHappy() throws MoodAnalyzerException
    {
        MoodAnalyzerProblem mood = new MoodAnalyzerProblem("I am in Happy Mood");
        String result = mood.moodAnalyzerMethod();
        Assert.assertEquals("Happy", result);
    }
    //TC:2.1
    @Test
    public void givenNullMood_ShouldReturnHappy() throws MoodAnalyzerException
    {
        MoodAnalyzerProblem mood=new MoodAnalyzerProblem("NULL");
        String result=mood.moodAnalyzerMethod();
        Assert.assertEquals("Happy",result);
    }
    //TC:3.1
    @Test
    public void givenMood_whenNull_shouldReturnCustomMessage()
    {
        MoodAnalyzerProblem mood = new MoodAnalyzerProblem();
        try
        {
            mood.moodAnalyzerMethod();
        }
        catch (MoodAnalyzerException e)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NULL,e.type);
        }
    }
    //TC:3.2
    @Test
    public void givenMood_whenEmpty_shouldReturnCustomMessage()
    {
        MoodAnalyzerProblem mood= new MoodAnalyzerProblem("");
        try
        {
            mood.moodAnalyzerMethod();
        }
        catch (MoodAnalyzerException e)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EMPTY,e.type);
        }
    }
}
