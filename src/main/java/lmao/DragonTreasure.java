package lmao;

import java.util.ArrayList;

public class DragonTreasure {
    public static ArrayList<Room> setupGame(){
        Room room1 = new Room("hejsan", "this is the first room to this forsaken dungeon");
        Room room2 = new Room("Room 2", "this room is a bit darker than the first one");
        Room room3 = new Room("Room 3", "you feel a chill down your spine as you enter this room");
        Room room4 = new Room("Room 4", "this room has some weird markings on the wall");
        Room room5 = new Room("Room 5", "cant enter this room xD");
        Room room6 = new Room("Room 6", "you begin to feel a bit uneasy as you enter this room");
        Room room7 = new Room("Room 7", "you see a light at the end of this room");
        Room room8 = new Room("Room 8", "you won the game!");
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        rooms.add(room6);
        rooms.add(room7);
        rooms.add(room8);

        Door door1 = new Door("Door 1",  false, room2, "N");
        Door door2 = new Door("Door 2", false, room4, "E");
        room1.addDoor(door1, door2);

        Door door3 = new Door("Door 3", false, room1, "S");
        Door door4 = new Door("Door 4", false, room3, "N");
        room2.addDoor(door3, door4);

        Door door5 = new Door("Door 5",false, room2, "S");
        room3.addDoor(door5);

        Door door6 = new Door("Door 6", false, room1, "W");
        Door door7 = new Door("Door 7",  false, room6, "S");
        Door door8 = new Door("Door 8", true, room5, "E");
        room4.addDoor(door6, door7, door8);


        Door door9 = new Door("Door 9", false, room4, "W");
        room5.addDoor(door9);

        Door door10 = new Door("Door 10",  false, room4, "N");
        Door door11 = new Door("Door 11",  false, room7, "S");
        room6.addDoor(door10, door11);

        Door door12 = new Door("Door 12",  false, room6, "N");
        Door door13 = new Door("Door 13",  false, room8, "S");
        room7.addDoor(door12, door13);

        Door door14 = new Door("Door 14",  false, room7, "N");
        room8.addDoor(door14);

        for (Room room : rooms) {
            room.addDescriptionToRoom();
        }



        return rooms;

    }
}
