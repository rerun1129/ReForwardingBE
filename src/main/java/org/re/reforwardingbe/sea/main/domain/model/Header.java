package org.re.reforwardingbe.sea.main.domain.model;

public record Header(ShipmentType shipmentType, String houseBlNumber, String masterBlNumber, LoadType loadType, ServiceTerm serviceTerm, BLType blType) {
    public Header(ShipmentType shipmentType, String houseBlNumber, LoadType loadType, BLType blType) {
        this(shipmentType, houseBlNumber, "", loadType, null, blType);
    }
}
