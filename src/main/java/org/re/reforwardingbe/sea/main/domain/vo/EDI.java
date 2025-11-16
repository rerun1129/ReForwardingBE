package org.re.reforwardingbe.sea.main.domain.vo;

public record EDI(String ediBlNo, String ediBlItem, CargoClass cargoClass, SeaPort transshipmentPort) {
}
