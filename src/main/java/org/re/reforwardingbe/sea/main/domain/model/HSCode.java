package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;

import java.util.UUID;

public class HSCode {
    @Getter
    private UUID rootBlId;
    @Getter
    private UUID hsCodeId;
    private String hsCode;
    private String hsCodeDescription;
    private Boolean isMainItem;

    //TODO : 필수 값을 담은 생성자와 모든 값을 담는 생성자를 분리 / 정적 팩토리 메서드로 작성할 수 있는 구조
    public HSCode(UUID rootBlId, String hsCode, String hsCodeDescription, Boolean isMainItem) {
        this.rootBlId = rootBlId;
        this.hsCodeId = UUID.randomUUID();
        this.hsCode = hsCode;
        this.hsCodeDescription = hsCodeDescription;
        this.isMainItem = isMainItem;
    }

    public HSCode() {

    }
}
