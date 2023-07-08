package  ma.sir.vaccination.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.vaccination.zynerator.util.StringUtil;
import ma.sir.vaccination.zynerator.converter.AbstractConverter;
import ma.sir.vaccination.zynerator.util.DateUtil;
import ma.sir.vaccination.bean.history.CategorieRdvHistory;
import ma.sir.vaccination.bean.core.CategorieRdv;
import ma.sir.vaccination.ws.dto.CategorieRdvDto;

@Component
public class CategorieRdvConverter extends AbstractConverter<CategorieRdv, CategorieRdvDto, CategorieRdvHistory> {


    public  CategorieRdvConverter(){
        super(CategorieRdv.class, CategorieRdvDto.class, CategorieRdvHistory.class);
    }

    @Override
    public CategorieRdv toItem(CategorieRdvDto dto) {
        if (dto == null) {
            return null;
        } else {
        CategorieRdv item = new CategorieRdv();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getNombreDose()))
                item.setNombreDose(dto.getNombreDose());
            if(StringUtil.isNotEmpty(dto.getDureeDose()))
                item.setDureeDose(dto.getDureeDose());


        return item;
        }
    }

    @Override
    public CategorieRdvDto toDto(CategorieRdv item) {
        if (item == null) {
            return null;
        } else {
            CategorieRdvDto dto = new CategorieRdvDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getNombreDose()))
                dto.setNombreDose(item.getNombreDose());
            if(StringUtil.isNotEmpty(item.getDureeDose()))
                dto.setDureeDose(item.getDureeDose());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
