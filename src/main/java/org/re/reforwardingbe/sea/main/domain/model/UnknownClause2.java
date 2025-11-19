package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;

@Getter
public enum UnknownClause2 {
    STC("SAID TO CONTAIN :"),
    STB("SAID TO BE :"),
    SWM("\"SHIPPER'S WEIGHT & MEASUREMENT\"");

    private final String displayName;

    UnknownClause2(String displayName) {
        this.displayName = displayName;
    }
}
