package org.re.reforwardingbe.sea.main.domain.specification;

import lombok.Builder;
import lombok.Getter;
import org.re.reforwardingbe.sea.main.domain.model.*;

import java.math.BigDecimal;

@Getter
public class HSCodeSpec {
    private final BLId rootBlId;
    private final HSCodeId hsCodeId;
    private final String hsCode;
    private String hsCodeDescription;
    private Boolean isMainItem;

    public HSCodeSpec(BLId rootBlId, HSCodeId hsCodeId, String hsCode, String hsCodeDescription, Boolean isMainItem) {
        this.rootBlId = rootBlId;
        this.hsCodeId = hsCodeId;
        this.hsCode = hsCode;
        this.hsCodeDescription = hsCodeDescription;
        this.isMainItem = isMainItem;
    }

    public HSCodeSpec(BLId rootBlId, HSCodeId hsCodeId, String hsCode) {
        this.rootBlId = rootBlId;
        this.hsCodeId = hsCodeId;
        this.hsCode = hsCode;
    }
}
