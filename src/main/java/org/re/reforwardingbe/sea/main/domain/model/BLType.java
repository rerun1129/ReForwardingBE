package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;

@Getter
public enum BLType {
    ORIGINAL("O"),
    SURRENDER("R"),
    SEAWAYBILL("S");

    private final String code;

    BLType(String code) {
        this.code = code;
    }
}
