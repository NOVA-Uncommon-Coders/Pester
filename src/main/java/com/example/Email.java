package com.example;

/**
 * Created by Eric on 4/13/17.
 */
public class Email {

    //do i need to make an email class when there is already a MailSender class?

    String recipient;
    String sender;
    String title;
    String body;


    public Email() {
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
