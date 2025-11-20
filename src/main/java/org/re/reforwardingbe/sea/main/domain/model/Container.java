package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;
import org.re.reforwardingbe.sea.main.domain.specification.ContainerSpec;

import java.math.BigDecimal;

public class Container {
    @Getter
    private BLId rootBlId;
    @Getter
    private ContainerId containerId;
    private String containerNo;
    private ContainerType containerType;
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


    //빈 생성자
    private Container() {}

    private Container(ContainerSpec spec) {
        this.rootBlId = spec.getRootBlId();
        this.containerId = spec.getContainerId();
        this.containerNo = spec.getContainerNo();
        this.containerType = spec.getContainerType();
        this.containerSealNumber1 = spec.getContainerSealNumber1();
        this.containerSealNumber2 = spec.getContainerSealNumber2();
        this.containerSealNumber3 = spec.getContainerSealNumber3();
        this.containerSealNumber4 = spec.getContainerSealNumber4();
        this.containerSealNumber5 = spec.getContainerSealNumber5();
        this.containerSealNumber6 = spec.getContainerSealNumber6();
        this.packageQuantity = spec.getPackageQuantity();
        this.packageUnit = spec.getPackageUnit();
        this.grossWeight = spec.getGrossWeight();
        this.cbm = spec.getCbm();
    }

    public static Container of(ContainerSpec spec){
        return new Container(spec);
    }

    public static Container withEssential(BLId rootBlId, ContainerId containerId, String containerNo, ContainerType containerType) {
        return new Container(new ContainerSpec(rootBlId, containerId, containerNo, containerType));
    }

    public static Container empty() {
        return new Container();
    }
}
