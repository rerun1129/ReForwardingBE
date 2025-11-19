package org.re.reforwardingbe.sea.main.domain.entity;

import lombok.Getter;
import org.re.reforwardingbe.sea.main.domain.vo.*;

import java.util.List;
import java.util.UUID;

public class BL {

    @Getter
    private final UUID id;
    private final Header header;
    private Party party;
    private final Schedule schedule;
    private Issue issue;
    private Cargo cargo;
    private Contract contract;
    private final Performance performance;
    private Mark mark;
    private Description description;
    private EDI edi;

    private List<Container> containers;
    private List<HSCode> hsCodes;
    private List<Manifest> manifests;

    public BL(UUID id, Header header, Performance performance, Schedule schedule) {
        this.id = id;
        this.header = header;
        this.schedule = schedule;
        this.performance = performance;
    }

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

    public void addContainer(Container container) {
        containers.add(container);
    }

    public List <Container> findAllContainers() {
        return containers;
    }

    public void addHsCode(HSCode hsCode) {
        hsCodes.add(hsCode);
    }

    public List <HSCode> findAllHsCodes() {
        return hsCodes;
    }

    public void addManifest(Manifest manifest) {
        manifests.add(manifest);
    }

    public List <Manifest> findAllManifests() {
        return manifests;
    }
}
