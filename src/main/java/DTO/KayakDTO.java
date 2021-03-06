package DTO;

import entities.BookingDate;
import entities.Image;
import entities.Kayak;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class KayakDTO implements Serializable /* tjek */ {

    private String name;
    private String model;
    private String description;
    private int year;
    private String color;
    private int personsAllowed;

    private List<BookingDateDTO> bookingdates;
    private List<ImageDTO> images;

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getPersonsAllowed() {
        return personsAllowed;
    }

    public List<BookingDateDTO> getBookingdates() {
        return bookingdates;
    }

    public List<ImageDTO> getImages() {
        return images;
    }

    public KayakDTO(Kayak k) {
        this.name = k.getName();
        this.model = k.getModel();
        this.description = k.getDescription();
        this.year = k.getYear();
        this.color = k.getColor();
        this.personsAllowed = k.getPersonsAllowed();
        this.bookingdates = new ArrayList<>();
        this.images = new ArrayList<>();
        for (BookingDate date : k.getBookingdate()) {
            bookingdates.add(new BookingDateDTO(date));
        }
        for (Image image : k.getImage()) {
            images.add(new ImageDTO(image));
        }
    }

}
