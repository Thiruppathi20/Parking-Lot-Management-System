package com.parking.dao;
import java.sql.*;
import com.parking.bean.Ticket;
import com.parking.util.DBUtil;

public class TicketDAO {

    public int generateTicketID() {
        return (int)(Math.random() * 100000);
    }

    public boolean recordTicket(Ticket t) throws Exception {
        Connection con = DBUtil.getDBConnection();
        PreparedStatement ps =
            con.prepareStatement("INSERT INTO TICKET_TBL VALUES (?,?,?,?,?,?,?)");

        ps.setInt(1, t.getTicketID());
        ps.setString(2, t.getSlotID());
        ps.setString(3, t.getVehicleNumber());
        ps.setTimestamp(4, t.getEntryTime());
        ps.setTimestamp(5, null);
        ps.setDouble(6, 0);
        ps.setString(7, "ACTIVE");

        return ps.executeUpdate() > 0;
    }

    public boolean closeTicket(int id, double charges, Timestamp exitTime) throws Exception {
        Connection con = DBUtil.getDBConnection();
        PreparedStatement ps =
            con.prepareStatement(
              "UPDATE TICKET_TBL SET EXIT_TIME=?, CHARGES=?, STATUS='CLOSED' WHERE TICKET_ID=?");

        ps.setTimestamp(1, exitTime);
        ps.setDouble(2, charges);
        ps.setInt(3, id);

        return ps.executeUpdate() > 0;
    }
}
