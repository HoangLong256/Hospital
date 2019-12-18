package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "visitLog")
public class VisitLog {
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date visitDate;

    @Temporal(TemporalType.TIME)
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm",timezone = "Asia/Ho_Chi_Minh")
    private Date visitTime;

    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Patient patient;

    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Hospital hospital;

//
//    @OneToMany(mappedBy = "visitLog", fetch = FetchType.EAGER)
//    @Cascade(CascadeType.ALL)
//    @Fetch(FetchMode.SUBSELECT)
//    private List<LabTest> labTests;

    @OneToMany(mappedBy = "visitLog", cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JsonIgnore
    private List<Lesion> lesions = new ArrayList<>();


    @Column
    private String information;

    @Column
    private String doctor;


//    @OneToMany(mappedBy = "visitLog", cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.EAGER)
//    @Cascade(CascadeType.ALL)
//    @JsonIgnore
//    private List<Prescription> prescriptions = new ArrayList<>();



    public VisitLog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

//    public List<Prescription> getPrescriptions() {
//        return prescriptions;
//    }

//    public void setPrescriptions(List<Prescription> prescriptions) {
//        this.prescriptions = prescriptions;
//    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public List<Lesion> getLesions() {
        return lesions;
    }

    public void setLesions(List<Lesion> lesions) {
        this.lesions = lesions;
    }

    //
//    public List<LabTest> getLabTests() {
//        return labTests;
//    }
//
//    public void setLabTests(List<LabTest> labTests) {
//        this.labTests = labTests;
//    }



}
