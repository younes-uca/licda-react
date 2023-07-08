package  ma.sir.vaccination.ws.dto;

import ma.sir.vaccination.zynerator.audit.Log;
import ma.sir.vaccination.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategorieRdvDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;
    private Integer nombreDose  = 0 ;
    private Integer dureeDose  = 0 ;




    public CategorieRdvDto(){
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

    @Log
    public Integer getNombreDose(){
        return this.nombreDose;
    }
    public void setNombreDose(Integer nombreDose){
        this.nombreDose = nombreDose;
    }

    @Log
    public Integer getDureeDose(){
        return this.dureeDose;
    }
    public void setDureeDose(Integer dureeDose){
        this.dureeDose = dureeDose;
    }






}
