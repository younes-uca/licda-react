package ma.sir.vaccination.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "rendez_vous")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="rendez_vous_seq",sequenceName="rendez_vous_seq",allocationSize=1, initialValue = 1)
public class RendezVousHistory extends HistBusinessObject  {


    public RendezVousHistory() {
    super();
    }

    public RendezVousHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="rendez_vous_seq")
    public Long getId() {
    return id;
    }
}

