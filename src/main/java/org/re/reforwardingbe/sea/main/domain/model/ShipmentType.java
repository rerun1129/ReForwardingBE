package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;

@Getter
public enum ShipmentType {
    HOUSE("H"),
    DIRECT("D");

    private final String code;

    ShipmentType(String code) {
        this.code = code;
    }

}
