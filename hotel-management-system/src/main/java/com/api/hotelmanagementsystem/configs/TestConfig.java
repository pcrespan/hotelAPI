package com.api.hotelmanagementsystem.configs;

import com.api.hotelmanagementsystem.entities.*;
import com.api.hotelmanagementsystem.entities.enums.EmployeeStatus;
import com.api.hotelmanagementsystem.entities.enums.RoleName;
import com.api.hotelmanagementsystem.repositories.*;
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

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Guest g1 = new Guest(null, "John Doe", "9999999");
        Guest g2 = new Guest(null, "Jane Doe", "9999111");
        Guest g3 = new Guest(null, "Indiana Jones", "8888888");

        guestRepository.saveAll(Arrays.asList(g1, g2, g3));

        Room r1 = new Room(null, RoomStatus.FREE);
        Room r2 = new Room(null, RoomStatus.OCCUPIED);
        Room r3 = new Room(null, RoomStatus.FREE);
        Room r4 = new Room(null, RoomStatus.FREE);

        roomRepository.saveAll(Arrays.asList(r1, r2, r3, r4));

        Stay s1 = new Stay(g1, r1, Date.valueOf("2023-05-22"), Date.valueOf("2023-05-25"));
        Stay s2 = new Stay(g2, r2, Date.valueOf("2023-05-25"), Date.valueOf("2023-05-26"));
        Stay s3 = new Stay(g3, r3, Date.valueOf("2023-05-26"), Date.valueOf("2023-05-27"));

        stayRepository.saveAll(Arrays.asList(s1, s2, s3));

        Role rol1 = new Role(null, "Receptionist", RoleName.RECEPTIONIST);
        Role rol2 = new Role(null, "Salesman", RoleName.SALESMAN);
        Role rol3 = new Role(null, "Temp", RoleName.TEMP);
        Role rol4 = new Role(null, "Regional manager", RoleName.REGIONAL_MANAGER);
        Role rol5 = new Role(null, "Human resources", RoleName.HUMAN_RESOURCES);

        roleRepository.saveAll(Arrays.asList(rol1, rol2, rol3, rol4, rol5));

        Employee e1 = new Employee(null, "Pam Beesly", EmployeeStatus.ACTIVE, "97485170363");
        Employee e2 = new Employee(null, "Dwight Schrute", EmployeeStatus.ACTIVE, "94612013856");
        Employee e3 = new Employee(null, "Jim Halpert", EmployeeStatus.ACTIVE, "51936204756");
        Employee e4 = new Employee(null, "Ryan Howard", EmployeeStatus.ACTIVE, "89153672919");
        Employee e5 = new Employee(null, "Andy Bernard", EmployeeStatus.ACTIVE, "17293485701");
        Employee e6 = new Employee(null, "Michael Scott", EmployeeStatus.ACTIVE, "90281294586");
        Employee e7 = new Employee(null, "Toby Flenderson", EmployeeStatus.ACTIVE, "57289120432");

        employeeRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7));

        Sector sec1 = new Sector(null, "Reception", "Answers calls and schedules appointments");
        Sector sec2 = new Sector(null, "Human Resources", "Solves conflicts between people");
        Sector sec3 = new Sector(null, "Sales", "Establishes contact between hotel and clients");

        sectorRepository.saveAll(Arrays.asList(sec1, sec2, sec3));

        Contract c1 = new Contract(e1, sec1, 2000.0, Date.valueOf("2023-05-22"), rol1);
        Contract c2 = new Contract(e2, sec3, 7000.0, Date.valueOf("1999-03-12"), rol2);
        Contract c3 = new Contract(e3, sec3, 5000.0, Date.valueOf("2005-02-17"), rol2);
        Contract c4 = new Contract(e4, sec3, 2000.0, Date.valueOf("2012-09-30"), rol3);
        Contract c5 = new Contract(e5, sec3, 4500.0, Date.valueOf("2003-06-23"), rol2);
        Contract c6 = new Contract(e6, sec3, 7500.0, Date.valueOf("1990-04-12"), rol4);
        Contract c7 = new Contract(e7, sec2, 4000.0, Date.valueOf("1995-04-12"), rol5);

        contractRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));
    }
}