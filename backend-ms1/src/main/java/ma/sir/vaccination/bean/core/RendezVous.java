package ma.sir.vaccination.bean.core;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "rendez_vous")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="rendez_vous_seq",sequenceName="rendez_vous_seq",allocationSize=1, initialValue = 1)
public class RendezVous   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime datePriseRdv ;

    private Patient patient ;
    
    private Center center ;
    
    private Medecin medecin ;
    
    private CategorieRdv categorieRdv ;
    
    private EtatRendezVous etatRendezVous ;
    

    private List<Dose> Doses ;
    private List<EffetIndesirable> effetIndesirables ;

    public RendezVous(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="rendez_vous_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Patient getPatient(){
        return this.patient;
    }
    public void setPatient(Patient patient){
        this.patient = patient;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Center getCenter(){
        return this.center;
    }
    public void setCenter(Center center){
        this.center = center;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Medecin getMedecin(){
        return this.medecin;
    }
    public void setMedecin(Medecin medecin){
        this.medecin = medecin;
    }
    public LocalDateTime getDatePriseRdv(){
        return this.datePriseRdv;
    }
    public void setDatePriseRdv(LocalDateTime datePriseRdv){
        this.datePriseRdv = datePriseRdv;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public CategorieRdv getCategorieRdv(){
        return this.categorieRdv;
    }
    public void setCategorieRdv(CategorieRdv categorieRdv){
        this.categorieRdv = categorieRdv;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatRendezVous getEtatRendezVous(){
        return this.etatRendezVous;
    }
    public void setEtatRendezVous(EtatRendezVous etatRendezVous){
        this.etatRendezVous = etatRendezVous;
    }
    @OneToMany(mappedBy = "rendezVous")
    public List<Dose> getDoses(){
        return this.Doses;
    }
    public void setDoses(List<Dose> Doses){
        this.Doses = Doses;
    }
    @OneToMany(mappedBy = "rendezVous")
    public List<EffetIndesirable> getEffetIndesirables(){
        return this.effetIndesirables;
    }
    public void setEffetIndesirables(List<EffetIndesirable> effetIndesirables){
        this.effetIndesirables = effetIndesirables;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendezVous rendezVous = (RendezVous) o;
        return id != null && id.equals(rendezVous.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

