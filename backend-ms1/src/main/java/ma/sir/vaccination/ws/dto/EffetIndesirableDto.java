package  ma.sir.vaccination.ws.dto;

import ma.sir.vaccination.zynerator.audit.Log;
import ma.sir.vaccination.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EffetIndesirableDto  extends AuditBaseDto {

    private String dateFait ;
    private String description  ;

    private RendezVousDto rendezVous ;



    public EffetIndesirableDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFait(){
        return this.dateFait;
    }
    public void setDateFait(String dateFait){
        this.dateFait = dateFait;
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




}
