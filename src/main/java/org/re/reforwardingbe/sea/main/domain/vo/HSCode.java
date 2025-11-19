package org.re.reforwardingbe.sea.main.domain.vo;

import lombok.Getter;

import java.util.UUID;

public class HSCode {
    @Getter
    private final UUID rootBlId;
    @Getter
    private final UUID hsCodeId;
    private final String hsCode;
    private final String hsCodeDescription;
    private final Boolean isMainItem;

    public HSCode(UUID rootBlId, String hsCode, String hsCodeDescription, Boolean isMainItem) {
        this.rootBlId = rootBlId;
        this.hsCodeId = UUID.randomUUID();
        this.hsCode = hsCode;
        this.hsCodeDescription = hsCodeDescription;
        this.isMainItem = isMainItem;
    }
}
