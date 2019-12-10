package model.schemas;

import javax.persistence.*;

/**
 * Clase que representa la tabla de reportes
 */

@Entity
public class Report {

    @Id
    @GeneratedValue
    private Integer report_id;

    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String plague;

    //Varios reportes pueden ser de un usuario
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "report_from_user_id", nullable = false)
    private User user;
    
    
    public Report() {
    }

    public Integer getReport_id() {
        return report_id;
    }

    public void setReport_id(Integer report_id) {
        this.report_id = report_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlague() {
        return plague;
    }

    public void setPlague(String plague) {
        this.plague = plague;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    
}
