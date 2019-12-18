package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "drug")
public class Drug {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 500)
    private String name;

    @Column
    private String usage;



    @OneToMany(mappedBy = "drug", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JsonIgnore
    private List<PrescribedDrug> prescribedDrugs;

    public Drug() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public List<PrescribedDrug> getPrescribedDrugs() {
        return prescribedDrugs;
    }

    public void setPrescribedDrugs(List<PrescribedDrug> prescribedDrugs) {
        this.prescribedDrugs = prescribedDrugs;
    }

}
