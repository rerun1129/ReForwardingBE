package org.re.reforwardingbe.sea.main.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

public class ManifestId {
    @Getter
    @JsonValue
    private final UUID id;

    private ManifestId(UUID id) {
        this.id = id;
    }

    @JsonCreator
    public static ManifestId from(String uuidString) {
        return new ManifestId(UUID.fromString(uuidString));
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

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
