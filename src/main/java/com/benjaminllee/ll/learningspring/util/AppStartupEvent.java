package com.benjaminllee.ll.learningspring.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.benjaminllee.ll.learningspring.data.GuestRepository;
import com.benjaminllee.ll.learningspring.data.ReservationRepository;
import com.benjaminllee.ll.learningspring.data.RoomRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;


    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    private <T, ID> void findAllAndPrintAll(CrudRepository<T, ID> repository) {
        Iterable<T> entities = repository.findAll();
        printAll(entities);
    }

    private <T> void printAll(Iterable<T> iterable) {
        iterable.forEach(System.out::println);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        findAllAndPrintAll(this.roomRepository);
        findAllAndPrintAll(this.guestRepository);
        findAllAndPrintAll(this.reservationRepository);

        System.out.println("Printing all reservations for 2022-01-01");
        printAll(reservationRepository.findByResDate(Date.valueOf("2022-01-01")));
        System.out.println("Printing all reservations for 2018-05-05");
        printAll(reservationRepository.findByResDate(Date.valueOf("2018-05-05")));
    }
}
