package com.analysismood;
import org.junit.Assert;
import org.junit.Test;
public class MoodAnalyzerProblemTest
{
    @Test
    public void givenSadMoodMessage_shouldReturnSad()
    {
        MoodAnalyzerProblem mood = new MoodAnalyzerProblem("I am in Sad Mood");
        String result = mood.moodAnalyzerMethod("");
        Assert.assertEquals("Sad", result);
    }
    @Test
    public void givenHappyMoodMessage_shouldReturnHappy()
    {
        MoodAnalyzerProblem mood = new MoodAnalyzerProblem("I am in Happy Mood");
        String result = mood.moodAnalyzerMethod("");
        Assert.assertEquals("Happy", result);
    }
}
