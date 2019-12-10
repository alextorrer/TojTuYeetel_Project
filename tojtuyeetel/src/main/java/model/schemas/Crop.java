package model.schemas;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Clase que representa la tabla de cultivos
 */

@Entity
public class Crop {

    @Id
    @GeneratedValue
    private Integer crop_id;

    @Column(nullable = false)
    private String crop_name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Date seed_date;

    @Column(nullable = false)
    private Date harvest_date;

    @Column(nullable = false)
    private boolean harvest_status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "crop_from_user_id", nullable = false)
    private User user;

    public Crop() {
    }

    public Integer getCrop_id() {
        return crop_id;
    }

    public void setCrop_id(Integer crop_id) {
        this.crop_id = crop_id;
    }

    public String getCrop_name() {
        return crop_name;
    }

    public void setCrop_name(String crop_name) {
        this.crop_name = crop_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getSeed_date() {
        return seed_date;
    }

    public void setSeed_date(Date seed_date) {
        this.seed_date = seed_date;
    }

    public Date getHarvest_date() {
        return harvest_date;
    }

    public void setHarvest_date(Date harvest_date) {
        this.harvest_date = harvest_date;
    }

    public boolean isHarvest_status() {
        return harvest_status;
    }

    public void setHarvest_status(boolean harvest_status) {
        this.harvest_status = harvest_status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    
}
