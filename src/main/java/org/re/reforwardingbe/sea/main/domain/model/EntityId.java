package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

public class EntityId <T> {
    @Getter
    private final UUID id;

    protected EntityId(UUID id) {
        this.id = id;
    }

    public static <T> EntityId <T> withUUID(UUID id) {
        return new EntityId <>(id);
    }

    public static <T> EntityId <T> withoutId() {
        return new EntityId <>(UUID.randomUUID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityId <?> domainId = (EntityId <?>) o;
        return Objects.equals(id, domainId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
