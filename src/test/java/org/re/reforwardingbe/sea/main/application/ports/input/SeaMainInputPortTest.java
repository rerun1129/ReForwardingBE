package org.re.reforwardingbe.sea.main.application.ports.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.re.reforwardingbe.sea.main.application.ports.output.SeaMainOutputPort;
import org.re.reforwardingbe.sea.main.domain.model.BL;
import org.re.reforwardingbe.sea.main.domain.model.*;
import org.re.reforwardingbe.sea.main.fixture.BLFixture;
import org.re.reforwardingbe.sea.main.framework.adapters.output.SeaMainInMemoryAdapter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.re.reforwardingbe.sea.main.domain.model.BLType.ORIGINAL;
import static org.re.reforwardingbe.sea.main.domain.model.ContainerType.F0FH;
import static org.re.reforwardingbe.sea.main.domain.model.LoadType.FCL;
import static org.re.reforwardingbe.sea.main.domain.model.ShipmentType.HOUSE;

class SeaMainInputPortTest {
    private final SeaMainOutputPort seaMainOutputPort = new SeaMainInMemoryAdapter();
    private final BL blFixture1 = BLFixture.createDefault1();
    private final BL blFixture2 = BLFixture.createDefault2();

    @BeforeEach
    void init(){
        seaMainOutputPort.saveBlMain(blFixture1);
        seaMainOutputPort.saveBlMain(blFixture2);
    }

    @Test
    @DisplayName("B/L 메인이 조회된다")
    void testFindBlMain() {
        //given
        EntityId<BLId> searchId = blFixture1.getId();
        //when
        BL searchedBlMain = seaMainOutputPort.findBlMainById(searchId).orElse(BL.empty());
        //then
        assertEquals(searchId, searchedBlMain.getId());
    }

    @Test
    @DisplayName("B/L 내부의 Container가 조회된다")
    void testFindBlContainer() {
        //given
        EntityId<BLId> rootBlId = blFixture2.getId();
        List <Container> allContainer = blFixture2.findAllContainers();
        EntityId <Container> containerId = allContainer.getFirst().getContainerId();
        //when
        Container searchedContainer = blFixture2.findContainerById(containerId);
        //then
        assertEquals(rootBlId, searchedContainer.getRootBlId());
    }

    @Test
    @DisplayName("B/L 내부의 HSCode가 조회된다")
    void testFindBlHSCode() {
        //given
        EntityId<BLId> rootBlId = blFixture2.getId();
        List <HSCode> allHsCode = blFixture2.findAllHsCodes();
        EntityId <HSCode> hsCodeId = allHsCode.getFirst().getHsCodeId();
        //when
        HSCode searchedHsCode = blFixture2.findHSCodeById(hsCodeId);
        //then
        assertEquals(rootBlId, searchedHsCode.getRootBlId());
    }

    @Test
    @DisplayName("B/L 내부의 Manifest가 조회된다")
    void testFindBlManifest() {
        //given
        EntityId<BLId> rootBlId = blFixture2.getId();
        List <Manifest> allManifest = blFixture2.findAllManifests();
        EntityId <Manifest> manifestId = allManifest.getFirst().getManifestId();
        //when
        Manifest searchedManifest = blFixture2.findManifestById(manifestId);
        //then
        assertEquals(rootBlId, searchedManifest.getRootBlId());
    }

    @Test
    @DisplayName("B/L 메인이 저장된다")
    void testSaveBlMain(){
        //given
        EntityId<BLId> toAddBlId = EntityId.withoutId();
        BL blInputEssentialField = BL.withEssential(toAddBlId, new Header(HOUSE, "HouseNumberGiven1", FCL, ORIGINAL),
                                    new Performance(new Customer("CustomerCodeGiven1", "CustomerNameGiven1"),
                                                    new Partner("PartnerCodeGiven1", "PartnerNameGiven1", "PartnerAddressGiven1"),
                                                    new BusinessUser("UserCodeGiven1", "UserNameGiven1"),
                                                    new BusinessTeam("TeamCodeGiven1", "TeamNameGiven1")),
                                    new Schedule("20251116", "20251118",
                                                    new SeaPort("POLCodeGiven1", "POLNameGiven1"),
                                                    new SeaPort("PODCodeGiven1", "PODNameGiven1"),
                                                    new Vessel("VesselCodeGiven1", "VesselNameGiven1", "VesselCountryGiven1"),
                                                    "VoyageNumberGiven1"));
        List<BL> allBlsBeforeSave = seaMainOutputPort.findBlMainAll();
        int beforeAddedAllBlSize = allBlsBeforeSave.size();
        //when
        seaMainOutputPort.saveBlMain(blInputEssentialField);
        //then
        BL addedBl = seaMainOutputPort.findBlMainById(toAddBlId).orElse(BL.empty());
        List<BL> addedAllBl = seaMainOutputPort.findBlMainAll();
        assertEquals(addedAllBl.size(), beforeAddedAllBlSize + 1);
        assertEquals(addedBl.getId(), toAddBlId);
    }

    @Test
    @DisplayName("기존에 B/L이 존재한다면 Insert가 아닌 Update가 된다[JPA이외 환경 테스트]")
    void testUpdateBlBySaveObject(){
        //given
        EntityId<BLId> fixtureId = blFixture1.getId();
        //when
        blFixture1.addContainer(Container.withEssential(fixtureId, EntityId.withoutId(), "ContainerNumberGiven1", F0FH));
        List <BL> blMainAll = seaMainOutputPort.findBlMainAll();
        int saveMainBeforeSize = blMainAll.size();
        seaMainOutputPort.saveBlMain(blFixture1);
        //then
        assertEquals(blMainAll.size(), saveMainBeforeSize);
    }

