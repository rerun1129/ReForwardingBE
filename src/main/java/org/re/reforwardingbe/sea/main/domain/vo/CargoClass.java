package org.re.reforwardingbe.sea.main.domain.vo;

import lombok.Getter;

@Getter
public enum CargoClass {
    EXPORT("E"),
    IMPORT("I"),
    TRANSSHIPMENT("T");

    private final String code;

    CargoClass(String code) {
        this.code = code;
    }
}
