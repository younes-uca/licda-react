package ma.sir.vaccination.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "etat_rendez_vous")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_rendez_vous_seq",sequenceName="etat_rendez_vous_seq",allocationSize=1, initialValue = 1)
public class EtatRendezVousHistory extends HistBusinessObject  {


    public EtatRendezVousHistory() {
    super();
    }

    public EtatRendezVousHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="etat_rendez_vous_seq")
    public Long getId() {
    return id;
    }
}

