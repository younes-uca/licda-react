package  ma.sir.vaccination.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.vaccination.bean.core.RendezVous;

import ma.sir.vaccination.zynerator.util.StringUtil;
import ma.sir.vaccination.zynerator.converter.AbstractConverter;
import ma.sir.vaccination.zynerator.util.DateUtil;
import ma.sir.vaccination.bean.history.EffetIndesirableHistory;
import ma.sir.vaccination.bean.core.EffetIndesirable;
import ma.sir.vaccination.ws.dto.EffetIndesirableDto;

@Component
public class EffetIndesirableConverter extends AbstractConverter<EffetIndesirable, EffetIndesirableDto, EffetIndesirableHistory> {

    @Autowired
    private RendezVousConverter rendezVousConverter ;
    private boolean rendezVous;

    public  EffetIndesirableConverter(){
        super(EffetIndesirable.class, EffetIndesirableDto.class, EffetIndesirableHistory.class);
    }

    @Override
    public EffetIndesirable toItem(EffetIndesirableDto dto) {
        if (dto == null) {
            return null;
        } else {
        EffetIndesirable item = new EffetIndesirable();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateFait()))
                item.setDateFait(DateUtil.stringEnToDate(dto.getDateFait()));
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getRendezVous() != null && dto.getRendezVous().getId() != null){
                item.setRendezVous(new RendezVous());
                item.getRendezVous().setId(dto.getRendezVous().getId());
            }



        return item;
        }
    }

    @Override
    public EffetIndesirableDto toDto(EffetIndesirable item) {
        if (item == null) {
            return null;
        } else {
            EffetIndesirableDto dto = new EffetIndesirableDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateFait()!=null)
                dto.setDateFait(DateUtil.dateTimeToString(item.getDateFait()));
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.rendezVous && item.getRendezVous()!=null) {
            dto.setRendezVous(rendezVousConverter.toDto(item.getRendezVous())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.rendezVous = value;
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
}
