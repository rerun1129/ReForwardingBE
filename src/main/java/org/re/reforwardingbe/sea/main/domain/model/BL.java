package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;

import java.util.List;

public class BL {

    @Getter
    private final EntityId<BLId> id;
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

    //TODO : 필수 값을 담은 생성자와 모든 값을 담는 생성자 등을 분리 / 정적 팩토리 메서드로 작성할 수 있는 구조
    public BL(EntityId<BLId> id, Header header, Performance performance, Schedule schedule) {
        this.id = id;
        this.header = header;
        this.schedule = schedule;
        this.performance = performance;
    }

    public BL(EntityId<BLId> id, Header header, Party party, Schedule schedule, Issue issue, Cargo cargo, Contract contract, Performance performance, Mark mark, Description description, EDI edi) {
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

    public BL(EntityId<BLId> id, Header header, Party party, Schedule schedule, Issue issue, Cargo cargo, Contract contract, Performance performance, Mark mark, Description description, EDI edi,
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

    public List<Container> findAllContainers() {
        return containers;
    }

    public Container findContainerById(EntityId <Container> containerId) {
        return containers.stream().filter(item -> containerId.equals(item.getContainerId())).findFirst().orElse(new Container());
    }

    public void addContainer(Container container) {
        containers.add(container);
    }

    public void removeContainerById(EntityId <Container> containerId) {
        containers.removeIf(item -> item.getContainerId().equals(containerId));
    }

    public List <HSCode> findAllHsCodes() {
        return hsCodes;
    }

    public HSCode findHSCodeById(EntityId <HSCode> hsCodeId) {
        return hsCodes.stream().filter(item -> hsCodeId.equals(item.getHsCodeId())).findFirst().orElse(new HSCode());
    }

    public void addHsCode(HSCode hsCode) {
        hsCodes.add(hsCode);
    }

    public void removeHsCodeById(EntityId <HSCode> hsCodeId) {
        hsCodes.removeIf(item -> item.getHsCodeId().equals(hsCodeId));
    }

    public List <Manifest> findAllManifests() {
        return manifests;
    }

    public Manifest findManifestById(EntityId <Manifest> manifestId) {
        return manifests.stream().filter(item -> manifestId.equals(item.getManifestId())).findFirst().orElse(new Manifest());
    }

    public void addManifest(Manifest manifest) {
        manifests.add(manifest);
    }

    public void removeManifestById(EntityId <Manifest> manifestId) {
        manifests.removeIf(item -> item.getManifestId().equals(manifestId));
    }
}
