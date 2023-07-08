package ma.sir.vaccination.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "ville")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="ville_seq",sequenceName="ville_seq",allocationSize=1, initialValue = 1)
public class VilleHistory extends HistBusinessObject  {


    public VilleHistory() {
    super();
    }

    public VilleHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="ville_seq")
    public Long getId() {
    return id;
    }
}

