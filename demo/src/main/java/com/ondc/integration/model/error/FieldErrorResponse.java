package com.ondc.integration.model.error;

import java.util.ArrayList;
import java.util.List;

public class FieldErrorResponse {

	private List<Message> messageList;

    public List<Message> getMessageList() {
        if (null == messageList) {
            return new ArrayList<>();
        } else {
            return new ArrayList<>(messageList);
        }
    }
    
    public void setMessageList(List<Message> messageList) {
        if (null == messageList) {
            this.messageList = null;
        } else {
            this.messageList = new ArrayList<>(messageList);
        }
    }

}
