package ma.sir.vaccination.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "categorie_rdv")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="categorie_rdv_seq",sequenceName="categorie_rdv_seq",allocationSize=1, initialValue = 1)
public class CategorieRdv   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;
    private Integer nombreDose = 0;
    private Integer dureeDose = 0;



    public CategorieRdv(){
        super();
    }

    public CategorieRdv(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="categorie_rdv_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public Integer getNombreDose(){
        return this.nombreDose;
    }
    public void setNombreDose(Integer nombreDose){
        this.nombreDose = nombreDose;
    }
    public Integer getDureeDose(){
        return this.dureeDose;
    }
    public void setDureeDose(Integer dureeDose){
        this.dureeDose = dureeDose;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieRdv categorieRdv = (CategorieRdv) o;
        return id != null && id.equals(categorieRdv.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

