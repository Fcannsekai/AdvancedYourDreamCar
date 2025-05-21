package com.dreamcar.ui;

public class Main {
    public static void main(String[] args) {

        showStartupAnimation();

        UserInterface ui = new UserInterface();
        ui.display();
    }

    public static void showStartupAnimation() {
        clearScreen();

        // Title with ANSI color
        String title = "\033[1;35m💀 Welcome to the Grave Digger Garage 💀\033[0m";
        for (char c : title.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n");

        System.out.print("Summoning Grave Digger");
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println("\n");

        // Monster truck: Grave Digger style
        String[] truck = {
                "\033[1;32m           _________",
                "   ______/__|__|__|__\\_____",
                "  |🟣Grave Digger🟣🔥🔥🔥       |",
                "  '---(O)-----------(O)---'\033[0m"
        };

        // Victim car
        String[] tinyCar = {
                "      ____",
                " ___/____\\___",
                "|   O    O   |"
        };

        String road = "\033[1;90m━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\033[0m";

        // Animation: Truck drives across screen
        for (int i = 0; i < 50; i++) {
            clearScreen();

            System.out.println(title + "\n");

            // Position target car at frame 25
            if (i == 25) {
                for (String line : tinyCar) {
                    System.out.println(" ".repeat(i) + line);
                }
            }

            for (String line : truck) {
                System.out.println(" ".repeat(i) + line);
            }

            System.out.println(" ".repeat(i) + road);

            // Play CRUSH sound and effect
            if (i == 27) {
                System.out.print("\007"); // system beep!
                System.out.println("\n\033[1;31m💥 CRUNCH! 💥 Grave Digger smashes the car!\033[0m");
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            try {
                Thread.sleep(35);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n\033[1;32m🚀 Monster ready. Let’s crush some deals.\033[0m\n");
    }

    // Clear the terminal screen (ANSI-compatible terminals)
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}