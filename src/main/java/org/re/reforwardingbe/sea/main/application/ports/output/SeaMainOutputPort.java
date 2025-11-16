package org.re.reforwardingbe.sea.main.application.ports.output;

import org.re.reforwardingbe.sea.main.domain.entity.BL;

import java.util.List;
import java.util.UUID;

public interface SeaMainOutputPort {
    BL findBlMainById(UUID savedId);
    List<BL> findBlMainAll();

    void saveBlMain(BL bl);

}
