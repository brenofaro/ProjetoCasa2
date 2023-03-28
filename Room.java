import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.

    private List<Item> items = new ArrayList<>();

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public void addItem(Item item){
        items.add(item);
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    public String objectHasKey(Item item){
        if (item.getKey() != null){
            return String.format("\033[32mencontra a %s no objeto\033[m", KeyFormatter.keyFormat(item.getKey()));
        }else {
            return "\033[31mnão encontra nenhuma chave\033[m";
        }
    }

    public boolean existObject(String itemStr){
        for (Item item : items){
            if (item.getName().equals(itemStr)){
                return true;
            }
        }
        return false;
    }

    public Item getObject(String itemStr){
        Item tempItem = null;
        for (Item item1 : items) {
            if (item1.getName().equals(itemStr)) {
                tempItem = item1;
            }
        }
        return tempItem;
    }

    public boolean itemHasKeyBool(Item item) {
        return item.hasKey();
    }

    public Chave getObjectKey(Item item) {
        return item.getKey();
    }

    public void removeObjKey(Item item){
        item.removeKey();
    }


}

