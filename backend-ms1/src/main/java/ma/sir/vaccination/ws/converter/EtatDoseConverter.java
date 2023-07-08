package  ma.sir.vaccination.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.vaccination.zynerator.util.StringUtil;
import ma.sir.vaccination.zynerator.converter.AbstractConverter;
import ma.sir.vaccination.zynerator.util.DateUtil;
import ma.sir.vaccination.bean.history.EtatDoseHistory;
import ma.sir.vaccination.bean.core.EtatDose;
import ma.sir.vaccination.ws.dto.EtatDoseDto;

@Component
public class EtatDoseConverter extends AbstractConverter<EtatDose, EtatDoseDto, EtatDoseHistory> {


    public  EtatDoseConverter(){
        super(EtatDose.class, EtatDoseDto.class, EtatDoseHistory.class);
    }

    @Override
    public EtatDose toItem(EtatDoseDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatDose item = new EtatDose();
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
    public EtatDoseDto toDto(EtatDose item) {
        if (item == null) {
            return null;
        } else {
            EtatDoseDto dto = new EtatDoseDto();
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
