package  ma.sir.vaccination.dao.criteria.core;


import ma.sir.vaccination.zynerator.criteria.BaseCriteria;
import java.util.List;

public class MedecinCriteria extends  BaseCriteria  {

    private String email;
    private String emailLike;
    private String cin;
    private String cinLike;
    private String nom;
    private String nomLike;
    private String prenom;
    private String prenomLike;

    private CenterCriteria center ;
    private List<CenterCriteria> centers ;


    public MedecinCriteria(){}

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmailLike(){
        return this.emailLike;
    }
    public void setEmailLike(String emailLike){
        this.emailLike = emailLike;
    }

    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }
    public String getCinLike(){
        return this.cinLike;
    }
    public void setCinLike(String cinLike){
        this.cinLike = cinLike;
    }

    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNomLike(){
        return this.nomLike;
    }
    public void setNomLike(String nomLike){
        this.nomLike = nomLike;
    }

    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getPrenomLike(){
        return this.prenomLike;
    }
    public void setPrenomLike(String prenomLike){
        this.prenomLike = prenomLike;
    }


    public CenterCriteria getCenter(){
        return this.center;
    }

    public void setCenter(CenterCriteria center){
        this.center = center;
    }
    public List<CenterCriteria> getCenters(){
        return this.centers;
    }

    public void setCenters(List<CenterCriteria> centers){
        this.centers = centers;
    }
}
