package com.analysismood;
import org.junit.Assert;
import org.junit.Test;
public class MoodAnalyzerProblemTest
{
    //TC:1.1--> Given Sad Mood Message Should Return Sad
    @Test
    public void givenSadMoodMessage_whenValid_shouldReturnSad() throws MoodAnalyzerException
    {
        MoodAnalyzerProblem mood = new MoodAnalyzerProblem("I am in Sad Mood");
        String result = mood.moodAnalyzerMethod();
        Assert.assertEquals("Sad", result);
    }
    //TC:1.2 --> Given Happy Mood Message Should Return Happy
    @Test
    public void givenHappyMoodMessage_whenValid_shouldReturnHappy() throws MoodAnalyzerException
    {
        MoodAnalyzerProblem mood = new MoodAnalyzerProblem("I am in Happy Mood");
        String result = mood.moodAnalyzerMethod();
        Assert.assertEquals("Happy", result);
    }
    //TC:2.1--> Given Null Mood Should Return Happy
    @Test
    public void givenMood_whenNullMood_ShouldReturnHappy() throws MoodAnalyzerException
    {
        MoodAnalyzerProblem mood=new MoodAnalyzerProblem("NULL");
        String result=mood.moodAnalyzerMethod();
        Assert.assertEquals("Happy",result);
    }
    //TC:3.1-->Given Mood When Null Should Return Custom Message
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
    //TC:3.2-->Given Mood When Empty Should Return Custom Message
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
    //TC:4.1-->Given Mood Analyzer Class Using Default Constructor when proper should return object
    @Test
    public void givenMoodAnalyzerClassUsingDefaultConstructor_whenProper_shouldReturnObject()
    {
        MoodAnalyzerProblem moodAnalyzerReflector=MoodAnalyzerReflector.createMoodAnalyserDefault();
        Assert.assertEquals(new MoodAnalyzerProblem(),moodAnalyzerReflector);
    }
    //TC:4.2,TC:5.2-->Method Not Found Exception
    @Test
    public void givenClassName_whenImproper_shouldReturnMoodAnalyzerException()
    {
        try
        {
            MoodAnalyzerReflector.getConstructor("com.analysismood.MoodAnalyzerProblem",String.class);
        }
        catch (MoodAnalyzerException e)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }
    //TC:4.3--> Class Not Found Exception
    @Test
    public void givenClassName_whenConstructorNotProper_shouldReturnMoodAnalyzerException()
    {
        try
        {
            MoodAnalyzerReflector.getConstructor("com.analysismood.MoodAnalyzerProblem",String.class);
        }
        catch (MoodAnalyzerException e)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }
    //TC:5.1
    @Test
    public void givenMoodAnalyzerUsingParameterizedConstructor_whenProper_shouldReturnObject()
    {
        MoodAnalyzerProblem moodAnalyzerReflector =  MoodAnalyzerReflector.createMoodAnalyzer("I am In Happy Mood");
        Assert.assertEquals(new MoodAnalyzerProblem("I am In Happy Mood"),moodAnalyzerReflector);
    }
    //TC:6.1
    @Test
    public void givenMoodAnalyzerParameterConstructor_whenProper_thenReturnObject()
    {
        MoodAnalyzerProblem moodAnalyzerReflector=MoodAnalyzerReflector.createMoodAnalyzer("I am in Happy Mood");
        try
        {
            String mood=(String) MoodAnalyzerReflector.invokeMethod(moodAnalyzerReflector,"moodAnalyzerMethod") ;
            Assert.assertEquals("Happy",mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }
}
