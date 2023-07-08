package  ma.sir.vaccination.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.vaccination.zynerator.util.ListUtil;


import ma.sir.vaccination.zynerator.util.StringUtil;
import ma.sir.vaccination.zynerator.converter.AbstractConverter;
import ma.sir.vaccination.zynerator.util.DateUtil;
import ma.sir.vaccination.bean.history.RendezVousHistory;
import ma.sir.vaccination.bean.core.RendezVous;
import ma.sir.vaccination.ws.dto.RendezVousDto;

@Component
public class RendezVousConverter extends AbstractConverter<RendezVous, RendezVousDto, RendezVousHistory> {

    @Autowired
    private CategorieRdvConverter categorieRdvConverter ;
    @Autowired
    private EtatRendezVousConverter etatRendezVousConverter ;
    @Autowired
    private EtatDoseConverter etatDoseConverter ;
    @Autowired
    private MedecinConverter medecinConverter ;
    @Autowired
    private DoseConverter doseConverter ;
    @Autowired
    private CenterConverter centerConverter ;
    @Autowired
    private EffetIndesirableConverter effetIndesirableConverter ;
    @Autowired
    private PatientConverter patientConverter ;
    private boolean patient;
    private boolean center;
    private boolean medecin;
    private boolean categorieRdv;
    private boolean etatRendezVous;
    private boolean Doses;
    private boolean effetIndesirables;

    public  RendezVousConverter(){
        super(RendezVous.class, RendezVousDto.class, RendezVousHistory.class);
        init(true);
    }

    @Override
    public RendezVous toItem(RendezVousDto dto) {
        if (dto == null) {
            return null;
        } else {
        RendezVous item = new RendezVous();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDatePriseRdv()))
                item.setDatePriseRdv(DateUtil.stringEnToDate(dto.getDatePriseRdv()));
            if(this.patient && dto.getPatient()!=null)
                item.setPatient(patientConverter.toItem(dto.getPatient())) ;

            if(this.center && dto.getCenter()!=null)
                item.setCenter(centerConverter.toItem(dto.getCenter())) ;

            if(this.medecin && dto.getMedecin()!=null)
                item.setMedecin(medecinConverter.toItem(dto.getMedecin())) ;

            if(this.categorieRdv && dto.getCategorieRdv()!=null)
                item.setCategorieRdv(categorieRdvConverter.toItem(dto.getCategorieRdv())) ;

            if(this.etatRendezVous && dto.getEtatRendezVous()!=null)
                item.setEtatRendezVous(etatRendezVousConverter.toItem(dto.getEtatRendezVous())) ;


            if(this.Doses && ListUtil.isNotEmpty(dto.getDoses()))
                item.setDoses(doseConverter.toItem(dto.getDoses()));
            if(this.effetIndesirables && ListUtil.isNotEmpty(dto.getEffetIndesirables()))
                item.setEffetIndesirables(effetIndesirableConverter.toItem(dto.getEffetIndesirables()));

