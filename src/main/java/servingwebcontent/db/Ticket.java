package servingwebcontent.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String otkyda;
    private String kyda;
    private String cost;
    private String calendar;

    public Ticket(){

    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCalendar() {
        return calendar;
    }


    public Ticket(String otkyda, String kyda, String cost) {
        this.otkyda = otkyda;
        this.kyda = kyda;
        this.cost=cost;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        this.calendar= cal.get(Calendar.DAY_OF_MONTH)+"." + (cal.get(Calendar.MONTH) + 1) +"."
                + cal.get(Calendar.YEAR);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOtkyda() {
        return otkyda;
    }

    public void setOtkyda(String from) {
        this.otkyda = from;
    }

    public String getKyda() {
        return kyda;
    }

    public void setKyda(String to) {
        this.kyda = to;
    }

}
