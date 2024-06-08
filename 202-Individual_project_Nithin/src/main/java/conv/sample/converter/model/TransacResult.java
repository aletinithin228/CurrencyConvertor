package conv.sample.converter.model;


//public class TransactionResult {

//    private String originalCurrency;

//    private String targetCurrency;

//    private double originalAmount;

//    private double convertedAmount;

//    private String errorMessage;

//
//    // Getter and setter for originalCurrency
//    public String getOriginalCurrency() {

//        return originalCurrency;

//    }

//
//    public void setOriginalCurrency(String originalCurrency) {

//        this.originalCurrency = originalCurrency;

//    }

//
//    // Getter and setter for targetCurrency
//    public String getTargetCurrency() {

//        return targetCurrency;

//    }

//
//    public void setTargetCurrency(String targetCurrency) {

//        this.targetCurrency = targetCurrency;

//    }

//
//    // Getter and setter for originalAmount
//    public double getOriginalAmount() {

//        return originalAmount;

//    }

//
//    public void setOriginalAmount(double originalAmount) {

//        this.originalAmount = originalAmount;

//    }

//
//    // Getter and setter for convertedAmount
//    public double getConvertedAmount() {

//        return convertedAmount;

//    }

//
//    public void setConvertedAmount(double convertedAmount) {

//        this.convertedAmount = convertedAmount;

//    }

//
//    // Getter and setter for errorMessage
//    public String getErrorMessage() {

//        return errorMessage;

//    }

//
//    public void setErrorMessage(String errorMessage) {

//        this.errorMessage = errorMessage;

//    }

//}


import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = {"originalAmount", "originalCurrency", "targetCurrency", "convertedAmount", "errorMessage"})
@JsonPropertyOrder({"Amount", "OriginalCurrency", "TargetCurrency", "ConvertedAmount", "Status"})
@XmlRootElement(name = "transaction")
public class TransacResult {

    @JsonProperty("OriginalCurrency")
    private String originalCurrency;

    @JsonProperty("TargetCurrency")
    private String targetCurrency;

    @JsonProperty("Amount")
    private double originalAmount;

    @JsonProperty("ConvertedAmount")
    private double convertedAmount;

    @JsonProperty("Status")
    private String errorMessage;


//    public void setStatus(String status) {

//        this.status = status;

//    }

//
//    private String status;


    @XmlElement(name = "OriginalCurrency")
    public String getOriginalCurrency() {

        return originalCurrency;

    }


    public void setOriginalCurrency(String originalCurrency) {

        this.originalCurrency = originalCurrency;

    }


    @XmlElement(name = "TargetCurrency")
    public String getTargetCurrency() {

        return targetCurrency;

    }


    public void setTargetCurrency(String targetCurrency) {

        this.targetCurrency = targetCurrency;

    }


    @XmlElement(name = "Amount")
    public double getOriginalAmount() {

        return originalAmount;

    }


    public void setOriginalAmount(double originalAmount) {

        this.originalAmount = originalAmount;

    }


    @XmlElement(name = "ConvertedAmount")
    public double getConvertedAmount() {

        return convertedAmount;

    }


    public void setConvertedAmount(double convertedAmount) {

        this.convertedAmount = convertedAmount;

    }


//    @XmlElement(name = "Status")
//    public String getStatus() {

//        // Determine the status based on the presence of an error message
////        return (errorMessage == null || errorMessage.isEmpty()) ? "SucurrencyConverteress" : "Failure";

//        return status;

//    }


    // Not exposed via XML, only for internal use
    @XmlElement(name = "Status")
    public String getErrorMessage() {

        return errorMessage;

    }


    public void setErrorMessage(String errorMessage) {

        this.errorMessage = errorMessage;

    }

}

