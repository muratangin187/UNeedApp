package com.example.uneed.structures;


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

    public int getId()
    {
        return id;
    }

    public int getSeller_id()
    {
        return seller_id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPhoto()
    {
        return photo;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getCategory_id()
    {
        return category_id;
    }

    public void setCategory_id(int category_id)
    {
        this.category_id = category_id;
    }

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
