package dev.nokore;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ChatBot {
    private Map<String, String> responses;

    public ChatBot() {
        responses = new HashMap<>();
        loadResponses();
    }

    public void showWelcomeMessage() {
        System.out.println("*** Hi, I am Nokore, How Can I Help You? ****");
    }

    public String getResponse(String userInput) {
        if (responses.containsKey(userInput)) {
            return responses.get(userInput);
        } else if (userInput.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
        return null;
    }

    public void learnResponse(String userInput, String response) {
        responses.put(userInput, response);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/brain/brain.txt", true));
            writer.write(userInput + "|" + response);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadResponses() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/brain/brain.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    responses.put(parts[0], parts[1]);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
