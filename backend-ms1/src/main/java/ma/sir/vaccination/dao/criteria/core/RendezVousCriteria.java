package  ma.sir.vaccination.dao.criteria.core;


import ma.sir.vaccination.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class RendezVousCriteria extends  BaseCriteria  {

    private LocalDateTime datePriseRdv;
    private LocalDateTime datePriseRdvFrom;
    private LocalDateTime datePriseRdvTo;

    private PatientCriteria patient ;
    private List<PatientCriteria> patients ;
    private CenterCriteria center ;
    private List<CenterCriteria> centers ;
    private MedecinCriteria medecin ;
    private List<MedecinCriteria> medecins ;
    private CategorieRdvCriteria categorieRdv ;
    private List<CategorieRdvCriteria> categorieRdvs ;
    private EtatRendezVousCriteria etatRendezVous ;
    private List<EtatRendezVousCriteria> etatRendezVouss ;


    public RendezVousCriteria(){}

    public LocalDateTime getDatePriseRdv(){
        return this.datePriseRdv;
    }
    public void setDatePriseRdv(LocalDateTime datePriseRdv){
        this.datePriseRdv = datePriseRdv;
    }
    public LocalDateTime getDatePriseRdvFrom(){
        return this.datePriseRdvFrom;
    }
    public void setDatePriseRdvFrom(LocalDateTime datePriseRdvFrom){
        this.datePriseRdvFrom = datePriseRdvFrom;
    }
    public LocalDateTime getDatePriseRdvTo(){
        return this.datePriseRdvTo;
    }
    public void setDatePriseRdvTo(LocalDateTime datePriseRdvTo){
        this.datePriseRdvTo = datePriseRdvTo;
    }

    public PatientCriteria getPatient(){
        return this.patient;
    }

    public void setPatient(PatientCriteria patient){
        this.patient = patient;
    }
    public List<PatientCriteria> getPatients(){
        return this.patients;
    }

    public void setPatients(List<PatientCriteria> patients){
        this.patients = patients;
    }
    public CenterCriteria getCenter(){
        return this.center;
    }

    public void setCenter(CenterCriteria center){
        this.center = center;
    }
    public List<CenterCriteria> getCenters(){
        return this.centers;
    }

    public void setCenters(List<CenterCriteria> centers){
        this.centers = centers;
    }
    public MedecinCriteria getMedecin(){
        return this.medecin;
    }

    public void setMedecin(MedecinCriteria medecin){
        this.medecin = medecin;
    }
    public List<MedecinCriteria> getMedecins(){
        return this.medecins;
    }

    public void setMedecins(List<MedecinCriteria> medecins){
        this.medecins = medecins;
    }
    public CategorieRdvCriteria getCategorieRdv(){
        return this.categorieRdv;
    }

    public void setCategorieRdv(CategorieRdvCriteria categorieRdv){
        this.categorieRdv = categorieRdv;
    }
    public List<CategorieRdvCriteria> getCategorieRdvs(){
        return this.categorieRdvs;
    }

    public void setCategorieRdvs(List<CategorieRdvCriteria> categorieRdvs){
        this.categorieRdvs = categorieRdvs;
    }
    public EtatRendezVousCriteria getEtatRendezVous(){
        return this.etatRendezVous;
    }

    public void setEtatRendezVous(EtatRendezVousCriteria etatRendezVous){
        this.etatRendezVous = etatRendezVous;
    }
    public List<EtatRendezVousCriteria> getEtatRendezVouss(){
        return this.etatRendezVouss;
    }

    public void setEtatRendezVouss(List<EtatRendezVousCriteria> etatRendezVouss){
        this.etatRendezVouss = etatRendezVouss;
    }
}
