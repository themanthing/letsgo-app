package ru.mobilesoft.piligram.events;

/**
 * Created on 8/10/17.
 */

public class MessageEvent {

    private String action;

    public MessageEvent(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
