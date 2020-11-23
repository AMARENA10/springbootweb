package org.example.springbootweb.entity;

import javax.persistence.*;

@Entity
//@Audited
@Table(name="property")
public class Property {
    @Id
    private Long id;

    @Column(name="propertyCode")
    private String propertyCode;

    @Column(name="propertyValue")
    private String propertyValue;

    public Property() {
    }

    public Property(Long id, String propertyCode, String propertyValue) {
        this.id = id;
        this.propertyCode = propertyCode;
        this.propertyValue = propertyValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
