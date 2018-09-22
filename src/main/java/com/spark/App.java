package com.spark;

import com.spark.http.ApplicationServer;
import com.spark.services.MovieListManager;

public class App
{
    public static void main( String[] args )
    {
        new ApplicationServer();
        MovieListManager.run();
    }
}
