package conv.sample.converter.model;


import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "transactions")
public class TransactList {

    private List<Transac> transacs;

    @XmlElement(name = "transaction")
    public List<Transac> getTransactions() {

        return transacs;

    }


    public void setTransactions(List<Transac> transacs) {

        this.transacs = transacs;

    }

}