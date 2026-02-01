package com.parking.util;

public class ParkingFullException extends Exception {
    public String toString() {
        return "Parking Full: Slot not available";
    }
}
