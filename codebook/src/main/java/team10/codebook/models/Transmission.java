package team10.codebook.models;

import javax.persistence.*;

@Entity
@Table(name = "transmission")
public class Transmission {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transmission_id_seq_gen")
    @SequenceGenerator(name="transmission_id_seq_gen", sequenceName = "transmission_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", unique = false, nullable = false)
    private String type;

    public Transmission() {
    }

    public Transmission(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
