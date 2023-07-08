package  ma.sir.vaccination.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.vaccination.zynerator.util.StringUtil;
import ma.sir.vaccination.zynerator.converter.AbstractConverter;
import ma.sir.vaccination.zynerator.util.DateUtil;
import ma.sir.vaccination.bean.history.EtatRendezVousHistory;
import ma.sir.vaccination.bean.core.EtatRendezVous;
import ma.sir.vaccination.ws.dto.EtatRendezVousDto;

@Component
public class EtatRendezVousConverter extends AbstractConverter<EtatRendezVous, EtatRendezVousDto, EtatRendezVousHistory> {


    public  EtatRendezVousConverter(){
        super(EtatRendezVous.class, EtatRendezVousDto.class, EtatRendezVousHistory.class);
    }

    @Override
    public EtatRendezVous toItem(EtatRendezVousDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatRendezVous item = new EtatRendezVous();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());


        return item;
        }
    }

    @Override
    public EtatRendezVousDto toDto(EtatRendezVous item) {
        if (item == null) {
            return null;
        } else {
            EtatRendezVousDto dto = new EtatRendezVousDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
