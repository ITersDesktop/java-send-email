package com.itersdesktop.javatechs;

/**
 * The main point of the application
 */
public class App {
    public static void main(String[] args) {
        SendEmail.send("Hello, World!", "nvntung@yahoo.com", "This is a test email!");
        System.out.println("Done!");
    }
}
