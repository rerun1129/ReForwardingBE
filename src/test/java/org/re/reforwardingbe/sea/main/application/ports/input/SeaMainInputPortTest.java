package org.re.reforwardingbe.sea.main.application.ports.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.re.reforwardingbe.sea.main.domain.entity.BL;
import org.re.reforwardingbe.sea.main.domain.vo.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.re.reforwardingbe.sea.main.domain.vo.BLType.ORIGINAL;
import static org.re.reforwardingbe.sea.main.domain.vo.BLType.SURRENDER;
import static org.re.reforwardingbe.sea.main.domain.vo.CargoClass.EXPORT;
import static org.re.reforwardingbe.sea.main.domain.vo.CargoClass.IMPORT;
import static org.re.reforwardingbe.sea.main.domain.vo.ContainerType.F0FH;
import static org.re.reforwardingbe.sea.main.domain.vo.ContainerType.T0FR;
import static org.re.reforwardingbe.sea.main.domain.vo.FreightTerm.COLLECT;
import static org.re.reforwardingbe.sea.main.domain.vo.FreightTerm.PREPAID;
import static org.re.reforwardingbe.sea.main.domain.vo.LoadType.FCL;
import static org.re.reforwardingbe.sea.main.domain.vo.LoadType.LCL;
import static org.re.reforwardingbe.sea.main.domain.vo.PackageUnit.*;
import static org.re.reforwardingbe.sea.main.domain.vo.ServiceTerm.CFS_TO_CY;
import static org.re.reforwardingbe.sea.main.domain.vo.ServiceTerm.CY_TO_CFS;
import static org.re.reforwardingbe.sea.main.domain.vo.ShipmentType.DIRECT;
import static org.re.reforwardingbe.sea.main.domain.vo.ShipmentType.HOUSE;
import static org.re.reforwardingbe.sea.main.domain.vo.UnknownClause1.*;
import static org.re.reforwardingbe.sea.main.domain.vo.UnknownClause2.*;

class SeaMainInputPortTest {
    /*
    * TODO [0] 픽스쳐
    * 1. 초기 데이터 세팅은 테스트 클래스의 @BeforeEach에서 진행한다.
    * 2. 픽스쳐는 2개 이상의 데이터를 리포지토리에 기본적으로 담는다.
    * 3. B/L 엔티티 픽스쳐 내부에는 B/L 메인과 1대1 대응하는 VO와 1대N으로 대응하는 VO가 있다.
    * */
    private BL blFixture1;
    private BL blFixture2;

    @BeforeEach
    void init(){
        blFixture1 = new BL(
            UUID.randomUUID(),
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
            List.of(
                new Container("ContainerNo1-1", F0FH, "1", "2", "3", "4", "5", "6", 50, CB, new BigDecimal("550.500"), new BigDecimal("0.550")),
                new Container("ContainerNo1-2", F0FH, "", "", "", "", "", "", 50, CB, new BigDecimal("1000.000"), new BigDecimal("1.000"))
            ),
            List.of(new HSCode("010100", "horse", true), new HSCode("420100", "horse saddle", false)),
            List.of(new Manifest("ManifestNo1-1", 50, CB, new BigDecimal("550.500")), new Manifest("ManifestNo1-2", 50, CB, new BigDecimal("1000.000")))
        );

        blFixture2 = new BL(
            UUID.randomUUID(),
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
            List.of(
                new Container("ContainerNo2-1", T0FR, "1", "2", "3", "4", "5", "6", 40, CB, new BigDecimal("1000.000"), new BigDecimal("0.800")),
                new Container("ContainerNo2-2", T0FR, "", "", "", "", "", "", 60, CB, new BigDecimal("1700.000"), new BigDecimal("1.000"))
            ),
            List.of(new HSCode("870380", "Battery Electric Vehicle", true), new HSCode("850760", "Lithium-ion Battery", false)),
            List.of(new Manifest("ManifestNo2-1", 40, CB, new BigDecimal("1000.000")), new Manifest("ManifestNo2-2", 60, CB, new BigDecimal("1700.000")))
        );
    }


