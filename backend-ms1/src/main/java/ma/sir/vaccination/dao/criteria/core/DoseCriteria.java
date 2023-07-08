package  ma.sir.vaccination.dao.criteria.core;


import ma.sir.vaccination.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class DoseCriteria extends  BaseCriteria  {

    private LocalDateTime dateDebutPrevu;
    private LocalDateTime dateDebutPrevuFrom;
    private LocalDateTime dateDebutPrevuTo;
    private LocalDateTime dateDebutEffectif;
    private LocalDateTime dateDebutEffectifFrom;
    private LocalDateTime dateDebutEffectifTo;
    private String description;
    private String descriptionLike;

    private RendezVousCriteria rendezVous ;
    private List<RendezVousCriteria> rendezVouss ;
    private EtatDoseCriteria etatDose ;
    private List<EtatDoseCriteria> etatDoses ;


    public DoseCriteria(){}

    public LocalDateTime getDateDebutPrevu(){
        return this.dateDebutPrevu;
    }
    public void setDateDebutPrevu(LocalDateTime dateDebutPrevu){
        this.dateDebutPrevu = dateDebutPrevu;
    }
    public LocalDateTime getDateDebutPrevuFrom(){
        return this.dateDebutPrevuFrom;
    }
    public void setDateDebutPrevuFrom(LocalDateTime dateDebutPrevuFrom){
        this.dateDebutPrevuFrom = dateDebutPrevuFrom;
    }
    public LocalDateTime getDateDebutPrevuTo(){
        return this.dateDebutPrevuTo;
    }
    public void setDateDebutPrevuTo(LocalDateTime dateDebutPrevuTo){
        this.dateDebutPrevuTo = dateDebutPrevuTo;
    }
    public LocalDateTime getDateDebutEffectif(){
        return this.dateDebutEffectif;
    }
    public void setDateDebutEffectif(LocalDateTime dateDebutEffectif){
        this.dateDebutEffectif = dateDebutEffectif;
    }
    public LocalDateTime getDateDebutEffectifFrom(){
        return this.dateDebutEffectifFrom;
    }
    public void setDateDebutEffectifFrom(LocalDateTime dateDebutEffectifFrom){
        this.dateDebutEffectifFrom = dateDebutEffectifFrom;
    }
    public LocalDateTime getDateDebutEffectifTo(){
        return this.dateDebutEffectifTo;
    }
    public void setDateDebutEffectifTo(LocalDateTime dateDebutEffectifTo){
        this.dateDebutEffectifTo = dateDebutEffectifTo;
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
    public EtatDoseCriteria getEtatDose(){
        return this.etatDose;
    }

    public void setEtatDose(EtatDoseCriteria etatDose){
        this.etatDose = etatDose;
    }
    public List<EtatDoseCriteria> getEtatDoses(){
        return this.etatDoses;
    }

    public void setEtatDoses(List<EtatDoseCriteria> etatDoses){
        this.etatDoses = etatDoses;
    }
}
