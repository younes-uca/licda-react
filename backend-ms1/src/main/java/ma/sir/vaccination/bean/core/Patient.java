package ma.sir.vaccination.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "patient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="patient_seq",sequenceName="patient_seq",allocationSize=1, initialValue = 1)
public class Patient   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ipp;
    @Column(length = 500)
    private String email;
    @Column(length = 500)
    private String cin;
    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String prenom;
    private Integer age = 0;

    private Ville ville ;
    
    private Gender gender ;
    


    public Patient(){
        super();
    }

    public Patient(Long id,String email){
        this.id = id;
        this.email = email ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="patient_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getIpp(){
        return this.ipp;
    }
    public void setIpp(String ipp){
        this.ipp = ipp;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public Integer getAge(){
        return this.age;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Ville getVille(){
        return this.ville;
    }
    public void setVille(Ville ville){
        this.ville = ville;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Gender getGender(){
        return this.gender;
    }
    public void setGender(Gender gender){
        this.gender = gender;
    }

    @Transient
    public String getLabel() {
        label = email;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id != null && id.equals(patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

