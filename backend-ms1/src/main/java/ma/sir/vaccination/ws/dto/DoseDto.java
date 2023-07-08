package  ma.sir.vaccination.ws.dto;

import ma.sir.vaccination.zynerator.audit.Log;
import ma.sir.vaccination.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoseDto  extends AuditBaseDto {

    private String dateDebutPrevu ;
    private String dateDebutEffectif ;
    private String description  ;

    private RendezVousDto rendezVous ;
    private EtatDoseDto etatDose ;



    public DoseDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDebutPrevu(){
        return this.dateDebutPrevu;
    }
    public void setDateDebutPrevu(String dateDebutPrevu){
        this.dateDebutPrevu = dateDebutPrevu;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDebutEffectif(){
        return this.dateDebutEffectif;
    }
    public void setDateDebutEffectif(String dateDebutEffectif){
        this.dateDebutEffectif = dateDebutEffectif;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public RendezVousDto getRendezVous(){
        return this.rendezVous;
    }

    public void setRendezVous(RendezVousDto rendezVous){
        this.rendezVous = rendezVous;
    }
    public EtatDoseDto getEtatDose(){
        return this.etatDose;
    }

    public void setEtatDose(EtatDoseDto etatDose){
        this.etatDose = etatDose;
    }




}
