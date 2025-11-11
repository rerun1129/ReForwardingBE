package org.re.reforwardingbe.sea.main.domain.vo;

public class HSCode {
    private final String hsCode;
    private final String hsCodeDescription;
    private final Boolean isMainItem;

    public HSCode(String hsCode, String hsCodeDescription, Boolean isMainItem) {
        this.hsCode = hsCode;
        this.hsCodeDescription = hsCodeDescription;
        this.isMainItem = isMainItem;
    }
}
