package ma.sir.vaccination.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "dose")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="dose_seq",sequenceName="dose_seq",allocationSize=1, initialValue = 1)
public class Dose   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateDebutPrevu ;
    private LocalDateTime dateDebutEffectif ;
    @Column(length = 500)
    private String description;

    private RendezVous rendezVous ;
    
    private EtatDose etatDose ;
    


    public Dose(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="dose_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public RendezVous getRendezVous(){
        return this.rendezVous;
    }
    public void setRendezVous(RendezVous rendezVous){
        this.rendezVous = rendezVous;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatDose getEtatDose(){
        return this.etatDose;
    }
    public void setEtatDose(EtatDose etatDose){
        this.etatDose = etatDose;
    }
    public LocalDateTime getDateDebutPrevu(){
        return this.dateDebutPrevu;
    }
    public void setDateDebutPrevu(LocalDateTime dateDebutPrevu){
        this.dateDebutPrevu = dateDebutPrevu;
    }
    public LocalDateTime getDateDebutEffectif(){
        return this.dateDebutEffectif;
    }
    public void setDateDebutEffectif(LocalDateTime dateDebutEffectif){
        this.dateDebutEffectif = dateDebutEffectif;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dose dose = (Dose) o;
        return id != null && id.equals(dose.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

