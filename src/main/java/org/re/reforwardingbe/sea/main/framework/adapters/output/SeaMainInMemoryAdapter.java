package org.re.reforwardingbe.sea.main.framework.adapters.output;

import org.re.reforwardingbe.sea.main.application.ports.output.SeaMainOutputPort;
import org.re.reforwardingbe.sea.main.domain.entity.BL;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SeaMainInMemoryAdapter implements SeaMainOutputPort {
    List<BL> inMemoryBlMainList = new ArrayList<>();

    @Override
    public BL findBlMainById(UUID savedId) {
        return inMemoryBlMainList.stream().filter(bl -> bl.getId().equals(savedId)).findFirst().orElse(null);
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
    public void deleteBlMainById(UUID blMainId) {
        inMemoryBlMainList.removeIf(bl -> bl.getId().equals(blMainId));
    }
}