    @Test
    @DisplayName("B/L 내부의 Container가 저장된다")
    void testSaveBlContainer(){
        //given
        List <Container> allContainers = blFixture1.findAllContainers();
        int beforeAddContainersSize = allContainers.size();
        Container container = Container.withEssential(blFixture1.getId(), EntityId.withoutId(), "ContainerNumberGiven1", F0FH);
        //when
        blFixture1.addContainer(container);
        int addedContainersSize = allContainers.size();
        EntityId<BLId> addedContainerRootId = blFixture1.findContainerById(container.getContainerId()).getRootBlId();
        //then
        assertEquals(addedContainersSize, beforeAddContainersSize + 1);
        assertEquals(blFixture1.getId(), addedContainerRootId);
    }

    @Test
    @DisplayName("B/L 내부의 HSCode가 저장된다")
    void testSaveBlHSCode(){
        //given
        List <HSCode> allHSCode = blFixture1.findAllHsCodes();
        int beforeAddHSCodeSize = allHSCode.size();
        HSCode hsCode = HSCode.withEssential(blFixture1.getId(), EntityId.withoutId(), "HSCodeGiven1");
        //when
        blFixture1.addHsCode(hsCode);
        int addedHSCodesSize = allHSCode.size();
        EntityId<BLId> addedHsCodeRootId = blFixture1.findHSCodeById(hsCode.getHsCodeId()).getRootBlId();
        //then
        assertEquals(addedHSCodesSize, beforeAddHSCodeSize + 1);
        assertEquals(blFixture1.getId(), addedHsCodeRootId);
    }

    @Test
    @DisplayName("B/L 내부의 Manifest가 저장된다")
    void testSaveBlManifest(){
        //given
        List<Manifest> allManifests = blFixture1.findAllManifests();
        int beforeAddManifestSize = allManifests.size();
        Manifest manifest = Manifest.withEssential(blFixture1.getId(), EntityId.withoutId(), "ManifestNoGiven1");
        //when
        blFixture1.addManifest(manifest);
        int addedManifestSize = allManifests.size();
        EntityId<BLId> addedManifestRootId = blFixture1.findManifestById(manifest.getManifestId()).getRootBlId();
        //then
        assertEquals(addedManifestSize, beforeAddManifestSize + 1);
        assertEquals(blFixture1.getId(), addedManifestRootId);
    }

    @Test
    @DisplayName("B/L 메인이 삭제된다")
    void testDeleteBlMain () {
        //given
        EntityId<BLId> blMainId = blFixture2.getId();
        //when
        List <BL> blMainAll = seaMainOutputPort.findBlMainAll();
        int blMainSizeBeforeDelete = blMainAll.size();
        seaMainOutputPort.deleteBlMainById(blMainId);
        BL blMainById = seaMainOutputPort.findBlMainById(blMainId).orElse(BL.empty());
        //then
        assertEquals(blMainAll.size(), blMainSizeBeforeDelete - 1);
        assertNull(blMainById.getId());
    }

    @Test
    @DisplayName("B/L 내부의 Container가 삭제된다")
    void testDeleteBlContainer () {
        //given
        List<Container> allContainers = blFixture1.findAllContainers();
        int beforeDeleteContainersSize = allContainers.size();
        EntityId <Container> toRemoveContainerId = allContainers.getFirst().getContainerId();
        //when
        blFixture1.removeContainerById(toRemoveContainerId);
        int deletedContainersSize = allContainers.size();
        Container deletedContainer = blFixture1.findContainerById(toRemoveContainerId);
        //then
        assertEquals(deletedContainersSize, beforeDeleteContainersSize - 1);
        assertNull(deletedContainer.getContainerId());
    }

    @Test
    @DisplayName("B/L 내부의 HSCode가 삭제된다")
    void testDeleteBlHSCode () {
        //given
        List<HSCode> allHsCode = blFixture1.findAllHsCodes();
        int beforeDeleteHsCodesSize = allHsCode.size();
        EntityId <HSCode> toDeleteHsCodeId = allHsCode.getFirst().getHsCodeId();
        //when
        blFixture1.removeHsCodeById(toDeleteHsCodeId);
        int deletedHsCodesSize = allHsCode.size();
        HSCode deletedHsCode = blFixture1.findHSCodeById(toDeleteHsCodeId);
        //then
        assertEquals(deletedHsCodesSize, beforeDeleteHsCodesSize - 1);
        assertNull(deletedHsCode.getHsCodeId());
    }

    @Test
    @DisplayName("B/L 내부의 Manifest가 삭제된다")
    void testDeleteBlManifest () {
        //given
        List<Manifest> allManifest = blFixture1.findAllManifests();
        int beforeDeleteManifestsSize = allManifest.size();
        EntityId <Manifest> toDeleteManifestId = allManifest.getFirst().getManifestId();
        //when
        blFixture1.removeManifestById(toDeleteManifestId);
        int deletedManifestsSize = allManifest.size();
        Manifest deletedManifest = blFixture1.findManifestById(toDeleteManifestId);
        //then
        assertEquals(deletedManifestsSize, beforeDeleteManifestsSize - 1);
        assertNull(deletedManifest.getManifestId());
    }
}