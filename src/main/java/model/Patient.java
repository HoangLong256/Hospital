package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.persistence.CascadeType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String title;


    @Temporal(TemporalType.DATE)
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;

    @Column
    private String gender;

    @Column
    private String streetAddress;

    @Column
    private String maritalStatus;

    @Column
    private String suburb;

    @Column
    private String country;

    @Column
    private int homePhone;

    @Column
    private int officePhone;

    @Column
    private int mobilePhone;

    @Column
    private int faxNumber;

    @Column
    private String occupation;

    @Column
    private String nextToKin;

    @Column
    private int contactNumber;

    @Column
    private int postCode;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Hospital hospital;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<VisitLog> visitLogs;

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(int homePhone) {
        this.homePhone = homePhone;
    }

    public int getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(int officePhone) {
        this.officePhone = officePhone;
    }

    public int getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(int mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public int getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(int faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNextToKin() {
        return nextToKin;
    }

    public void setNextToKin(String nextToKin) {
        this.nextToKin = nextToKin;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public List<VisitLog> getVisitLogs() {
        return visitLogs;
    }

    public void setVisitLogs(List<VisitLog> visitLogs) {
        this.visitLogs = visitLogs;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
