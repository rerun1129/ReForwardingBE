package org.re.reforwardingbe.sea.main.domain.vo;

import lombok.Getter;

@Getter
public enum ContainerType {
    T0FR("20FR", "20' 8' Flat-rack container"),
    T0GP("20GP", "20` 8` General purpose container"),
    T0HQ("20HQ", "20'8' HIGH-CUBIC CONTAINER"),
    T0HT("20HT", "20' 8' Hanger container"),
    T0OT("20OT", "20' 8' Open-top container"),
    T0RF("20RF", "20' 8' Reefer container"),
    T0TC("20TC", "20' 8' Tank container"),
    T2PL("22PL", "20` 8` Flat-rack container"),
    F0FH("40FH", "40'HC FLAT RACK CONTAINER"),
    F0FR("40FR", "40'  8' Flat-rack container"),
    F0GP("40GP", "40'  8' General purpose container"),
    F0HQ("40HQ", "40` 8` HIGH-CUBIC container"),
    F0HS("40HS", "40'HC SUPER RACK CONTAINER"),
    F0HT("40HT", "40' 8' Hanger container"),
    F0NR("40NR", "40`Non-Operational Refrigerated Containers"),
    F0OT("40OT", "40'  8' Open-top container"),
    F0RF("40RF", "40' 8' Reefer container"),
    F0RH("40RH", "40' 8' Reefer container"),
    F0SR("40SR", "40' SUPER RACK"),
    F2PL("42PL", "40` 8` Flat-rack container"),
    F5FR("45FR", "45FR"),
    F5GP("45GP", "40` 8` dry container"),
    F5HQ("45HQ", "40` 9` HIGH-CUBIC container");

    private final String displayCode;
    private final String displayName;

    ContainerType(String displayCode, String displayName) {
        this.displayCode = displayCode;
        this.displayName = displayName;
    }
}
