package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;

public class HSCode {
    @Getter
    private EntityId<BLId> rootBlId;
    @Getter
    private EntityId <HSCode> hsCodeId;
    private String hsCode;
    private String hsCodeDescription;
    private Boolean isMainItem;

    //TODO : 필수 값을 담은 생성자와 모든 값을 담는 생성자를 분리 / 정적 팩토리 메서드로 작성할 수 있는 구조
    public HSCode(EntityId<BLId> rootBlId, EntityId <HSCode> hsCodeId, String hsCode, String hsCodeDescription, Boolean isMainItem) {
        this.rootBlId = rootBlId;
        this.hsCodeId = hsCodeId;
        this.hsCode = hsCode;
        this.hsCodeDescription = hsCodeDescription;
        this.isMainItem = isMainItem;
    }

    public HSCode() {
    }
}
