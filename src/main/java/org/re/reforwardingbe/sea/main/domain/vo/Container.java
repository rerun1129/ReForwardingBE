package org.re.reforwardingbe.sea.main.domain.vo;

import java.math.BigDecimal;

public class Container {
    private final String containerNo;
    private final ContainerType containerType;
    private final String containerSealNumber1;
    private final String containerSealNumber2;
    private final String containerSealNumber3;
    private final String containerSealNumber4;
    private final String containerSealNumber5;
    private final String containerSealNumber6;
    private final Integer packageQuantity;
    private final PackageUnit packageUnit;
    private final BigDecimal grossWeight;
    private final BigDecimal cbm;

    public Container(String containerNo, ContainerType containerType, String containerSealNumber1, String containerSealNumber2, String containerSealNumber3, String containerSealNumber4, String containerSealNumber5, String containerSealNumber6, Integer packageQuantity, PackageUnit packageUnit, BigDecimal grossWeight, BigDecimal cbm) {
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
}
