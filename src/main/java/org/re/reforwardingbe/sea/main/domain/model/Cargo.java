package org.re.reforwardingbe.sea.main.domain.model;

import java.math.BigDecimal;

public record Cargo(CargoPackage cargoPackage, BigDecimal grossWeight, BigDecimal cbm, BigDecimal rTon) {
}
