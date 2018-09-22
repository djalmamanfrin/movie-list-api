package com.spark;

import com.spark.http.ApplicationServer;
import com.spark.serives.MovieListManager;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        new ApplicationServer();
        MovieListManager.run();
    }
}
