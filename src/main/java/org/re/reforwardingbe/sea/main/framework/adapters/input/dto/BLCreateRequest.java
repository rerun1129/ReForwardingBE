package org.re.reforwardingbe.sea.main.framework.adapters.input.dto;

import lombok.Getter;
import org.re.reforwardingbe.sea.main.domain.model.*;

import java.util.List;
import java.util.UUID;

@Getter
public class BLCreateRequest {
    private BLId id;
    private Header header;
    private Party party;
    private Schedule schedule;
    private Issue issue;
    private Cargo cargo;
    private Contract contract;
    private Performance performance;
    private Mark mark;
    private Description description;
    private EDI edi;

    private List<Container> containers;
    private List<HSCode> hsCodes;
    private List<Manifest> manifests;
}
