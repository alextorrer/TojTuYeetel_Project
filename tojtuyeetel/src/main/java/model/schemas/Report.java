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

    private String title;
    private String description;

    //Varios reportes pueden ser de un cultivo
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

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

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }
}
