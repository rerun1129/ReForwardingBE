package org.re.reforwardingbe.sea.main.domain.specification;

import lombok.Getter;
import org.re.reforwardingbe.sea.main.domain.model.*;

import java.util.List;

@Getter
public class BLSpec {
    private final BLId id;
    private final Header header;
    private final Schedule schedule;
    private final Performance performance;
    private Party party;
    private Issue issue;
    private Cargo cargo;
    private Contract contract;
    private Mark mark;
    private Description description;
    private EDI edi;

    private List <Container> containers;
    private List<HSCode> hsCodes;
    private List<Manifest> manifests;

    public BLSpec(BLId id, Header header, Performance performance, Schedule schedule) {
        this.id = id;
        this.header = header;
        this.performance = performance;
        this.schedule = schedule;
    }

    public BLSpec(BLId id, Header header, Party party, Schedule schedule,
                  Issue issue, Cargo cargo, Contract contract, Performance performance,
                  Mark mark, Description description, EDI edi, List <Container> containers,
                  List <HSCode> hsCodes, List <Manifest> manifests) {
        this.id = id;
        this.header = header;
        this.party = party;
        this.schedule = schedule;
        this.issue = issue;
        this.cargo = cargo;
        this.contract = contract;
        this.performance = performance;
        this.mark = mark;
        this.description = description;
        this.edi = edi;
        this.containers = containers;
        this.hsCodes = hsCodes;
        this.manifests = manifests;
    }
}
