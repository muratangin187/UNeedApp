package com.example.uneed.structures;

/**
 * This class creates a spesific user 
 * with specific name and id
 * @author fistikci_sahap
 * @version 1.0
 */
public class User
{

    private int id;
    private String username;
    private String email;
    private String password;

    /**
     * Constructor
     * @param id
     * @param username
     * @param email
     * @param password
     */
    public User(int id, String username, String email, String password)
    {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * @return int ID
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * @return String username
     */
    public String getUsername()
    {
        return username;
    }
    
    /** 
     * @return String email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * @return String password
     */
    public String getPassword()
    {
        return password;
    }
}
