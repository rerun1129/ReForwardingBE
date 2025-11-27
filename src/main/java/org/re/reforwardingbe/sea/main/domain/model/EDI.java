package org.re.reforwardingbe.sea.main.domain.model;

public record EDI(String ediBlNo, String ediBlItem, CargoClass cargoClass, SeaPort transshipmentPort) {
}
