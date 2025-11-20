package org.re.reforwardingbe.sea.main.application.ports.output;

import org.re.reforwardingbe.sea.main.domain.model.BL;
import org.re.reforwardingbe.sea.main.domain.model.BLId;
import org.re.reforwardingbe.sea.main.domain.model.EntityId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SeaMainOutputPort {
    Optional <BL> findBlMainById(EntityId <BLId> id);
    List<BL> findBlMainAll();

    void saveBlMain(BL bl);

    void deleteBlMainById(EntityId<BLId> id);
}
