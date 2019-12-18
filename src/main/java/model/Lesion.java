package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "lesion")
public class Lesion {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    @Temporal(TemporalType.TIME)
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm",timezone = "Asia/Ho_Chi_Minh")
    private Date time;

    @Column
    private String location;

    @Column
    private String size;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private VisitLog visitLog;

    public Lesion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public VisitLog getVisitLog() {
        return visitLog;
    }

    public void setVisitLog(VisitLog visitLog) {
        this.visitLog = visitLog;
    }
}
