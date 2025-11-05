package org.re.reforwardingbe.sea.main.domain.vo;

import lombok.Getter;

@Getter
public enum ServiceTerm {
    CY_TO_CY("CY/CY"),
    CFS_TO_CY("CFS/CY"),
    CY_TO_CFS("CY/CFS"),
    BULK("BULK");

    private final String displayName;

    ServiceTerm(String displayName) {
        this.displayName = displayName;
    }
}
