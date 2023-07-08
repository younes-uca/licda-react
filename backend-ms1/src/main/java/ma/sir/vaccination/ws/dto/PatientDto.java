package  ma.sir.vaccination.ws.dto;

import ma.sir.vaccination.zynerator.audit.Log;
import ma.sir.vaccination.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDto  extends AuditBaseDto {

    private String ipp  ;
    private String email  ;
    private String cin  ;
    private String nom  ;
    private String prenom  ;
    private Integer age  = 0 ;

    private VilleDto ville ;
    private GenderDto gender ;



    public PatientDto(){
        super();
    }



    @Log
    public String getIpp(){
        return this.ipp;
    }
    public void setIpp(String ipp){
        this.ipp = ipp;
    }

    @Log
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Log
    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }

    @Log
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    @Log
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    @Log
    public Integer getAge(){
        return this.age;
    }
    public void setAge(Integer age){
        this.age = age;
    }


    public VilleDto getVille(){
        return this.ville;
    }

    public void setVille(VilleDto ville){
        this.ville = ville;
    }
    public GenderDto getGender(){
        return this.gender;
    }

    public void setGender(GenderDto gender){
        this.gender = gender;
    }




}
