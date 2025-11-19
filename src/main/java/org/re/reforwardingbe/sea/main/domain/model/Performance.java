package org.re.reforwardingbe.sea.main.domain.model;

public record Performance(Customer customer, Partner documentPartner, Partner settlementPartner, BusinessUser salesMan, BusinessUser operator, BusinessTeam team) {
    public Performance(Customer customer, Partner documentPartner, BusinessUser operator, BusinessTeam team) {
        this(customer, documentPartner, null, null, operator, team);
    }
}
