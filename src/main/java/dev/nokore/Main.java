package dev.nokore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChatBot bot = new ChatBot();
        bot.showWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        String userInput;

        do {
            System.out.print("[You] : ");
            userInput = scanner.nextLine();

            if (!userInput.equalsIgnoreCase("x")) {
                String response = bot.getResponse(userInput);
                if (response != null) {
                    System.out.println("[Nokore]: " + response);
                } else {
                    System.out.print("Not Found! Tell me what to enter for " + userInput + " : ");
                    String learningResponse = scanner.nextLine();
                    bot.learnResponse(userInput, learningResponse);
                }
            }
        } while (!userInput.equalsIgnoreCase("x"));
    }
}