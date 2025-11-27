package org.re.reforwardingbe.sea.main.domain.model;

public record Contract(Incoterms incoterms, FreightTerm freightTerm, PayableAt payableAt, Boolean isTriangleTrade) {
}
