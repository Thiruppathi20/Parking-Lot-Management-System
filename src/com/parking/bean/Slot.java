package com.parking.bean;

public class Slot {

    private String slotID;
    private String slotType;
    private int capacity;
    private int occupiedCount;
    private String status;

    public String getSlotID() { return slotID; }
    public void setSlotID(String slotID) { this.slotID = slotID; }

    public String getSlotType() { return slotType; }
    public void setSlotType(String slotType) { this.slotType = slotType; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getOccupiedCount() { return occupiedCount; }
    public void setOccupiedCount(int occupiedCount) { this.occupiedCount = occupiedCount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
