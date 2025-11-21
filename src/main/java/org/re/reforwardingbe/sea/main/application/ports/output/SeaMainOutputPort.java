package org.re.reforwardingbe.sea.main.application.ports.output;

import org.re.reforwardingbe.sea.main.domain.model.BL;
import org.re.reforwardingbe.sea.main.domain.model.BLId;

import java.util.List;
import java.util.Optional;

public interface SeaMainOutputPort {
    Optional <BL> findBlMainById(BLId id);
    List<BL> findBlMainAll();

    void saveBlMain(BL bl);

    void deleteBlMainById(BLId id);
}
