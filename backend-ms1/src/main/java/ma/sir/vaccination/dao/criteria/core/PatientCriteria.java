package  ma.sir.vaccination.dao.criteria.core;


import ma.sir.vaccination.zynerator.criteria.BaseCriteria;
import java.util.List;

public class PatientCriteria extends  BaseCriteria  {

    private String ipp;
    private String ippLike;
    private String email;
    private String emailLike;
    private String cin;
    private String cinLike;
    private String nom;
    private String nomLike;
    private String prenom;
    private String prenomLike;
    private String age;
    private String ageMin;
    private String ageMax;

    private VilleCriteria ville ;
    private List<VilleCriteria> villes ;
    private GenderCriteria gender ;
    private List<GenderCriteria> genders ;


    public PatientCriteria(){}

    public String getIpp(){
        return this.ipp;
    }
    public void setIpp(String ipp){
        this.ipp = ipp;
    }
    public String getIppLike(){
        return this.ippLike;
    }
    public void setIppLike(String ippLike){
        this.ippLike = ippLike;
    }

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

    public String getAge(){
        return this.age;
    }
    public void setAge(String age){
        this.age = age;
    }   
    public String getAgeMin(){
        return this.ageMin;
    }
    public void setAgeMin(String ageMin){
        this.ageMin = ageMin;
    }
    public String getAgeMax(){
        return this.ageMax;
    }
    public void setAgeMax(String ageMax){
        this.ageMax = ageMax;
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
    public GenderCriteria getGender(){
        return this.gender;
    }

    public void setGender(GenderCriteria gender){
        this.gender = gender;
    }
    public List<GenderCriteria> getGenders(){
        return this.genders;
    }

    public void setGenders(List<GenderCriteria> genders){
        this.genders = genders;
    }
}
