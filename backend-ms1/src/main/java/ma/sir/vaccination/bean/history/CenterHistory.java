package ma.sir.vaccination.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "center")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="center_seq",sequenceName="center_seq",allocationSize=1, initialValue = 1)
public class CenterHistory extends HistBusinessObject  {


    public CenterHistory() {
    super();
    }

    public CenterHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="center_seq")
    public Long getId() {
    return id;
    }
}

