package org.re.reforwardingbe.sea.main.domain.specification;

import lombok.Builder;
import lombok.Getter;
import org.re.reforwardingbe.sea.main.domain.model.*;

import java.math.BigDecimal;

@Getter
public class ManifestSpec {
    private final EntityId<BLId> rootBlId;
    private final EntityId <Manifest> manifestId;
    private final String manifestNo;
    private Integer manifestQuantity;
    private PackageUnit manifestUnit;
    private BigDecimal manifestWeight;

    public ManifestSpec(EntityId <BLId> rootBlId, EntityId <Manifest> manifestId, String manifestNo, Integer manifestQuantity, PackageUnit manifestUnit, BigDecimal manifestWeight) {
        this.rootBlId = rootBlId;
        this.manifestId = manifestId;
        this.manifestNo = manifestNo;
        this.manifestQuantity = manifestQuantity;
        this.manifestUnit = manifestUnit;
        this.manifestWeight = manifestWeight;
    }

    public ManifestSpec(EntityId <BLId> rootBlId, EntityId <Manifest> manifestId, String manifestNo) {
        this.rootBlId = rootBlId;
        this.manifestId = manifestId;
        this.manifestNo = manifestNo;
    }
}
