package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

public final class BLId {
    @Getter
    private final UUID id;

    private BLId(UUID id) {
        this.id = id;
    }

    public static BLId withUUID(UUID id) {
        return new BLId(id);
    }

    public static BLId withoutId() {
        return new BLId(UUID.randomUUID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BLId blId = (BLId) o;
        return Objects.equals(id, blId.getId());
    }
}
