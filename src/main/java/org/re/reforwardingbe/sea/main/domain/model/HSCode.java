package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;
import org.re.reforwardingbe.sea.main.domain.specification.HSCodeSpec;

public class HSCode {
    @Getter
    private BLId rootBlId;
    @Getter
    private HSCodeId hsCodeId;
    private String hsCode;
    private String hsCodeDescription;
    private Boolean isMainItem;

    private HSCode() {
    }

    private HSCode(HSCodeSpec spec) {
        this.rootBlId = spec.getRootBlId();
        this.hsCodeId = spec.getHsCodeId();
        this.hsCode = spec.getHsCode();
        this.hsCodeDescription = spec.getHsCodeDescription();
        this.isMainItem = spec.getIsMainItem();
    }

    public static HSCode of(HSCodeSpec spec) {
        return new HSCode(spec);
    }

    public static HSCode withEssential(BLId rootBlId, HSCodeId hsCodeId, String hsCode) {
        return new HSCode(new HSCodeSpec(rootBlId, hsCodeId, hsCode));
    }

    public static HSCode empty() {
        return new HSCode();
    }
}
