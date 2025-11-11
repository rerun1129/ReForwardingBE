package org.re.reforwardingbe.sea.main.domain.vo;

public record Header(ShipmentType shipmentType, String houseBlNumber, String masterBlNumber, LoadType loadType, ServiceTerm serviceTerm, BLType blType) {
}
