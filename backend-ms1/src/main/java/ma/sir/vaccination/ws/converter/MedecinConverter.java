package  ma.sir.vaccination.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.vaccination.zynerator.util.StringUtil;
import ma.sir.vaccination.zynerator.converter.AbstractConverter;
import ma.sir.vaccination.zynerator.util.DateUtil;
import ma.sir.vaccination.bean.history.MedecinHistory;
import ma.sir.vaccination.bean.core.Medecin;
import ma.sir.vaccination.ws.dto.MedecinDto;

@Component
public class MedecinConverter extends AbstractConverter<Medecin, MedecinDto, MedecinHistory> {

    @Autowired
    private CenterConverter centerConverter ;
    private boolean center;

    public  MedecinConverter(){
        super(Medecin.class, MedecinDto.class, MedecinHistory.class);
    }

    @Override
    public Medecin toItem(MedecinDto dto) {
        if (dto == null) {
            return null;
        } else {
        Medecin item = new Medecin();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(StringUtil.isNotEmpty(dto.getCin()))
                item.setCin(dto.getCin());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getPrenom()))
                item.setPrenom(dto.getPrenom());
            if(this.center && dto.getCenter()!=null)
                item.setCenter(centerConverter.toItem(dto.getCenter())) ;



        return item;
        }
    }

    @Override
    public MedecinDto toDto(Medecin item) {
        if (item == null) {
            return null;
        } else {
            MedecinDto dto = new MedecinDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(StringUtil.isNotEmpty(item.getCin()))
                dto.setCin(item.getCin());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getPrenom()))
                dto.setPrenom(item.getPrenom());
        if(this.center && item.getCenter()!=null) {
            dto.setCenter(centerConverter.toDto(item.getCenter())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.center = value;
    }


    public CenterConverter getCenterConverter(){
        return this.centerConverter;
    }
    public void setCenterConverter(CenterConverter centerConverter ){
        this.centerConverter = centerConverter;
    }
    public boolean  isCenter(){
        return this.center;
    }
    public void  setCenter(boolean center){
        this.center = center;
    }
}
