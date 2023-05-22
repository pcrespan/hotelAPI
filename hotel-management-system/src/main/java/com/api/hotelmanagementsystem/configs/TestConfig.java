package com.api.hotelmanagementsystem.configs;

import com.api.hotelmanagementsystem.entities.Guest;
import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.enums.RoomStatus;
import com.api.hotelmanagementsystem.repositories.GuestRepository;
import com.api.hotelmanagementsystem.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {
        Guest g1 = new Guest(null, "John Doe", "9999999");
        Guest g2 = new Guest(null, "Jane Doe", "9999111");

        guestRepository.saveAll(Arrays.asList(g1, g2));

        Room r1 = new Room(null, "123", RoomStatus.FREE);
        Room r2 = new Room(null, "111", RoomStatus.OCCUPIED);
        Room r3 = new Room(null, "112", RoomStatus.FREE);

        roomRepository.saveAll(Arrays.asList(r1, r2, r3));
    }
}
