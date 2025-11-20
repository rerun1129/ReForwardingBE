package org.re.reforwardingbe.sea.main.application.ports.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.re.reforwardingbe.sea.main.application.ports.output.SeaMainOutputPort;
import org.re.reforwardingbe.sea.main.domain.model.BL;
import org.re.reforwardingbe.sea.main.domain.model.*;
import org.re.reforwardingbe.sea.main.domain.specification.BLSpec;
import org.re.reforwardingbe.sea.main.domain.specification.ContainerSpec;
import org.re.reforwardingbe.sea.main.domain.specification.HSCodeSpec;
import org.re.reforwardingbe.sea.main.domain.specification.ManifestSpec;
import org.re.reforwardingbe.sea.main.framework.adapters.output.SeaMainInMemoryAdapter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.re.reforwardingbe.sea.main.domain.model.BLType.ORIGINAL;
import static org.re.reforwardingbe.sea.main.domain.model.BLType.SURRENDER;
import static org.re.reforwardingbe.sea.main.domain.model.CargoClass.EXPORT;
import static org.re.reforwardingbe.sea.main.domain.model.CargoClass.IMPORT;
import static org.re.reforwardingbe.sea.main.domain.model.ContainerType.F0FH;
import static org.re.reforwardingbe.sea.main.domain.model.ContainerType.T0FR;
import static org.re.reforwardingbe.sea.main.domain.model.FreightTerm.COLLECT;
import static org.re.reforwardingbe.sea.main.domain.model.FreightTerm.PREPAID;
import static org.re.reforwardingbe.sea.main.domain.model.LoadType.FCL;
import static org.re.reforwardingbe.sea.main.domain.model.LoadType.LCL;
import static org.re.reforwardingbe.sea.main.domain.model.PackageUnit.*;
import static org.re.reforwardingbe.sea.main.domain.model.ServiceTerm.CFS_TO_CY;
import static org.re.reforwardingbe.sea.main.domain.model.ServiceTerm.CY_TO_CFS;
import static org.re.reforwardingbe.sea.main.domain.model.ShipmentType.DIRECT;
import static org.re.reforwardingbe.sea.main.domain.model.ShipmentType.HOUSE;
import static org.re.reforwardingbe.sea.main.domain.model.UnknownClause1.*;
import static org.re.reforwardingbe.sea.main.domain.model.UnknownClause2.*;

class SeaMainInputPortTest {
    private final SeaMainOutputPort seaMainOutputPort = new SeaMainInMemoryAdapter();

    private BL blFixture1;
    private BL blFixture2;

