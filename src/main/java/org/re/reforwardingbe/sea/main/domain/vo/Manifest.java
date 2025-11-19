package org.re.reforwardingbe.sea.main.domain.vo;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

public class Manifest {
    @Getter
    private final UUID rootBlId;
    @Getter
    private final UUID manifestId;
    private final String manifestNo;
    private final Integer manifestQuantity;
    private final PackageUnit manifestUnit;
    private final BigDecimal manifestWeight;

    public Manifest(UUID rootBlId, String manifestNo, Integer manifestQuantity, PackageUnit manifestUnit, BigDecimal manifestWeight) {
        this.rootBlId = rootBlId;
        this.manifestId = UUID.randomUUID();
        this.manifestNo = manifestNo;
        this.manifestQuantity = manifestQuantity;
        this.manifestUnit = manifestUnit;
        this.manifestWeight = manifestWeight;
    }
}
