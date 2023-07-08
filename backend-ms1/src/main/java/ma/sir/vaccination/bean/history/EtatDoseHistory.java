package ma.sir.vaccination.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "etat_dose")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_dose_seq",sequenceName="etat_dose_seq",allocationSize=1, initialValue = 1)
public class EtatDoseHistory extends HistBusinessObject  {


    public EtatDoseHistory() {
    super();
    }

    public EtatDoseHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="etat_dose_seq")
    public Long getId() {
    return id;
    }
}

