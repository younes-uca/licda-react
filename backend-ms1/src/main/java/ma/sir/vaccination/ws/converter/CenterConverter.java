package  ma.sir.vaccination.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.vaccination.zynerator.util.StringUtil;
import ma.sir.vaccination.zynerator.converter.AbstractConverter;
import ma.sir.vaccination.zynerator.util.DateUtil;
import ma.sir.vaccination.bean.history.CenterHistory;
import ma.sir.vaccination.bean.core.Center;
import ma.sir.vaccination.ws.dto.CenterDto;

@Component
public class CenterConverter extends AbstractConverter<Center, CenterDto, CenterHistory> {

    @Autowired
    private QuartierConverter quartierConverter ;
    private boolean quartier;

    public  CenterConverter(){
        super(Center.class, CenterDto.class, CenterHistory.class);
    }

    @Override
    public Center toItem(CenterDto dto) {
        if (dto == null) {
            return null;
        } else {
        Center item = new Center();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(this.quartier && dto.getQuartier()!=null)
                item.setQuartier(quartierConverter.toItem(dto.getQuartier())) ;



        return item;
        }
    }

    @Override
    public CenterDto toDto(Center item) {
        if (item == null) {
            return null;
        } else {
            CenterDto dto = new CenterDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
        if(this.quartier && item.getQuartier()!=null) {
            dto.setQuartier(quartierConverter.toDto(item.getQuartier())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.quartier = value;
    }


    public QuartierConverter getQuartierConverter(){
        return this.quartierConverter;
    }
    public void setQuartierConverter(QuartierConverter quartierConverter ){
        this.quartierConverter = quartierConverter;
    }
    public boolean  isQuartier(){
        return this.quartier;
    }
    public void  setQuartier(boolean quartier){
        this.quartier = quartier;
    }
}
