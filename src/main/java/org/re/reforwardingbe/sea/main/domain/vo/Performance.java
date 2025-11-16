package org.re.reforwardingbe.sea.main.domain.vo;

public record Performance(Customer customer, Partner documentPartner, Partner settlementPartner, BusinessUser salesMan, BusinessUser operator, BusinessTeam businessTeam) {
}
