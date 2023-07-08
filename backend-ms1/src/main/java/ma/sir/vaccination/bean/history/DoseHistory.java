package ma.sir.vaccination.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "dose")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="dose_seq",sequenceName="dose_seq",allocationSize=1, initialValue = 1)
public class DoseHistory extends HistBusinessObject  {


    public DoseHistory() {
    super();
    }

    public DoseHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="dose_seq")
    public Long getId() {
    return id;
    }
}

