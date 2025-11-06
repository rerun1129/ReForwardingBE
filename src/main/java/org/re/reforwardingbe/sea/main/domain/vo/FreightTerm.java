package org.re.reforwardingbe.sea.main.domain.vo;

import lombok.Getter;

@Getter
public enum FreightTerm {
    COLLECT("C"),
    PREPAID("D");

    private final String code;

    FreightTerm(String code) {
        this.code = code;
    }
}
