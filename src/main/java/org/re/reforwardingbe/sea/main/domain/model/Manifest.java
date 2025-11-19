package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;

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

    //TODO : 필수 값을 담은 생성자와 모든 값을 담는 생성자를 분리 / 정적 팩토리 메서드로 작성할 수 있는 구조
    public Manifest(EntityId<BLId> rootBlId, EntityId <Manifest> manifestId, String manifestNo, Integer manifestQuantity, PackageUnit manifestUnit, BigDecimal manifestWeight) {
        this.rootBlId = rootBlId;
        this.manifestId = manifestId;
        this.manifestNo = manifestNo;
        this.manifestQuantity = manifestQuantity;
        this.manifestUnit = manifestUnit;
        this.manifestWeight = manifestWeight;
    }

    public Manifest() {
    }
}
