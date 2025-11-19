package org.re.reforwardingbe.sea.main.application.ports.output;

import org.re.reforwardingbe.sea.main.domain.model.BL;

import java.util.List;
import java.util.UUID;

public interface SeaMainOutputPort {
    BL findBlMainById(UUID savedId);
    List<BL> findBlMainAll();

    void saveBlMain(BL bl);

    void deleteBlMainById(UUID blMainId);
}
