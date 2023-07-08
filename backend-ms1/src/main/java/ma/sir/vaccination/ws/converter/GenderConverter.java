package  ma.sir.vaccination.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.vaccination.zynerator.util.StringUtil;
import ma.sir.vaccination.zynerator.converter.AbstractConverter;
import ma.sir.vaccination.zynerator.util.DateUtil;
import ma.sir.vaccination.bean.history.GenderHistory;
import ma.sir.vaccination.bean.core.Gender;
import ma.sir.vaccination.ws.dto.GenderDto;

@Component
public class GenderConverter extends AbstractConverter<Gender, GenderDto, GenderHistory> {


    public  GenderConverter(){
        super(Gender.class, GenderDto.class, GenderHistory.class);
    }

    @Override
    public Gender toItem(GenderDto dto) {
        if (dto == null) {
            return null;
        } else {
        Gender item = new Gender();
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
    public GenderDto toDto(Gender item) {
        if (item == null) {
            return null;
        } else {
            GenderDto dto = new GenderDto();
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
