package org.studyeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="files")
@Table (name="files")
public class Files {
    @Id
    @Column(name="id")
    int id;
    @Column(name="file_name")
    String filename;
    @Column(name="label")
    String label;
    @Column(name="caption")
    String caption;

    public Files(String filename) {
        this.filename = filename;
    }

    public Files() {

    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", label='" + label + '\'' +
                ", caption='" + caption + '\'' +
                '}';
    }
}
