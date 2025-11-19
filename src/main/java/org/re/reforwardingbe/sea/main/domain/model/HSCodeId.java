package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

public class HSCodeId {
    @Getter
    private final UUID id;

    private HSCodeId(UUID id) {
        this.id = id;
    }

    public static HSCodeId withUUID(UUID id) {
        return new HSCodeId(id);
    }

    public static HSCodeId withoutId() {
        return new HSCodeId(UUID.randomUUID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HSCodeId hscodeId = (HSCodeId) o;
        return Objects.equals(id, hscodeId.getId());
    }
}
