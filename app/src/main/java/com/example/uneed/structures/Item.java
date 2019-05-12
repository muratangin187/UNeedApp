package com.example.uneed.structures;


/**
 * This class creates items 
 * @author fistikci_sahap
 * @version 1.0
 */
public class Item
{
    private int id;
    private int seller_id;
    private String title;
    private String photo;
    private double price;
    private String description;
    private int category_id;
    private String date;


    /**
     * @param id
     * @param seller_id
     * @param title
     * @param photo
     * @param price
     * @param description
     * @param category_id
     * @param date
     */
    public Item(int id, int seller_id, String title, String photo, float price, String description, int category_id, String date)
    {
        this.id = id;
        this.seller_id = seller_id;
        this.title = title;
        this.photo = photo;
        this.price = price;
        this.description = description;
        this.category_id = category_id;
        this.date = date;
    }

    /**
     * @return int ID of the item
     */
    public int getId()
    {
        return id;
    }

    /**
     * @return int ID of the seller
     */
    public int getSeller_id()
    {
        return seller_id;
    }

    /**
     * @return String title of the item
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets item title to title
     * @param title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * @return String photo of the item by bytecode
     */
    public String getPhoto()
    {
        return photo;
    }

    /**
     * Sets String photo to parameter photo
     * @param photo
     */
    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    /**
     * @return double price of the item
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * Sets price to parameter price
     * @param price
     */
    public void setPrice(float price)
    {
        this.price = price;
    }

    /**
     * @return String description of the item
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Sets description to entered description
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    /**
     * @return int category_id
     */
    public int getCategory_id()
    {
        return category_id;
    }
    
    /**
     * Set category_id to given category_id
     * @param category_id
     */
    public void setCategory_id(int category_id)
    {
        this.category_id = category_id;
    }

    /**
     * @return String date of the item
     */
    public String getDate()
    {
        return date;
    }

    @Override
    public String toString()
    {
        String result = "";
        result += "Item Id " + getId();
        result += "\n";
        result += "Item Seller Id " +getSeller_id();
        result += "\n";
        result += "Item Title " + getTitle();
        result += "\n";
        result += "Item Photo URL " + getPhoto();
        result += "\n";
        result += "Item Price " + getPrice();
        result += "\n";
        result += "Item Description: " + getDescription();
        result += "\n";
        result += "Item Category Id" + getCategory_id();
        result += "\n";
        result += "Item Date " + getDate();
        result += "\n";
        return result;
    }

}
