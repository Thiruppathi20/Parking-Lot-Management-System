package com.parking.util;

public class ActiveTicketException extends Exception {
    public String toString() {
        return "Active Ticket Exists: Cannot remove slot";
    }
}
