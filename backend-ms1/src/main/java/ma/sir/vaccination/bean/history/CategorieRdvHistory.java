package ma.sir.vaccination.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "categorie_rdv")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="categorie_rdv_seq",sequenceName="categorie_rdv_seq",allocationSize=1, initialValue = 1)
public class CategorieRdvHistory extends HistBusinessObject  {


    public CategorieRdvHistory() {
    super();
    }

    public CategorieRdvHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="categorie_rdv_seq")
    public Long getId() {
    return id;
    }
}

