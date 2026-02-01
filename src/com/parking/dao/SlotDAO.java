package com.parking.dao;

import java.sql.*;
import java.util.*;
import com.parking.bean.Slot;
import com.parking.util.DBUtil;

public class SlotDAO {

    public Slot findSlot(String slotID) throws Exception {
        Connection con = DBUtil.getDBConnection();
        PreparedStatement ps =
            con.prepareStatement("SELECT * FROM SLOT_TBL WHERE SLOT_ID=?");

        ps.setString(1, slotID);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Slot s = new Slot();
            s.setSlotID(rs.getString(1));
            s.setSlotType(rs.getString(2));
            s.setCapacity(rs.getInt(3));
            s.setOccupiedCount(rs.getInt(4));
            s.setStatus(rs.getString(5));
            return s;
        }
        return null;
    }

    public boolean updateOccupiedCount(String slotID, int count) throws Exception {
        Connection con = DBUtil.getDBConnection();
        PreparedStatement ps =
            con.prepareStatement(
              "UPDATE SLOT_TBL SET OCCUPIED_COUNT=?, STATUS=? WHERE SLOT_ID=?");

        ps.setInt(1, count);
        ps.setString(2, count == 0 ? "AVAILABLE" : "UNAVAILABLE");
        ps.setString(3, slotID);

        return ps.executeUpdate() > 0;
    }
}
