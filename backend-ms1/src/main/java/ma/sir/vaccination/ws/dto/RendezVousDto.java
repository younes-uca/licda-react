package  ma.sir.vaccination.ws.dto;

import ma.sir.vaccination.zynerator.audit.Log;
import ma.sir.vaccination.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class RendezVousDto  extends AuditBaseDto {

    private String datePriseRdv ;

    private PatientDto patient ;
    private CenterDto center ;
    private MedecinDto medecin ;
    private CategorieRdvDto categorieRdv ;
    private EtatRendezVousDto etatRendezVous ;

    private List<DoseDto> Doses ;
    private List<EffetIndesirableDto> effetIndesirables ;


    public RendezVousDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDatePriseRdv(){
        return this.datePriseRdv;
    }
    public void setDatePriseRdv(String datePriseRdv){
        this.datePriseRdv = datePriseRdv;
    }


    public PatientDto getPatient(){
        return this.patient;
    }

    public void setPatient(PatientDto patient){
        this.patient = patient;
    }
    public CenterDto getCenter(){
        return this.center;
    }

    public void setCenter(CenterDto center){
        this.center = center;
    }
    public MedecinDto getMedecin(){
        return this.medecin;
    }

    public void setMedecin(MedecinDto medecin){
        this.medecin = medecin;
    }
    public CategorieRdvDto getCategorieRdv(){
        return this.categorieRdv;
    }

    public void setCategorieRdv(CategorieRdvDto categorieRdv){
        this.categorieRdv = categorieRdv;
    }
    public EtatRendezVousDto getEtatRendezVous(){
        return this.etatRendezVous;
    }

    public void setEtatRendezVous(EtatRendezVousDto etatRendezVous){
        this.etatRendezVous = etatRendezVous;
    }



    public List<DoseDto> getDoses(){
        return this.Doses;
    }

    public void setDoses(List<DoseDto> Doses){
        this.Doses = Doses;
    }
    public List<EffetIndesirableDto> getEffetIndesirables(){
        return this.effetIndesirables;
    }

    public void setEffetIndesirables(List<EffetIndesirableDto> effetIndesirables){
        this.effetIndesirables = effetIndesirables;
    }

}
