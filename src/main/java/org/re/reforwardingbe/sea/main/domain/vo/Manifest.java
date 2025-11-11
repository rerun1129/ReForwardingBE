package org.re.reforwardingbe.sea.main.domain.vo;

import java.math.BigDecimal;

public class Manifest {
    private final String manifestNo;
    private final Integer manifestQuantity;
    private final PackageUnit manifestUnit;
    private final BigDecimal manifestWeight;

    public Manifest(String manifestNo, Integer manifestQuantity, PackageUnit manifestUnit, BigDecimal manifestWeight) {
        this.manifestNo = manifestNo;
        this.manifestQuantity = manifestQuantity;
        this.manifestUnit = manifestUnit;
        this.manifestWeight = manifestWeight;
    }
}
