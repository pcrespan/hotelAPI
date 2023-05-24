package com.api.hotelmanagementsystem.configs;

import com.api.hotelmanagementsystem.entities.Guest;
import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.entities.Stay;
import com.api.hotelmanagementsystem.repositories.GuestRepository;
import com.api.hotelmanagementsystem.repositories.RoomRepository;
import com.api.hotelmanagementsystem.repositories.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.api.hotelmanagementsystem.entities.enums.RoomStatus;

import java.sql.Date;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private StayRepository stayRepository;

    @Override
    public void run(String... args) throws Exception {
        Guest g1 = new Guest(null, "John Doe", "9999999");
        Guest g2 = new Guest(null, "Jane Doe", "9999111");
        Guest g3 = new Guest(null, "Indiana Jones", "8888888");

        guestRepository.saveAll(Arrays.asList(g1, g2, g3));

        Room r1 = new Room(null, "123", RoomStatus.FREE);
        Room r2 = new Room(null, "111", RoomStatus.OCCUPIED);
        Room r3 = new Room(null, "112", RoomStatus.FREE);
        Room r4 = new Room(null, "113", RoomStatus.FREE);

        roomRepository.saveAll(Arrays.asList(r1, r2, r3, r4));

        Stay s1 = new Stay(g1, r1, Date.valueOf("2023-05-22"), Date.valueOf("2023-05-25"));
        Stay s2 = new Stay(g2, r2, Date.valueOf("2023-05-25"), Date.valueOf("2023-05-26"));
        Stay s3 = new Stay(g3, r3, Date.valueOf("2023-05-26"), Date.valueOf("2023-05-27"));

        stayRepository.saveAll(Arrays.asList(s1, s2, s3));
    }
}