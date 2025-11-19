package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;
import org.re.reforwardingbe.sea.main.domain.specification.HSCodeSpec;
import org.re.reforwardingbe.sea.main.domain.specification.ManifestSpec;

import java.math.BigDecimal;

public class Manifest {
    @Getter
    private EntityId<BLId> rootBlId;
    @Getter
    private EntityId <Manifest> manifestId;
    private String manifestNo;
    private Integer manifestQuantity;
    private PackageUnit manifestUnit;
    private BigDecimal manifestWeight;

    private Manifest() {
    }

    private Manifest(ManifestSpec spec) {
        this.rootBlId = spec.getRootBlId();
        this.manifestId = spec.getManifestId();
        this.manifestNo = spec.getManifestNo();
        this.manifestQuantity = spec.getManifestQuantity();
        this.manifestUnit = spec.getManifestUnit();
        this.manifestWeight = spec.getManifestWeight();
    }

    public static Manifest of(ManifestSpec spec) {
        return new Manifest(spec);
    }

    public static Manifest withEssential(EntityId<BLId> rootBlId, EntityId <Manifest> manifestId, String manifestNo) {
        ManifestSpec spec = ManifestSpec.builder().rootBlId(rootBlId).manifestId(manifestId).manifestNo(manifestNo).build();
        return new Manifest(spec);
    }

    public static Manifest empty() {
        return new Manifest();
    }
}
