package org.re.reforwardingbe.sea.main.domain.model;

import lombok.Getter;
import org.re.reforwardingbe.sea.main.domain.specification.BLSpec;

import java.util.List;

public class BL {
    @Getter
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

    private BL() {}

    private BL(BLSpec spec) {
        this.id = spec.getId();
        this.header = spec.getHeader();
        this.party = spec.getParty();
        this.schedule = spec.getSchedule();
        this.issue = spec.getIssue();
        this.cargo = spec.getCargo();
        this.contract = spec.getContract();
        this.performance = spec.getPerformance();
        this.mark = spec.getMark();
        this.description = spec.getDescription();
        this.edi = spec.getEdi();
        this.containers = spec.getContainers();
        this.hsCodes = spec.getHsCodes();
        this.manifests = spec.getManifests();
    }

    public static BL of(BLSpec spec){
        return new BL(spec);
    }

    public static BL withEssential(BLId id, Header header, Performance performance, Schedule schedule) {
        return new BL(new BLSpec(id, header, performance, schedule));
    }

    public static BL empty() {return new BL();}

    public List<Container> findAllContainers() {
        return containers;
    }

    public Container findContainerById(ContainerId containerId) {
        return containers.stream().filter(item -> containerId.equals(item.getContainerId())).findFirst().orElse(Container.empty());
    }

    public void addContainer(Container container) {
        containers.add(container);
    }

    public void removeContainerById(ContainerId containerId) {
        containers.removeIf(item -> item.getContainerId().equals(containerId));
    }

    public List <HSCode> findAllHsCodes() {
        return hsCodes;
    }

    public HSCode findHSCodeById(HSCodeId hsCodeId) {
        return hsCodes.stream().filter(item -> hsCodeId.equals(item.getHsCodeId())).findFirst().orElse(HSCode.empty());
    }

    public void addHsCode(HSCode hsCode) {
        hsCodes.add(hsCode);
    }

    public void removeHsCodeById(HSCodeId hsCodeId) {
        hsCodes.removeIf(item -> item.getHsCodeId().equals(hsCodeId));
    }

    public List <Manifest> findAllManifests() {
        return manifests;
    }

    public Manifest findManifestById(ManifestId manifestId) {
        return manifests.stream().filter(item -> manifestId.equals(item.getManifestId())).findFirst().orElse(Manifest.empty());
    }

    public void addManifest(Manifest manifest) {
        manifests.add(manifest);
    }

    public void removeManifestById(ManifestId manifestId) {
        manifests.removeIf(item -> item.getManifestId().equals(manifestId));
    }
}
