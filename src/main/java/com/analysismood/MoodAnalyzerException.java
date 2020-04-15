package com.analysismood;
//created custom exception and extend exception class
// super, Call constructor of parent Exception
public class MoodAnalyzerException extends Exception
{
    public enum ExceptionType
    {
        NULL,EMPTY;
    }
    public ExceptionType type;
    public MoodAnalyzerException(ExceptionType type,String message)
    {
        super(message);
        this.type=type;
    }
    public MoodAnalyzerException(String message)
    {
        super(message);
    }
}
