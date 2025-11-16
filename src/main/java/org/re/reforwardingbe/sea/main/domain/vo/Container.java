package org.re.reforwardingbe.sea.main.domain.vo;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

public class Container {
    @Getter
    private final UUID rootBlId;
    @Getter
    private final UUID containerId;
    private final String containerNo;
    private final ContainerType containerType;
    private String containerSealNumber1;
    private String containerSealNumber2;
    private String containerSealNumber3;
    private String containerSealNumber4;
    private String containerSealNumber5;
    private String containerSealNumber6;
    private Integer packageQuantity;
    private PackageUnit packageUnit;
    private BigDecimal grossWeight;
    private BigDecimal cbm;

    public Container(UUID rootBlId, String containerNo, ContainerType containerType, String containerSealNumber1,
                     String containerSealNumber2, String containerSealNumber3, String containerSealNumber4,
                     String containerSealNumber5, String containerSealNumber6, Integer packageQuantity,
                     PackageUnit packageUnit, BigDecimal grossWeight, BigDecimal cbm) {
        this.rootBlId = rootBlId;
        this.containerId = UUID.randomUUID();
        this.containerNo = containerNo;
        this.containerType = containerType;
        this.containerSealNumber1 = containerSealNumber1;
        this.containerSealNumber2 = containerSealNumber2;
        this.containerSealNumber3 = containerSealNumber3;
        this.containerSealNumber4 = containerSealNumber4;
        this.containerSealNumber5 = containerSealNumber5;
        this.containerSealNumber6 = containerSealNumber6;
        this.packageQuantity = packageQuantity;
        this.packageUnit = packageUnit;
        this.grossWeight = grossWeight;
        this.cbm = cbm;
    }

    public Container(UUID rootBlId, String containerNo, ContainerType containerType) {
        this.rootBlId = rootBlId;
        this.containerId = UUID.randomUUID();
        this.containerNo = containerNo;
        this.containerType = containerType;
    }
}
