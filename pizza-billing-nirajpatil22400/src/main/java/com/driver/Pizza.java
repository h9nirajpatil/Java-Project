package com.driver;

public class Pizza {

    private int price;
    private Boolean isVeg;
    private String bill;

    boolean extraCheese;
    boolean extraToppings;
    boolean takeaway;
    boolean billGenerated;

    private int base ;
    private int cheese;
    private int toppings;


    public Pizza(Boolean isVeg){

        this.isVeg = isVeg;
        // your code goes here
        this.extraCheese=false;
        this.extraToppings=false;
        this.takeaway = false;
        this.billGenerated = false;
        this.bill="";
        if(isVeg==true){
            this.price = 300;
            this.toppings= 70;
        }
        else{
            this.price = 400;
            this.toppings=120;
        }
        this.cheese=80;
        this.bill+="Base Price Of The Pizza: " + this.price +"\n" ;
    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese(){
        // your code goes here
        if(!extraCheese){
            this.price += cheese;
            extraCheese=true;
        }
    }

    public void addExtraToppings(){
        // your code goes here
        if(!extraToppings){
            this.price = this.price + toppings;
            extraToppings=true;
        }
    }

    public void addTakeaway(){
        // your code goes here
        if(!takeaway){
            this.price+=20;
            takeaway=true;
        }


    }

    public String getBill(){
        // your code goes here
        if(!billGenerated){
            if(extraCheese)
                this.bill += "Extra Cheese Added: " + this.cheese +"\n";
            if(extraToppings)
                this.bill+="Extra Toppings Added: " + this.toppings+ "\n";
            if(takeaway)
                this.bill+="Paperbag Added: " +"20"+ "\n";
            this.bill+="Total Price: " + this.price+"\n";
            billGenerated=true;
        }
        return this.bill;
    }
}