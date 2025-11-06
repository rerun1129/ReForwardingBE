package org.re.reforwardingbe.sea.main.domain.vo;

import lombok.Getter;

@Getter
public enum UnknownClause1 {
    SLC("\"SHIPPER'S LOAD & COUNT\""),
    SLC2("\"SHIPPER'S LOAD AND COUNT\""),
    SLCSS("\"SHIPPER'S LOAD, COUNT, STOW & SEAL\""),
    SLCS("\"SHIPPER'S LOAD & COUNT & SEALED\""),
    SRD("\"SHIPPER'S RISK & DAMAGE FOR ON DECK CARGO\""),
    SLSWCS("\"SHIPPER'S LOAD, STOW, WEIGHT, COUNT & SEAL\"");

    private final String displayPhrase;

    UnknownClause1(String displayPhrase) {
        this.displayPhrase = displayPhrase;
    }
}
