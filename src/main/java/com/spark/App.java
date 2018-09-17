package com.spark;

import com.spark.configs.ApplicationServerConfiguration;

public class App
{

    public static void main( String[] args )
    {
        new ApplicationServerConfiguration().setConfig();
        new Routes().setRoutes();
        // carregar csv aqui
    }
}
