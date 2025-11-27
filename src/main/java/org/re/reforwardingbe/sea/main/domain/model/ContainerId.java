package org.re.reforwardingbe.sea.main.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

public class ContainerId {
    @Getter
    @JsonValue
    private final UUID id;

    private ContainerId(UUID id) {
        this.id = id;
    }

    @JsonCreator
    public static ContainerId from(String uuidString) {
        return new ContainerId(UUID.fromString(uuidString));
    }

    public static ContainerId withUUID(UUID id) {
        return new ContainerId(id);
    }

    public static ContainerId withoutId() {
        return new ContainerId(UUID.randomUUID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContainerId containerId = (ContainerId) o;
        return Objects.equals(id, containerId.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
