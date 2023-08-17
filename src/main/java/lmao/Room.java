package lmao;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Room {
    private String name;
    private String description;
    private ArrayList<Door> doors; // lista med dörrar som finns i rummet
    private boolean treasure;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.doors = new ArrayList<Door>();
    }
    public Room(String name, String description, boolean treasure) {
        this.name = name;
        this.description = description;
        this.doors = new ArrayList<Door>();
        this.treasure = treasure;
    }
    public void addDescriptionToRoom(){ // lägger till beskrivning av rummets dörrar i rummets beskrivning och om de är låsta eller inte
        this.description +="\n";
        for (int i = 0; i < doors.size(); i++) {
            this.description += "There is a " + returnStringLocked(i) + " Door to the " + doors.get(i).getDirection() + "\n";
        }
    }
    private String returnStringLocked(int i){ // returnerar en sträng som säger om dörren är låst eller inte, används i addDescriptionToRoom metoden
        if(doors.get(i).getLocked()){
            return "Locked";
        }
        else{
            return "Unlocked";
        }
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public void addDoor(Door door) { // lägger till en dörr i ett rum och kollar om det redan finns en dörr i den riktningen
        if (doors.size() == 0) {
            doors.add(door);
        } else {
            for (int i = 0; i < doors.size(); i++) {
                if (doors.get(i).getDirection() == door.getDirection()) {
                    throw new InputMismatchException("There is already a door in that direction");
                } else {
                    doors.add(door);
                }
            }
        }

    }

    public void addDoor(Door door, Door door2) { // lägger till två dörrar i ett rum och kollar om det redan finns en dörr i den riktningen
                                                //samt att de inte har samma riktning
        if (doors.size() == 0 && door.getDirection() != door2.getDirection()) {
            doors.add(door);
            doors.add(door2);
        } else if (doors.size() == 0 && door.getDirection() == door2.getDirection()) {
            throw new InputMismatchException("The Two Doors Added Have The Same Direction");
        } else {
            for (int i = 0; i < doors.size(); i++) {
                if (doors.get(i).getDirection() == door.getDirection()) {
                    throw new InputMismatchException("There is already a door in that direction");
                } else {
                    doors.add(door);
                    doors.add(door2);
                }
            }
        }

    }

    public void addDoor(Door door, Door door2, Door door3) {
        if (doors.size() == 0) {    // kollar om man lägger in 3 dörrar i ett rum så att de inte har samma riktning om listan från början är tom
            Door[] doors = {door, door2, door3};
            for (int i = 0; i < doors.length; i++) {
                for (int j = 0; j < doors.length; j++) {
                    if (doors[i].getDirection() == doors[j].getDirection() && i != j) {
                        throw new InputMismatchException("Atleast two of the doors added have the same direction");
                    }
                }
            }
            this.doors.add(door);
            this.doors.add(door2);
            this.doors.add(door3);

        } else {
            for (int i = 0; i < doors.size(); i++) {
                if (doors.get(i).getDirection() == door.getDirection()) {
                    throw new InputMismatchException("There is already a door in that direction");
                } else {
                    doors.add(door);
                    doors.add(door2);
                    doors.add(door3);
                }
            }
        }

    }

    public ArrayList<Door> getDoors() {
        return doors;
    }

    public Door checkDoorsDirection(String input) { // kollar om det finns en dörr i den riktningen returnerar dörren
        for (int i = 0; i < doors.size(); i++) {
            if (doors.get(i).getDirection().equals(input)) {
                return doors.get(i);
            }
        }
        return null;
    }
    public boolean checkDoors(String input) {// kollar om det finns en dörr i den riktningen returnerar true om det finns en dörr
        for (int i = 0; i < doors.size(); i++) {
            if (doors.get(i).getDirection().equals(input)) {
                return true;
            }
        }
        return false;
    }


    public boolean checkLocked(String input) { // kollar om dörren i den riktningen är låst
        for (int i = 0; i < doors.size(); i++) {
            if (doors.get(i).getDirection().equals(input)) {
                return doors.get(i).getLocked();
            }
        }
        return false;
    }
    public void printChest(){ // skriver ut en kista, kanske inte är klassen "room" som ska göra det men det var enklast så
        System.out.println("You peek through the lock and see a chest full of gold" +
                " \"                  _.--.\\n\"+\n" +
                "            \"              _.-'_:-'||\\n\"+\n" +
                "            \"          _.-'_.-::::'||\\n\"+\n" +
                "            \"     _.-:'_.-::::::'  ||\\n\"+\n" +
                "            \"   .'`-.-:::::::'     ||\\n\"+\n" +
                "            \"  /.'`;|:::::::'      ||_\\n\"+\n" +
                "            \" ||   ||::::::'      _.;._'-._\\n\"+\n" +
                "            \" ||   ||:::::'   _.-!oo @.!-._'-.\\n\"+\n" +
                "            \" \\'.  ||:::::.-!() oo @!()@.-'_.||\\n\"+\n" +
                "            \"   '.'-;|:.-'.&$@.& ()$%-'o.'\\\\U||\\n\"+\n" +
                "            \"     `>'-.!@%()@'@_%-'_.-o _.|'||\\n\"+\n" +
                "            \"      ||-._'-.@.-'_.-' _.-o  |'||\\n\"+\n" +
                "            \"      ||=[ '-._.-\\\\U/.-'    o |'||\\n\"+\n" +
                "            \"      || '-.]=|| |'|      o  |'||\\n\"+\n" +
                "            \"      ||      || |'|        _| ';\\n\"+\n" +
                "            \"      ||      || |'|    _.-'_.-'\\n\"+\n" +
                "            \"      |'-._   || |'|_.-'_.-'\\n\"+\n" +
                "            \"      '-._'-.|| |' `_.-'\\n\"+\n" +
                "            \"           '-.||_/.-'\\n\");");
    }
}
