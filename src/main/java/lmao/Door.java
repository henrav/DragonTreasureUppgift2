package lmao;

public class Door   {
    private String name;
    private String description;
    private boolean locked;
    private Room leadsTo; // vilket rum dörren leder till

    private String direction;

    public Door (String name, boolean locked, Room leadsTo, String direction) {
        this.name = name;
        this.locked = locked;
        this.leadsTo = leadsTo;
        this.direction = direction;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Room getLeadsTo() {
        return leadsTo;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setLeadsTo(Room leadsTo) {
        this.leadsTo = leadsTo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description= description;
    }


    public boolean checkLocked() {
        return locked;
    }
}
