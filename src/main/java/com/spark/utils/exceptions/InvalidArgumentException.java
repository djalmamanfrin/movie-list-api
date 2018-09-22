package com.spark.utils.exceptions;

public class InvalidArgumentException extends Exception {

    private String[] arguments;
    private String realMessage;

    public InvalidArgumentException(String arg) {
        super("Invalid Arguments");
        this.arguments = new String[]{arg};
        this.realMessage = getRealMessage();
    }

    public String getRealMessage() {
        StringBuffer var1 = new StringBuffer("{");
        for (int var2 = 0; var2 < this.arguments.length; ++var2) {
            var1.append(this.arguments[var2]);
            if (var2 < this.arguments.length - 1) {
                var1.append(", ");
            }
        }
        var1.append(" }");
        return String.format("Invalid Arguments", var1);
    }

    public String getMessage() {
        return realMessage;
    }
}
