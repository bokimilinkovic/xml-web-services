package team10.codebook.models;

import javax.persistence.*;

@Entity
@Table(name = "class")
public class CarClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "car_class_id_seq")
    private Long id;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    public CarClass() {
    }

    public CarClass(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
