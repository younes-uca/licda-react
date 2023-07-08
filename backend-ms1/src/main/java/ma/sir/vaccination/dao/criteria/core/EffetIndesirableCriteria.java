package  ma.sir.vaccination.dao.criteria.core;


import ma.sir.vaccination.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class EffetIndesirableCriteria extends  BaseCriteria  {

    private LocalDateTime dateFait;
    private LocalDateTime dateFaitFrom;
    private LocalDateTime dateFaitTo;
    private String description;
    private String descriptionLike;

    private RendezVousCriteria rendezVous ;
    private List<RendezVousCriteria> rendezVouss ;


    public EffetIndesirableCriteria(){}

    public LocalDateTime getDateFait(){
        return this.dateFait;
    }
    public void setDateFait(LocalDateTime dateFait){
        this.dateFait = dateFait;
    }
    public LocalDateTime getDateFaitFrom(){
        return this.dateFaitFrom;
    }
    public void setDateFaitFrom(LocalDateTime dateFaitFrom){
        this.dateFaitFrom = dateFaitFrom;
    }
    public LocalDateTime getDateFaitTo(){
        return this.dateFaitTo;
    }
    public void setDateFaitTo(LocalDateTime dateFaitTo){
        this.dateFaitTo = dateFaitTo;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }


    public RendezVousCriteria getRendezVous(){
        return this.rendezVous;
    }

    public void setRendezVous(RendezVousCriteria rendezVous){
        this.rendezVous = rendezVous;
    }
    public List<RendezVousCriteria> getRendezVouss(){
        return this.rendezVouss;
    }

    public void setRendezVouss(List<RendezVousCriteria> rendezVouss){
        this.rendezVouss = rendezVouss;
    }
}
