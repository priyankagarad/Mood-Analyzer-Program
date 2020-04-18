package com.analysismood;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    // Return Object of Parameterized Constructor
    public static MoodAnalyzerProblem createMoodAnalyzer(String message)
    {
        try
        {
            Constructor<?> constructor = Class.forName("com.analysismood.MoodAnalyzerProblem").getConstructor(String.class);
            return (MoodAnalyzerProblem) constructor.newInstance(message);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
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
    //Method Invoked using Reflection
    public static Object invokeMethod(MoodAnalyzerProblem moodAnalyzerProblem,String methodName) throws MoodAnalyzerException
    {
        try
        {
            return moodAnalyzerProblem.getClass().getMethod(methodName).invoke(moodAnalyzerProblem);
        }
        catch (IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD,e.getMessage());
        }
        return null;
    }
    public static String setFieldValue(MoodAnalyzerProblem obj, String message, String fieldName) throws MoodAnalyzerException
    {
        try {
            Field field=obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj,message);
            return (String) obj.getClass().getDeclaredMethod("analyseMood").invoke(obj);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_FIELD,e.getMessage());
        } catch (IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.METHOD_INVOCATION_ISSUE,e.getMessage());
        }
        return message;
    }
}
