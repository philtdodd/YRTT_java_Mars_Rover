package mars.rover;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Planet mars = new Planet("Mars", 227940000L);

        Scanner inout = new Scanner(System.in);
        String command;

        System.out.println("Send Command");
        do {
            System.out.print("> ");

            command = inout.nextLine();

            if (!command.matches("Q")) {
                String result = mars.receivedCommand(command);
                if (!result.matches(""))
                    System.out.println(result);
            }
        } while (!command.contains("Q"));
    }
}