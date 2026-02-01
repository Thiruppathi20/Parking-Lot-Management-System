package com.parking.service;

import java.sql.Timestamp;
import com.parking.bean.*;
import com.parking.dao.*;
import com.parking.util.*;

public class ParkingService {

    SlotDAO slotDAO = new SlotDAO();
    TicketDAO ticketDAO = new TicketDAO();

    public boolean parkVehicle(String slotID, String vehicle, Timestamp time)
            throws Exception {

        if (slotID == null || vehicle == null)
            throw new ValidationException();

        Slot slot = slotDAO.findSlot(slotID);
        if (slot == null) return false;

        if (slot.getOccupiedCount() >= slot.getCapacity())
            throw new ParkingFullException();

        slotDAO.updateOccupiedCount(slotID, slot.getOccupiedCount() + 1);

        Ticket t = new Ticket();
        t.setTicketID(ticketDAO.generateTicketID());
        t.setSlotID(slotID);
        t.setVehicleNumber(vehicle);
        t.setEntryTime(time);

        return ticketDAO.recordTicket(t);
    }

    public boolean exitVehicle(int ticketID, Timestamp exitTime)
            throws Exception {

        double charges = 50.0; // flat charge
        return ticketDAO.closeTicket(ticketID, charges, exitTime);
    }
}
