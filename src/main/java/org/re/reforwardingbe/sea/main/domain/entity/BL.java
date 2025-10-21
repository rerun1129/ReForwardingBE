package org.re.reforwardingbe.sea.main.domain.entity;

import org.re.reforwardingbe.sea.main.domain.vo.*;

import java.util.List;
import java.util.UUID;

public class BL {

    private UUID id;
    private Party party;
    private Schedule schedule;
    private Issue issue;
    private Cargo cargo;
    private Contract contract;
    private Performance performance;
    private Mark mark;
    private Description description;
    private EDI edi;
    private AMSAddress amsAddress;

    private List <Container> container;
    private List<ContainerSummary> containerSummary;
    private List<HSCode> hsCode;
    private List<Manifest> manifest;
}
