package ma.sir.vaccination.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "medecin")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="medecin_seq",sequenceName="medecin_seq",allocationSize=1, initialValue = 1)
public class MedecinHistory extends HistBusinessObject  {


    public MedecinHistory() {
    super();
    }

    public MedecinHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="medecin_seq")
    public Long getId() {
    return id;
    }
}