        return item;
        }
    }

    @Override
    public RendezVousDto toDto(RendezVous item) {
        if (item == null) {
            return null;
        } else {
            RendezVousDto dto = new RendezVousDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDatePriseRdv()!=null)
                dto.setDatePriseRdv(DateUtil.dateTimeToString(item.getDatePriseRdv()));
        if(this.patient && item.getPatient()!=null) {
            dto.setPatient(patientConverter.toDto(item.getPatient())) ;
        }
        if(this.center && item.getCenter()!=null) {
            dto.setCenter(centerConverter.toDto(item.getCenter())) ;
        }
        if(this.medecin && item.getMedecin()!=null) {
            dto.setMedecin(medecinConverter.toDto(item.getMedecin())) ;
        }
        if(this.categorieRdv && item.getCategorieRdv()!=null) {
            dto.setCategorieRdv(categorieRdvConverter.toDto(item.getCategorieRdv())) ;
        }
        if(this.etatRendezVous && item.getEtatRendezVous()!=null) {
            dto.setEtatRendezVous(etatRendezVousConverter.toDto(item.getEtatRendezVous())) ;
        }
        if(this.Doses && ListUtil.isNotEmpty(item.getDoses())){
            doseConverter.init(true);
            doseConverter.setRendezVous(false);
            dto.setDoses(doseConverter.toDto(item.getDoses()));
            doseConverter.setRendezVous(true);

        }
        if(this.effetIndesirables && ListUtil.isNotEmpty(item.getEffetIndesirables())){
            effetIndesirableConverter.init(true);
            effetIndesirableConverter.setRendezVous(false);
            dto.setEffetIndesirables(effetIndesirableConverter.toDto(item.getEffetIndesirables()));
            effetIndesirableConverter.setRendezVous(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.Doses = value;
        this.effetIndesirables = value;
    }

    public void initObject(boolean value) {
        this.patient = value;
        this.center = value;
        this.medecin = value;
        this.categorieRdv = value;
        this.etatRendezVous = value;
    }


    public CategorieRdvConverter getCategorieRdvConverter(){
        return this.categorieRdvConverter;
    }
    public void setCategorieRdvConverter(CategorieRdvConverter categorieRdvConverter ){
        this.categorieRdvConverter = categorieRdvConverter;
    }
    public EtatRendezVousConverter getEtatRendezVousConverter(){
        return this.etatRendezVousConverter;
    }
    public void setEtatRendezVousConverter(EtatRendezVousConverter etatRendezVousConverter ){
        this.etatRendezVousConverter = etatRendezVousConverter;
    }
    public EtatDoseConverter getEtatDoseConverter(){
        return this.etatDoseConverter;
    }
    public void setEtatDoseConverter(EtatDoseConverter etatDoseConverter ){
        this.etatDoseConverter = etatDoseConverter;
    }
    public MedecinConverter getMedecinConverter(){
        return this.medecinConverter;
    }
    public void setMedecinConverter(MedecinConverter medecinConverter ){
        this.medecinConverter = medecinConverter;
    }
    public DoseConverter getDoseConverter(){
        return this.doseConverter;
    }
    public void setDoseConverter(DoseConverter doseConverter ){
        this.doseConverter = doseConverter;
    }
    public CenterConverter getCenterConverter(){
        return this.centerConverter;
    }
    public void setCenterConverter(CenterConverter centerConverter ){
        this.centerConverter = centerConverter;
    }
    public EffetIndesirableConverter getEffetIndesirableConverter(){
        return this.effetIndesirableConverter;
    }
    public void setEffetIndesirableConverter(EffetIndesirableConverter effetIndesirableConverter ){
        this.effetIndesirableConverter = effetIndesirableConverter;
    }
    public PatientConverter getPatientConverter(){
        return this.patientConverter;
    }
    public void setPatientConverter(PatientConverter patientConverter ){
        this.patientConverter = patientConverter;
    }
    public boolean  isPatient(){
        return this.patient;
    }
    public void  setPatient(boolean patient){
        this.patient = patient;
    }
    public boolean  isCenter(){
        return this.center;
    }
    public void  setCenter(boolean center){
        this.center = center;
    }
    public boolean  isMedecin(){
        return this.medecin;
    }
    public void  setMedecin(boolean medecin){
        this.medecin = medecin;
    }
    public boolean  isCategorieRdv(){
        return this.categorieRdv;
    }
    public void  setCategorieRdv(boolean categorieRdv){
        this.categorieRdv = categorieRdv;
    }
    public boolean  isEtatRendezVous(){
        return this.etatRendezVous;
    }
    public void  setEtatRendezVous(boolean etatRendezVous){
        this.etatRendezVous = etatRendezVous;
    }
    public boolean  isDoses(){
        return this.Doses ;
    }
    public void  setDoses(boolean Doses ){
        this.Doses  = Doses ;
    }
    public boolean  isEffetIndesirables(){
        return this.effetIndesirables ;
    }
    public void  setEffetIndesirables(boolean effetIndesirables ){
        this.effetIndesirables  = effetIndesirables ;
    }
}
