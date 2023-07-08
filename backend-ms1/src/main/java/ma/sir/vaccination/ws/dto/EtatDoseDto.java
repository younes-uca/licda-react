package  ma.sir.vaccination.ws.dto;

import ma.sir.vaccination.zynerator.audit.Log;
import ma.sir.vaccination.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class EtatDoseDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;




    public EtatDoseDto(){
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






}
