package org.re.reforwardingbe.sea.main.domain.specification;

import lombok.Builder;
import lombok.Getter;
import org.re.reforwardingbe.sea.main.domain.model.*;

import java.math.BigDecimal;

@Getter
@Builder
public class HSCodeSpec {
    private EntityId<BLId> rootBlId;
    private EntityId <HSCode> hsCodeId;
    private String hsCode;
    private String hsCodeDescription;
    private Boolean isMainItem;
}
