package com.ondc.integration.model.error;

public class Message {
    
    private MessageType type;
    private String text;

    public Message(){
    	
    }
    public Message(MessageType type, String text) {
        this.type = type;
        this.text = text;
    }
    
    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }   
}