package com.spark;

import com.spark.http.ApplicationServer;
import com.spark.utils.csv.CsvFileReader;

public class App
{
    public static void main( String[] args )
    {
        new ApplicationServer();
        new CsvFileReader().getMovies();
    }
}