    /*
    * TODO [1] 저장
    * 1. B/L 메인이 저장된다.
    *   1) 저장 여부는 해당 메서드의 호출 여부로 확인한다.
    *   2) 저장 후 리포지토리에 데이터가 픽스쳐 + 1개 만큼 존재하는지 확인한다.
    * 2. B/L 내부의 Container가 저장된다.
    *   1) 저장 여부는 해당 메서드의 호출 여부로 확인한다.
    *   2) 저장 후 리포지토리에 데이터가 픽스쳐 내부 Container 데이터 + 1개 만큼 존재하는지 확인한다.
    * 3. B/L 내부의 HSCode가 저장된다.
    *   1) 저장 여부는 해당 메서드의 호출 여부로 확인한다.
    *   2) 저장 후 리포지토리에 데이터가 픽스쳐 내부 HSCode 데이터 + 1개 만큼 존재하는지 확인한다.
    * 4. B/L 내부의 Manifest가 저장된다.
    *   1) 저장 여부는 해당 메서드의 호출 여부로 확인한다.
    *   2) 저장 후 리포지토리에 데이터가 픽스쳐 내부 Manifest 데이터 + 1개 만큼 존재하는지 확인한다.
    * */
    /*
     * TODO [2] 조회
     * 1. 저장된 B/L 메인이 조회된다.
     *   1) B/L 메인의 존재 여부는 해당 B/L 메인의 ID로 리포지토리를 검색하여 확인한다.(모든 엔티티의 구조를 탐색할 필요가 없음)
     * 2. 저장된 Container가 조회된다.
     *   1) Container의 존재 여부는 해당 B/L 메인의 ID + Container의 서브 ID로 리포지토리를 검색하여 확인한다.
     * 3. 저장된 HSCode가 조회된다.
     *   1) HSCode의 존재 여부는 해당 B/L 메인의 ID + HSCode의 서브 ID로 리포지토리를 검색하여 확인한다.
     * 4. 저장된 Manifest가 조회된다.
     *   1) Manifest의 존재 여부는 해당 B/L 메인의 ID + Manifest의 서브 ID로 리포지토리를 검색하여 확인한다.
     */
    /*
     * TODO [3] 삭제
     * 1. 저장된 B/L 메인이 삭제 된다.
     *   1) B/L 메인의 삭제 여부는 리포지토리에 해당 ID가 존재하는지 여부이다.
     *   2) 삭제 후 리포지토리에 픽스쳐 개 만큼의 데이터가 존재하는지 확인한다.
     * 2. 저장된 Container가 삭제 된다.
     *   1) B/L 메인의 삭제 여부는 리포지토리에 해당 ID가 존재하는지 여부이다.
     *   2) 삭제 후 리포지토리에 픽스쳐 개 만큼의 데이터가 존재하는지 확인한다.
     * 3. 저장된 HSCode가 삭제 된다.
     *   1) B/L 메인의 삭제 여부는 리포지토리에 해당 ID가 존재하는지 여부이다.
     *   2) 삭제 후 리포지토리에 픽스쳐 개 만큼의 데이터가 존재하는지 확인한다.
     * 4. 저장된 Manifest가 삭제 된다.
     *   1) B/L 메인의 삭제 여부는 리포지토리에 해당 ID가 존재하는지 여부이다.
     *   2) 삭제 후 리포지토리에 픽스쳐 개 만큼의 데이터가 존재하는지 확인한다.
     * */

    @Test
    @DisplayName("B/L 메인이 저장된다")
    void testSaveBlMain(){
        //given

        //when

        //then
    }

    @Test
    @DisplayName("B/L 내부의 Container가 저장된다")
    void testSaveBlContainer(){
        //given

        //when

        //then
    }

    @Test
    @DisplayName("B/L 내부의 HSCode가 저장된다")
    void testSaveBlHSCode(){
        //given

        //when

        //then
    }

    @Test
    @DisplayName("B/L 내부의 Manifest가 저장된다")
    void testSaveBlManifest(){
        //given

        //when

        //then
    }
}