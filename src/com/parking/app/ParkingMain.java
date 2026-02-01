package com.parking.app;

import java.sql.Timestamp;  
import com.parking.service.ParkingService;

public class ParkingMain {

    public static void main(String[] args) {

        ParkingService service = new ParkingService();

        try {
            boolean r1 = service.parkVehicle(
                "S001",
                "TN01AB1234",
                new Timestamp(System.currentTimeMillis())
            );
            System.out.println(r1 ? "VEHICLE PARKED" : "FAILED");

            boolean r2 = service.exitVehicle(
                11001,
                new Timestamp(System.currentTimeMillis())
            );
            System.out.println(r2 ? "VEHICLE EXITED" : "FAILED");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
