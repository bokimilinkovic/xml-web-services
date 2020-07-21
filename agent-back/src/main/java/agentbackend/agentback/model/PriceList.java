package agentbackend.agentback.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pricelist")
public class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "priceList_id_seq_gen")
    @SequenceGenerator(name="priceList_id_seq_gen", sequenceName = "priceList_id_seq", allocationSize = 1)
    protected long id;

    protected String name;
    
    protected String owner;

    @ManyToMany
    @JoinTable(
            name = "pricelist_price",
            joinColumns =  @JoinColumn(name = "pricelist_id"),
            inverseJoinColumns = @JoinColumn(name = "price_id")
    )
    protected List<Price> prices;

    public PriceList() {
    }


    public PriceList(String name, String email){
        this.name = name;
        this.owner = email;
        this.prices = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner){
    	this.owner = owner;
    }
    
    public String getOwner(){
    	return this.owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}