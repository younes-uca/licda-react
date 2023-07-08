package  ma.sir.vaccination.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.vaccination.zynerator.util.StringUtil;
import ma.sir.vaccination.zynerator.converter.AbstractConverter;
import ma.sir.vaccination.zynerator.util.DateUtil;
import ma.sir.vaccination.bean.history.PatientHistory;
import ma.sir.vaccination.bean.core.Patient;
import ma.sir.vaccination.ws.dto.PatientDto;

@Component
public class PatientConverter extends AbstractConverter<Patient, PatientDto, PatientHistory> {

    @Autowired
    private VilleConverter villeConverter ;
    @Autowired
    private GenderConverter genderConverter ;
    private boolean ville;
    private boolean gender;

    public  PatientConverter(){
        super(Patient.class, PatientDto.class, PatientHistory.class);
    }

    @Override
    public Patient toItem(PatientDto dto) {
        if (dto == null) {
            return null;
        } else {
        Patient item = new Patient();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getIpp()))
                item.setIpp(dto.getIpp());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(StringUtil.isNotEmpty(dto.getCin()))
                item.setCin(dto.getCin());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getPrenom()))
                item.setPrenom(dto.getPrenom());
            if(StringUtil.isNotEmpty(dto.getAge()))
                item.setAge(dto.getAge());
            if(this.ville && dto.getVille()!=null)
                item.setVille(villeConverter.toItem(dto.getVille())) ;

            if(this.gender && dto.getGender()!=null)
                item.setGender(genderConverter.toItem(dto.getGender())) ;



        return item;
        }
    }

    @Override
    public PatientDto toDto(Patient item) {
        if (item == null) {
            return null;
        } else {
            PatientDto dto = new PatientDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getIpp()))
                dto.setIpp(item.getIpp());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(StringUtil.isNotEmpty(item.getCin()))
                dto.setCin(item.getCin());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getPrenom()))
                dto.setPrenom(item.getPrenom());
            if(StringUtil.isNotEmpty(item.getAge()))
                dto.setAge(item.getAge());
        if(this.ville && item.getVille()!=null) {
            dto.setVille(villeConverter.toDto(item.getVille())) ;
        }
        if(this.gender && item.getGender()!=null) {
            dto.setGender(genderConverter.toDto(item.getGender())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.ville = value;
        this.gender = value;
    }


    public VilleConverter getVilleConverter(){
        return this.villeConverter;
    }
    public void setVilleConverter(VilleConverter villeConverter ){
        this.villeConverter = villeConverter;
    }
    public GenderConverter getGenderConverter(){
        return this.genderConverter;
    }
    public void setGenderConverter(GenderConverter genderConverter ){
        this.genderConverter = genderConverter;
    }
    public boolean  isVille(){
        return this.ville;
    }
    public void  setVille(boolean ville){
        this.ville = ville;
    }
    public boolean  isGender(){
        return this.gender;
    }
    public void  setGender(boolean gender){
        this.gender = gender;
    }
}
