package org.re.reforwardingbe.sea.main.framework.adapters.output;

import org.re.reforwardingbe.sea.main.application.ports.output.SeaMainOutputPort;
import org.re.reforwardingbe.sea.main.domain.model.BL;
import org.re.reforwardingbe.sea.main.domain.model.BLId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SeaMainInMemoryAdapter implements SeaMainOutputPort {
    List<BL> inMemoryBlMainList = new ArrayList<>();

    @Override
    public Optional <BL> findBlMainById(BLId id) {
        return inMemoryBlMainList.stream().filter(bl -> bl.getId().equals(id)).findFirst();
    }

    @Override
    public List <BL> findBlMainAll() {
        return inMemoryBlMainList;
    }

    @Override
    public void saveBlMain(BL bl) {
        if(inMemoryBlMainList.stream().noneMatch(blMain -> blMain.getId().equals(bl.getId()))){
            inMemoryBlMainList.add(bl);
        }else {
            inMemoryBlMainList.removeIf(blMain -> blMain.getId().equals(bl.getId()));
            inMemoryBlMainList.add(bl);
        }
    }

    @Override
    public void deleteBlMainById(BLId blMainId) {
        inMemoryBlMainList.removeIf(bl -> bl.getId().equals(blMainId));
    }
}