    //TODO : 픽스쳐를 생성해주는 메서드를 테스트 모듈에 작성 / B/L의 요청 값을 처리하는 Request DTO를 도메인 레이어에 작성하여 코드 줄이기
    //TODO : 픽스쳐 생성 메서드는 디폴트 / 극한값 등을 상정해서 만들고 쉽게 가져다 쓰게 해야함
    @BeforeEach
    void init(){
        EntityId<BLId> fixture1Id = EntityId.withoutId();
        ContainerSpec containerSpec1_1 =
                new ContainerSpec(fixture1Id, EntityId.withoutId(), "ContainerNo1-1", F0FH, "1", "2", "3", "4", "5", "6", 50, CB, BigDecimal.valueOf(550.500), BigDecimal.valueOf(0.550));
        ContainerSpec containerSpec1_2 =
                new ContainerSpec(fixture1Id, EntityId.withoutId(), "ContainerNo1-2", F0FH, null, null, null, null, null, null, 50, CB, BigDecimal.valueOf(1000.000), BigDecimal.valueOf(1.000));

        HSCodeSpec hsCodeSpec1_1 = new HSCodeSpec(fixture1Id, EntityId.withoutId(), "010100", "horse", true);
        HSCodeSpec hsCodeSpec1_2 = new HSCodeSpec(fixture1Id, EntityId.withoutId(), "420100", "horse saddle", false);
        ManifestSpec manifestSpec1_1 = new ManifestSpec(fixture1Id, EntityId.withoutId(), "ManifestNo1-1", 50, CB, BigDecimal.valueOf(550.500));
        ManifestSpec manifestSpec1_2 = new ManifestSpec(fixture1Id, EntityId.withoutId(), "ManifestNo1-2", 50, CB, BigDecimal.valueOf(1000.000));

        BLSpec blSpec1 = new BLSpec(fixture1Id,
                                    new Header(HOUSE, "houseBl1", "masterBl1", LCL, CFS_TO_CY, ORIGINAL),
                                    new Party(new Shipper("shipperCode1", "shipperName1", "shipperAddress1"),
                                              new Consignee("consigneeCode1", "consigneeName1", "consigneeAddress1"),
                                              new Notify("notifyCode1", "notifyName1", "notifyAddress1")),
                                    new Schedule(
                                            new Liner("linerCode1", "linerName1" ),
                                            new Vessel("vesselCode1", "vesselName1" , "vesselCountryCode1"),
                                            "voyageNumber1", "20251111", "20251113", "20251111",
                                            new SeaPort("receivePortCode1", "receivePortName1" ),
                                            new SeaPort("loadPortCode1", "loadPortName1" ),
                                            new SeaPort("dischargePortCode1", "dischargePortName1" ),
                                            new SeaPort("deliveryPortCode1", "deliveryPortName1" ),
                                            new SeaPort("destinationPortCode1", "destinationPortName1" )
                                    ),
                                    new Issue("20251112", 3, new IssuePlace("issuePlaceCode1", "issuePlaceName1")),
                                    new Cargo(
                                            new CargoPackage("cargoPackageCode1", "cargoPackageName1", 100),
                                            new BigDecimal("1550.500"),
                                            new BigDecimal("1.550"),
                                            new BigDecimal("1.550")
                                    ),
                                    new Contract(new Incoterms("CIF"), COLLECT, new PayableAt("payableAtCode1", "payableAtName1"), false),
                                    new Performance(
                                            new Customer("CustomerCode1", "CustomerName1" ),
                                            new Partner("DocPartnerCode1", "DocPartnerName1" , "DocPartnerAddress1"),
                                            new Partner("SettlePartnerCode1", "SettlePartnerName1" , "SettlePartnerAddress1"),
                                            new BusinessUser("BusinessUserCode1", "BusinessUserName1" ),
                                            new BusinessUser("BusinessUserCode1", "BusinessUserName1" ),
                                            new BusinessTeam("BusinessTeamCode1", "BusinessTeamName1")
                                    ),
                                    new Mark("""
                ACS F&L LTD.
                BUSAN PORT
                ITEM : GOLF GLOVE
                C/T NO. : 1 OF 9
                MADE IN INDONESIA
                """),
                                    new Description(SLC, STC, "SHEEPSKIN GOLF GLOVES"),
                                    new EDI("ediBlNo1", "ediBlItem1", EXPORT, new SeaPort("transshipmentPortCode1", "transshipmentPortName1")),
                                    new ArrayList <>(List.of(Container.of(containerSpec1_1), Container.of(containerSpec1_2))),
                                    new ArrayList <>(List.of(HSCode.of(hsCodeSpec1_1), HSCode.of(hsCodeSpec1_2))),
                                    new ArrayList <>(List.of(Manifest.of(manifestSpec1_1), Manifest.of(manifestSpec1_2))));
        blFixture1 = BL.of(blSpec1);

        EntityId<BLId> fixture2Id = EntityId.withoutId();
        ContainerSpec containerSpec2_1 =
                new ContainerSpec(fixture2Id, EntityId.withoutId(), "ContainerNo2-1", T0FR, "1", "2", "3", "4", "5", "6", 40, CB, BigDecimal.valueOf(1000.000), BigDecimal.valueOf(0.800));

        ContainerSpec containerSpec2_2 =
                new ContainerSpec(fixture2Id, EntityId.withoutId(), "ContainerNo2-2", T0FR, null, null, null, null, null, null, 60, CB, BigDecimal.valueOf(1700.000), BigDecimal.valueOf(1.000));

        HSCodeSpec hsCodeSpec2_1 = new HSCodeSpec(fixture2Id, EntityId.withoutId(), "870380", "Battery Electric Vehicle", true);
        HSCodeSpec hsCodeSpec2_2 = new HSCodeSpec(fixture2Id, EntityId.withoutId(), "850760", "Lithium-ion Battery", false);
        ManifestSpec manifestSpec2_1 = new ManifestSpec(fixture2Id, EntityId.withoutId(), "ManifestNo2-1", 40, CB, BigDecimal.valueOf(1000.000));
        ManifestSpec manifestSpec2_2 = new ManifestSpec(fixture2Id, EntityId.withoutId(), "ManifestNo2-2", 60, CB, BigDecimal.valueOf(1700.000));
        BLSpec blSpec2 = new BLSpec(fixture2Id,
                                    new Header(DIRECT, "houseBl2", "masterBl2", FCL, CY_TO_CFS, SURRENDER),
                                    new Party(new Shipper("shipperCode2", "shipperName2", "shipperAddress2"),
                                              new Consignee("consigneeCode2", "consigneeName2", "consigneeAddress2"),
                                              new Notify("notifyCode2", "notifyName2", "notifyAddress2")),
                                    new Schedule(
                                            new Liner("linerCode2", "linerName2" ),
                                            new Vessel("vesselCode2", "vesselName2" , "vesselCountryCode2"),
                                            "voyageNumber2", "20251211", "20251213", "20251211",
                                            new SeaPort("receivePortCode2", "receivePortName2" ),
                                            new SeaPort("loadPortCode2", "loadPortName2" ),
                                            new SeaPort("dischargePortCode2", "dischargePortName2" ),
                                            new SeaPort("deliveryPortCode2", "deliveryPortName2" ),
                                            new SeaPort("destinationPortCode2", "destinationPortName2" )
                                    ),
                                    new Issue("20251112", 1, new IssuePlace("issuePlaceCode1", "issuePlaceName1")),
                                    new Cargo(
                                            new CargoPackage("cargoPackageCode1", "cargoPackageName1", 100),
                                            new BigDecimal("2700.000"),
                                            new BigDecimal("1.800"),
                                            new BigDecimal("2.700")
                                    ),
                                    new Contract(new Incoterms("FOB"), PREPAID, new PayableAt("payableAtCode2", "payableAtName2"), false),
                                    new Performance(
                                            new Customer("CustomerCode2", "CustomerName2" ),
                                            new Partner("DocPartnerCode2", "DocPartnerName2" , "DocPartnerAddress2"),
                                            new Partner("SettlePartnerCode2", "SettlePartnerName2" , "SettlePartnerAddress2"),
                                            new BusinessUser("BusinessUserCode2", "BusinessUserName2" ),
                                            new BusinessUser("BusinessUserCode2", "BusinessUserName2" ),
                                            new BusinessTeam("BusinessTeamCode2", "BusinessTeamName2")
                                    ),
                                    new Mark("N/M"),
                                    new Description(SLC, STC, "9 CARTONS = 2,100 PIECES OF"),
                                    new EDI("ediBlNo2", "ediBlItem2", IMPORT, new SeaPort("transshipmentPortCode2", "transshipmentPortName2")),
                                    new ArrayList <>(List.of(Container.of(containerSpec2_1), Container.of(containerSpec2_2))),
                                    new ArrayList <>(List.of(HSCode.of(hsCodeSpec2_1), HSCode.of(hsCodeSpec2_2))),
                                    new ArrayList <>(List.of(Manifest.of(manifestSpec2_1), Manifest.of(manifestSpec2_2))));
        blFixture2 = BL.of(blSpec2);
        seaMainOutputPort.saveBlMain(blFixture1);
        seaMainOutputPort.saveBlMain(blFixture2);
    }

    @Test
    @DisplayName("B/L 메인이 조회된다")
    void testFindBlMain() {
        //given
        EntityId<BLId> searchId = blFixture1.getId();
        //when
        BL searchedBlMain = seaMainOutputPort.findBlMainById(searchId);
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
        BL addedBl = seaMainOutputPort.findBlMainById(toAddBlId);
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
        BL blMainById = seaMainOutputPort.findBlMainById(blMainId);
        //then
        assertEquals(blMainAll.size(), blMainSizeBeforeDelete - 1);
        assertNull(blMainById);
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