package  ma.sir.vaccination.ws.dto;

import ma.sir.vaccination.zynerator.audit.Log;
import ma.sir.vaccination.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class CenterDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;

    private QuartierDto quartier ;



    public CenterDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }


    public QuartierDto getQuartier(){
        return this.quartier;
    }

    public void setQuartier(QuartierDto quartier){
        this.quartier = quartier;
    }




}
