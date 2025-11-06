package org.re.reforwardingbe.sea.main.domain.vo;

import lombok.Getter;

@Getter
public enum LoadType {
    LCL("L"),
    FCL("F"),
    BULK("B");

    private final String code;

    LoadType(String value) {
        this.code = value;
    }

}
