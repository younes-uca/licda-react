package  ma.sir.vaccination.dao.criteria.core;


import ma.sir.vaccination.zynerator.criteria.BaseCriteria;
import java.util.List;

public class CategorieRdvCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String libelle;
    private String libelleLike;
    private String nombreDose;
    private String nombreDoseMin;
    private String nombreDoseMax;
    private String dureeDose;
    private String dureeDoseMin;
    private String dureeDoseMax;



    public CategorieRdvCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getNombreDose(){
        return this.nombreDose;
    }
    public void setNombreDose(String nombreDose){
        this.nombreDose = nombreDose;
    }   
    public String getNombreDoseMin(){
        return this.nombreDoseMin;
    }
    public void setNombreDoseMin(String nombreDoseMin){
        this.nombreDoseMin = nombreDoseMin;
    }
    public String getNombreDoseMax(){
        return this.nombreDoseMax;
    }
    public void setNombreDoseMax(String nombreDoseMax){
        this.nombreDoseMax = nombreDoseMax;
    }
      
    public String getDureeDose(){
        return this.dureeDose;
    }
    public void setDureeDose(String dureeDose){
        this.dureeDose = dureeDose;
    }   
    public String getDureeDoseMin(){
        return this.dureeDoseMin;
    }
    public void setDureeDoseMin(String dureeDoseMin){
        this.dureeDoseMin = dureeDoseMin;
    }
    public String getDureeDoseMax(){
        return this.dureeDoseMax;
    }
    public void setDureeDoseMax(String dureeDoseMax){
        this.dureeDoseMax = dureeDoseMax;
    }
      

}
