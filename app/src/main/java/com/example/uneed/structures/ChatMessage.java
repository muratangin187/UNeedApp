package com.example.uneed.structures;


public class ChatMessage {
    public boolean left;
    public int id;
    public String message;
    public String date;
    public int from_id;
    public int to_id;

    public ChatMessage(String message, String date, int from_id, int to_id) {
        super();
        this.message = message;
        this.date = date;
        this.from_id = from_id;
        this.to_id = to_id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setLeft(boolean left)
    {
        this.left = left;
    }
}