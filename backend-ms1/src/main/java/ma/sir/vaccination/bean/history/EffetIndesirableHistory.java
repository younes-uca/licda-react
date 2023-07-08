package ma.sir.vaccination.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "effet_indesirable")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="effet_indesirable_seq",sequenceName="effet_indesirable_seq",allocationSize=1, initialValue = 1)
public class EffetIndesirableHistory extends HistBusinessObject  {


    public EffetIndesirableHistory() {
    super();
    }

    public EffetIndesirableHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="effet_indesirable_seq")
    public Long getId() {
    return id;
    }
}

