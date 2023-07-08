package  ma.sir.vaccination.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.vaccination.bean.core.RendezVous;

import ma.sir.vaccination.zynerator.util.StringUtil;
import ma.sir.vaccination.zynerator.converter.AbstractConverter;
import ma.sir.vaccination.zynerator.util.DateUtil;
import ma.sir.vaccination.bean.history.DoseHistory;
import ma.sir.vaccination.bean.core.Dose;
import ma.sir.vaccination.ws.dto.DoseDto;

@Component
public class DoseConverter extends AbstractConverter<Dose, DoseDto, DoseHistory> {

    @Autowired
    private EtatDoseConverter etatDoseConverter ;
    @Autowired
    private RendezVousConverter rendezVousConverter ;
    private boolean rendezVous;
    private boolean etatDose;

    public  DoseConverter(){
        super(Dose.class, DoseDto.class, DoseHistory.class);
    }

    @Override
    public Dose toItem(DoseDto dto) {
        if (dto == null) {
            return null;
        } else {
        Dose item = new Dose();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateDebutPrevu()))
                item.setDateDebutPrevu(DateUtil.stringEnToDate(dto.getDateDebutPrevu()));
            if(StringUtil.isNotEmpty(dto.getDateDebutEffectif()))
                item.setDateDebutEffectif(DateUtil.stringEnToDate(dto.getDateDebutEffectif()));
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getRendezVous() != null && dto.getRendezVous().getId() != null){
                item.setRendezVous(new RendezVous());
                item.getRendezVous().setId(dto.getRendezVous().getId());
            }

            if(this.etatDose && dto.getEtatDose()!=null)
                item.setEtatDose(etatDoseConverter.toItem(dto.getEtatDose())) ;



        return item;
        }
    }

    @Override
    public DoseDto toDto(Dose item) {
        if (item == null) {
            return null;
        } else {
            DoseDto dto = new DoseDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateDebutPrevu()!=null)
                dto.setDateDebutPrevu(DateUtil.dateTimeToString(item.getDateDebutPrevu()));
            if(item.getDateDebutEffectif()!=null)
                dto.setDateDebutEffectif(DateUtil.dateTimeToString(item.getDateDebutEffectif()));
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.rendezVous && item.getRendezVous()!=null) {
            dto.setRendezVous(rendezVousConverter.toDto(item.getRendezVous())) ;
        }
        if(this.etatDose && item.getEtatDose()!=null) {
            dto.setEtatDose(etatDoseConverter.toDto(item.getEtatDose())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.rendezVous = value;
        this.etatDose = value;
    }


    public EtatDoseConverter getEtatDoseConverter(){
        return this.etatDoseConverter;
    }
    public void setEtatDoseConverter(EtatDoseConverter etatDoseConverter ){
        this.etatDoseConverter = etatDoseConverter;
    }
    public RendezVousConverter getRendezVousConverter(){
        return this.rendezVousConverter;
    }
    public void setRendezVousConverter(RendezVousConverter rendezVousConverter ){
        this.rendezVousConverter = rendezVousConverter;
    }
    public boolean  isRendezVous(){
        return this.rendezVous;
    }
    public void  setRendezVous(boolean rendezVous){
        this.rendezVous = rendezVous;
    }
    public boolean  isEtatDose(){
        return this.etatDose;
    }
    public void  setEtatDose(boolean etatDose){
        this.etatDose = etatDose;
    }
}
