package com.analysismood;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
public class MoodAnalyzerReflector
{
    public static MoodAnalyzerProblem createMoodAnalyserDefault()
    {
        try
        {
            Constructor constructor=Class.forName("com.analysismood.MoodAnalyzerProblem").getConstructor();
            MoodAnalyzerProblem moodAnalyzer=(MoodAnalyzerProblem) constructor.newInstance();
            return moodAnalyzer;
        } catch (ClassNotFoundException | NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //Return Constructor of Passed Class Name And Constructor Name
    public  static  Constructor<?> getConstructor(String className,Class constructor) throws MoodAnalyzerException {
        try {
            Class<?> moodAnalyzer = Class.forName(className);
            return  moodAnalyzer.getConstructor(constructor);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD,e.getMessage());
        }
    }
}
