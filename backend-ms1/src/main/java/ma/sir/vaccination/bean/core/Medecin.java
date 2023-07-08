package ma.sir.vaccination.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "medecin")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="medecin_seq",sequenceName="medecin_seq",allocationSize=1, initialValue = 1)
public class Medecin   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String email;
    @Column(length = 500)
    private String cin;
    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String prenom;

    private Center center ;
    


    public Medecin(){
        super();
    }

    public Medecin(Long id,String email){
        this.id = id;
        this.email = email ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="medecin_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
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
    @ManyToOne(fetch = FetchType.LAZY)
    public Center getCenter(){
        return this.center;
    }
    public void setCenter(Center center){
        this.center = center;
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
        Medecin medecin = (Medecin) o;
        return id != null && id.equals(medecin.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

