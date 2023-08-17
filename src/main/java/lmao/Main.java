package lmao;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static lmao.DragonTreasure.setupGame;

public class Main {
    private static Room currentRoom;
    private static String WelcomeMessage = "Welcome to the game!";


    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        System.out.println(WelcomeMessage);
        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Player player = new Player(name);
        System.out.println("Hello " + player.getName());
        playGame(); // kallar playGame metoden

    }

    public static void playGame(){
        ArrayList<Room> rooms = setupGame(); // kallar på setupGame metoden i DragonTreasure som returnerar en ArrayList med rum
        currentRoom = rooms.get(0);// sätter currentRoom till det första rummet i listan
        System.out.println("You move around with the commands: N, S, E, W");
        System.out.println(currentRoom.getDescription());// skriver ut beskrivningen av rummet
        boolean inGame = true;
        Scanner scanner = new Scanner(System.in);
        while (inGame){
            String input = scanner.nextLine();
            userInput(input);// kallar på userInput metoden som tar hand om inputen
            checkWin();//kollar om spelaren har nått sista rummet och vunnit

        }
    }
    public static void checkWin(){
        if (currentRoom.getName().equals("Room 8")){
            System.out.println("You have won the game");
            System.exit(0);
        }
    }

    public static void userInput(String input) {
        if (currentRoom.checkDoors(input)) {// kollar om det finns en dörr i den riktningen som spelaren skrivit in
            if (currentRoom.checkLocked(input)) {// kollar om dörren är låst, om den är det så är det så printar den ut att dörren är låst och att det finns en kista i rummet
                System.out.println("The door is locked");
                currentRoom.printChest();//eftersom vi inte har några "items" i denna version så vet vi att det skall printas ut en skista när spelaren når
                // ett låst rum
                System.out.println(currentRoom.getDescription());
            } else {
                currentRoom = currentRoom.checkDoorsDirection(input).getLeadsTo();// sätter currentRoom till det rum som dörren leder till och skriver ut beskrivningen av rummet
                System.out.println(currentRoom.getDescription());
            }
        }
        else if(Objects.equals(input, "quit")){// om spelaren skriver quit så avslutas spelet
            System.out.println("You have quit the game");
            System.exit(0);
        }
        else{
            System.out.println("You can't go that way");
        }
        }

}

