package  ma.sir.vaccination.dao.criteria.core;


import ma.sir.vaccination.zynerator.criteria.BaseCriteria;
import java.util.List;

public class CenterCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String libelle;
    private String libelleLike;

    private QuartierCriteria quartier ;
    private List<QuartierCriteria> quartiers ;


    public CenterCriteria(){}

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


    public QuartierCriteria getQuartier(){
        return this.quartier;
    }

    public void setQuartier(QuartierCriteria quartier){
        this.quartier = quartier;
    }
    public List<QuartierCriteria> getQuartiers(){
        return this.quartiers;
    }

    public void setQuartiers(List<QuartierCriteria> quartiers){
        this.quartiers = quartiers;
    }
}
