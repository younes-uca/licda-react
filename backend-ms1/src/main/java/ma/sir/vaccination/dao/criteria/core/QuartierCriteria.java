package  ma.sir.vaccination.dao.criteria.core;


import ma.sir.vaccination.zynerator.criteria.BaseCriteria;
import java.util.List;

public class QuartierCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String libelle;
    private String libelleLike;

    private VilleCriteria ville ;
    private List<VilleCriteria> villes ;


    public QuartierCriteria(){}

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


    public VilleCriteria getVille(){
        return this.ville;
    }

    public void setVille(VilleCriteria ville){
        this.ville = ville;
    }
    public List<VilleCriteria> getVilles(){
        return this.villes;
    }

    public void setVilles(List<VilleCriteria> villes){
        this.villes = villes;
    }
}
