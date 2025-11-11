package org.re.reforwardingbe.sea.main.domain.vo;

public record Contract(Incoterms incoterms, FreightTerm freightTerm, PayableAt payableAt, Boolean isTriangleTrade) {
}
