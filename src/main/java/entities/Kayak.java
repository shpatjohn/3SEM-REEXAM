package entities;

import entities.BookingDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author shpattt
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Kayak.getAll", query = "SELECT new DTO.KayakDTO(k) FROM Kayak k"),
    @NamedQuery(name = "Kayak.deleteAll", query = "DELETE FROM Kayak k"),
    @NamedQuery(name = "Kayak.getByPersonAllowed", query = "SELECT new DTO.KayakDTO(k) FROM Kayak k WHERE k.personsAllowed = :personsAllowed"),
    @NamedQuery(name = "Kayak.getByName", query = "SELECT new DTO.KayakDTO(k) FROM Kayak k WHERE k.name = :name"),
    @NamedQuery(name = "Kayak.getByBookingDate", query = "SELECT new DTO.KayakDTO(k) FROM Kayak k WHERE k.bookingdates = :bookingdate"),
})
public class Kayak implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    private String description;
    private int year;
    private String color;
    private int personsAllowed;
    
    
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Image> images;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BookingDate> bookingdates; 

    public Kayak(String name, String model, String description, int year, String color, int personsAllowed) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.description = description;
        this.year = year;
        this.color = color;
        this.personsAllowed = personsAllowed;
        this.images = new ArrayList<>();
        this.bookingdates = new ArrayList<>();
    }
    
    
    public Kayak() { }

    public void addBookingDate(BookingDate date)
    {
        bookingdates.add(date);
    }
    
    public void addImages(Image image)
    {
        images.add(image);
    }
         
            
            
    public List<Image> getImage() {
        return images;
    }

    public void setImage(List<Image> image) {
        this.images = image;
    }

    public List<BookingDate> getBookingdate() {
        return bookingdates;
    }

    public void setBookingdate(List<BookingDate> bookingdate) {
        this.bookingdates = bookingdate;
    }
    
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPersonsAllowed() {
        return personsAllowed;
    }

    public void setPersonsAllowed(int personsAllowed) {
        this.personsAllowed = personsAllowed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Kayak{" + "id=" + id + ", name=" + name + ", model=" + model + ", description=" + description + ", year=" + year + ", color=" + color + ", personsAllowed=" + personsAllowed + ", images=" + images + ", bookingdates=" + bookingdates + '}';
    }
    
   
  
    
    

   
}
