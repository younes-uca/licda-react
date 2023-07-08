package  ma.sir.vaccination.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.vaccination.zynerator.util.StringUtil;
import ma.sir.vaccination.zynerator.converter.AbstractConverter;
import ma.sir.vaccination.zynerator.util.DateUtil;
import ma.sir.vaccination.bean.history.QuartierHistory;
import ma.sir.vaccination.bean.core.Quartier;
import ma.sir.vaccination.ws.dto.QuartierDto;

@Component
public class QuartierConverter extends AbstractConverter<Quartier, QuartierDto, QuartierHistory> {

    @Autowired
    private VilleConverter villeConverter ;
    private boolean ville;

    public  QuartierConverter(){
        super(Quartier.class, QuartierDto.class, QuartierHistory.class);
    }

    @Override
    public Quartier toItem(QuartierDto dto) {
        if (dto == null) {
            return null;
        } else {
        Quartier item = new Quartier();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(this.ville && dto.getVille()!=null)
                item.setVille(villeConverter.toItem(dto.getVille())) ;



        return item;
        }
    }

    @Override
    public QuartierDto toDto(Quartier item) {
        if (item == null) {
            return null;
        } else {
            QuartierDto dto = new QuartierDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
        if(this.ville && item.getVille()!=null) {
            dto.setVille(villeConverter.toDto(item.getVille())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.ville = value;
    }


    public VilleConverter getVilleConverter(){
        return this.villeConverter;
    }
    public void setVilleConverter(VilleConverter villeConverter ){
        this.villeConverter = villeConverter;
    }
    public boolean  isVille(){
        return this.ville;
    }
    public void  setVille(boolean ville){
        this.ville = ville;
    }
}
