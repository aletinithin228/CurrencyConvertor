package conv.sample.converter.model;


import com.fasterxml.jackson.annotation.JsonProperty;


import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


@XmlRootElement(name = "transactionResults")
public class TransacResultList {

    private List<TransacResult> results;


    @XmlElement(name = "transactionResult")
    @JsonProperty("transactions")
    public List<TransacResult> getResults() {

        return results;

    }


    public void setResults(List<TransacResult> results) {

        this.results = results;

    }

}

