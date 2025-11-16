package org.re.reforwardingbe.sea.main.domain.entity;

import org.re.reforwardingbe.sea.main.domain.vo.*;

import java.util.List;
import java.util.UUID;

public class BL {

    private final UUID id;
    private final Header header;
    private final Party party;
    private final Schedule schedule;
    private final Issue issue;
    private final Cargo cargo;
    private final Contract contract;
    private final Performance performance;
    private final Mark mark;
    private final Description description;
    private final EDI edi;

    private List<Container> containers;
    private List<HSCode> hsCodes;
    private List<Manifest> manifests;

    public BL(UUID id, Header header, Party party, Schedule schedule, Issue issue, Cargo cargo, Contract contract, Performance performance, Mark mark, Description description, EDI edi) {
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
    }

    public BL(UUID id, Header header, Party party, Schedule schedule, Issue issue, Cargo cargo, Contract contract, Performance performance, Mark mark, Description description, EDI edi,
              List<Container> containers, List<HSCode> hsCodes, List<Manifest> manifests) {
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
