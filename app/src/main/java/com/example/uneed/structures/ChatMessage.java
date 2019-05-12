package com.example.uneed.structures;

/**
 * This class is the chatmessages between users
 * @author fistikci_sahap
 * @version 2.0
 */
public class ChatMessage {
    public boolean left;
    public int id;
    public String message;
    public String date;
    public int from_id;
    public int to_id;

    /**
     * @param message
     * @param date
     * @param from_id
     * @param to_id
     */
    public ChatMessage(String message, String date, int from_id, int to_id) {
        //super();
        this.message = message;
        this.date = date;
        this.from_id = from_id;
        this.to_id = to_id;
    }
    /**
     * Sets id to given id
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Sets the ocation of the messages to the entered boolean
     * @param left
     */
    public void setLeft(boolean left)
    {
        this.left = left;
    }
}