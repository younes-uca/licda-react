package ma.sir.vaccination.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "quartier")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="quartier_seq",sequenceName="quartier_seq",allocationSize=1, initialValue = 1)
public class Quartier   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;

    private Ville ville ;
    


    public Quartier(){
        super();
    }

    public Quartier(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="quartier_seq")
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
    @ManyToOne(fetch = FetchType.LAZY)
    public Ville getVille(){
        return this.ville;
    }
    public void setVille(Ville ville){
        this.ville = ville;
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
        Quartier quartier = (Quartier) o;
        return id != null && id.equals(quartier.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

