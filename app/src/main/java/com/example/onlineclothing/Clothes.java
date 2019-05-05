package com.example.onlineclothing;

class Clothes {
    private String itemName;
    private String price;
    private String itemDescription;
    private int image;

    public Clothes(String itemName, String price, String itemDescription, int image) {
        this.itemName = itemName;
        this.price = price;
        this.itemDescription = itemDescription;
        this.image = image;
    }

    public int getImage() {
        if(this.itemName.equals("pant")||this.itemName.equals("Pant"))
        {
            return R.drawable.pant;
        }
        else if (this.itemName.equals("shirt")||this.itemName.equals("Shirt")||this.itemName.equals("t-shirt")||this.itemName.equals("T-Shirt"))
        {
            return R.drawable.noavatar;
        }
        else {
            return R.drawable.m;
        }
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
