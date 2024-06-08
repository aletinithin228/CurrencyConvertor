package conv.sample.converter.model;


import com.fasterxml.jackson.annotation.JsonProperty;


import javax.xml.bind.annotation.XmlElement;


public class Transac {

    @JsonProperty("OriginalCurrency")
    private String originalCurrency;

    @JsonProperty("TargetCurrency")
    private String targetCurrency;

    @JsonProperty("Amount")
    private double amount;


    // Getter and setter for originalCurrency
    @XmlElement(name = "OriginalCurrency")
    public String getOriginalCurrency() {

        return originalCurrency;

    }


    public void setOriginalCurrency(String originalCurrency) {

        this.originalCurrency = originalCurrency;

    }


    // Getter and setter for targetCurrency
    @XmlElement(name = "TargetCurrency")
    public String getTargetCurrency() {

        return targetCurrency;

    }


    public void setTargetCurrency(String targetCurrency) {

        this.targetCurrency = targetCurrency;

    }


    // Getter and setter for amount
    @XmlElement(name = "Amount")
    public double getAmount() {

        return amount;

    }


    public void setAmount(double amount) {

        this.amount = amount;

    }

}

