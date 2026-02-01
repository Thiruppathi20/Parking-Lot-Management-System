package com.parking.bean;

import java.sql.Timestamp;

public class Ticket {

    private int ticketID;
    private String slotID;
    private String vehicleNumber;
    private Timestamp entryTime;
    private Timestamp exitTime;
    private double charges;
    private String status;

    public int getTicketID() { return ticketID; }
    public void setTicketID(int ticketID) { this.ticketID = ticketID; }

    public String getSlotID() { return slotID; }
    public void setSlotID(String slotID) { this.slotID = slotID; }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public Timestamp getEntryTime() { return entryTime; }
    public void setEntryTime(Timestamp entryTime) { this.entryTime = entryTime; }

    public Timestamp getExitTime() { return exitTime; }
    public void setExitTime(Timestamp exitTime) { this.exitTime = exitTime; }

    public double getCharges() { return charges; }
    public void setCharges(double charges) { this.charges = charges; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
