package com.benjaminllee.ll.learningspring.data;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="RESERVATION_ID")
    private long reservationId;

    @Column(name="ROOM_ID")
    private BigInteger roomId;

    @Column(name="GUEST_ID")
    private BigInteger guestId;

    @Temporal(TemporalType.DATE)
    @Column(name="RES_DATE")
    private Date resDate;

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public BigInteger getRoomId() {
        return roomId;
    }

    public void setRoomId(BigInteger roomId) {
        this.roomId = roomId;
    }

    public BigInteger getGuestId() {
        return guestId;
    }

    public void setGuestId(BigInteger guestId) {
        this.guestId = guestId;
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }

    @Override
    public String toString() {
        return "Reservation [reservationId=" + reservationId + ", roomId=" + roomId + ", guestId=" + guestId + ", resDate="
                + resDate + "]";
    }
}
