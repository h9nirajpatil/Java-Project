package com.driver;

import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.Date;

class Emailformate {
    Date date;
    String sender;
    String message;

    public Emailformate(Date date, String sender, String message) {
        this.date = date;
        this.sender = sender;
        this.message = message;
    }
}

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)

    ArrayList<Emailformate> Inbox;
    ArrayList<Emailformate> Trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;

        /* Option 2 Inbox & Trash has been initialized */
        Inbox = new ArrayList<>();
        Trash = new ArrayList<>();

    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

        if(Inbox.size() == inboxCapacity){
            //Get the firstEmailTemplate
            Emailformate emailTemplate = Inbox.get(0);
            Inbox.remove(0); //remove it from Inbox
            Trash.add(emailTemplate); //add to trash
        }
        //add latest email
        Emailformate emailTemplate = new Emailformate(date, sender , message);
        Inbox.add(emailTemplate);

    }

    public void deleteMail(String message){
        //We have an arrayList of emailTemplate, Find its index : matching message with emailTemplate message
        Emailformate emailTemplate = null;
        for(int i=0; i<Inbox.size(); i++){
            Emailformate emailTemplate1 = Inbox.get(i);
            if(emailTemplate1.message.equals(message)){
                emailTemplate = emailTemplate1;
                break;
            }
        }
        if(emailTemplate != null){
            Inbox.remove(emailTemplate);
            Trash.add(emailTemplate);
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(Inbox.isEmpty()){
            return null;
        }


        Emailformate emailTemplate = Inbox.get(Inbox.size() - 1);
        return emailTemplate.message;
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox

        if(Inbox.isEmpty()){
            return null;
        }

        Emailformate emailTemplate = Inbox.get(0);
        return emailTemplate.message;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count = 0;
        for(int i=0; i<Inbox.size(); i++){
            Emailformate emailTemplate = Inbox.get(i);
            //Compare the Date
            if((emailTemplate.date.compareTo(start) >= 0) && (emailTemplate.date.compareTo(end) <= 0)){
                count++;
            }
        }
        return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return Inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return Trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        Trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}