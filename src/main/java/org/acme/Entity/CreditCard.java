package org.acme.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "enterprise")
public class CreditCard extends PanacheEntity {

    @Column(name = "cardnumber")
    private String cardnumber;

    @Column(name = "idclient")
    private String idclient;

    @Column(name = "pin")
    private Integer pin;

    @Column(name = "expirationdate")
    private String expirationdate;

    @Column(name = "validationcode")
    private Integer validationcode;

    @Column(name = "cutoffdate")
    private String cutoffdate;

    @Column(name = "monthlypaydate")
    private String monthlypaydate;

    @Column(name = "currentbalance")
    private Double currentbalance;

    @Column(name = "creditlimit")
    private Integer creditlimit;

    @Column(name = "state")
    private Integer state;

    public CreditCard(String cardnumber, String idclient, Integer pin, String expirationdate, Integer validationcode, String cutoffdate, String monthlypaydate, Double currentbalance, Integer creditlimit, Integer state) {
        this.cardnumber = cardnumber;
        this.idclient = idclient;
        this.pin = pin;
        this.expirationdate = expirationdate;
        this.validationcode = validationcode;
        this.cutoffdate = cutoffdate;
        this.monthlypaydate = monthlypaydate;
        this.currentbalance = currentbalance;
        this.creditlimit = creditlimit;
        this.state = state;
    }

    public CreditCard() {
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getIdclient() {
        return idclient;
    }

    public void setIdclient(String idclient) {
        this.idclient = idclient;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public Integer getValidationcode() {
        return validationcode;
    }

    public void setValidationcode(Integer validationcode) {
        this.validationcode = validationcode;
    }

    public String getCutoffdate() {
        return cutoffdate;
    }

    public void setCutoffdate(String cutoffdate) {
        this.cutoffdate = cutoffdate;
    }

    public String getMonthlypaydate() {
        return monthlypaydate;
    }

    public void setMonthlypaydate(String monthlypaydate) {
        this.monthlypaydate = monthlypaydate;
    }

    public Double getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(Double currentbalance) {
        this.currentbalance = currentbalance;
    }

    public Integer getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(Integer creditlimit) {
        this.creditlimit = creditlimit;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
