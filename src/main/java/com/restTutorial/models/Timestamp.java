package com.restTutorial.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public abstract class Timestamp {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdTimestamp", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedTimestamp", nullable = false)
    private Date updated;

    @PrePersist
    protected void onCreate() {
    updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    updated = new Date();
    }
	
}
