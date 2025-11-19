package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

public class ManifestId {
    @Getter
    private final UUID id;

    private ManifestId(UUID id) {
        this.id = id;
    }

    public static ManifestId withUUID(UUID id) {
        return new ManifestId(id);
    }

    public static ManifestId withoutId() {
        return new ManifestId(UUID.randomUUID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManifestId manifestId = (ManifestId) o;
        return Objects.equals(id, manifestId.getId());
    }
}
