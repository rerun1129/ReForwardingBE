package org.re.reforwardingbe.sea.main.framework.adapters.input.dto;

import lombok.Getter;
import org.re.reforwardingbe.sea.main.domain.model.*;

import java.util.List;
import java.util.UUID;

@Getter
public class BLCreateRequest {
    private UUID id; //객체 생성 시점에 EntityId<BLId> 타입으로 처리(JSON에서 자바 객체로 변환 과정에서 제네릭 타입으로 인지시키려면 추가적인 어노테이션 필요)
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
