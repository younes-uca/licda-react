package ma.sir.vaccination.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "center")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="center_seq",sequenceName="center_seq",allocationSize=1, initialValue = 1)
public class Center   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;

    private Quartier quartier ;
    


    public Center(){
        super();
    }

    public Center(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="center_seq")
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
    public Quartier getQuartier(){
        return this.quartier;
    }
    public void setQuartier(Quartier quartier){
        this.quartier = quartier;
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
        Center center = (Center) o;
        return id != null && id.equals(center.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

