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
@Table(name = "effet_indesirable")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="effet_indesirable_seq",sequenceName="effet_indesirable_seq",allocationSize=1, initialValue = 1)
public class EffetIndesirable   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateFait ;
    @Column(length = 500)
    private String description;

    private RendezVous rendezVous ;
    


    public EffetIndesirable(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="effet_indesirable_seq")
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
    public LocalDateTime getDateFait(){
        return this.dateFait;
    }
    public void setDateFait(LocalDateTime dateFait){
        this.dateFait = dateFait;
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
        EffetIndesirable effetIndesirable = (EffetIndesirable) o;
        return id != null && id.equals(effetIndesirable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

