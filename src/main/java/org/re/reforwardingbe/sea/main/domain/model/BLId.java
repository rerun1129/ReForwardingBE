package org.re.reforwardingbe.sea.main.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

public final class BLId {
    @Getter
    @JsonValue
    private final UUID id;

    private BLId(UUID id) {
        this.id = id;
    }

    @JsonCreator
    public static BLId from(String uuidString) {
        return new BLId(UUID.fromString(uuidString));
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

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
