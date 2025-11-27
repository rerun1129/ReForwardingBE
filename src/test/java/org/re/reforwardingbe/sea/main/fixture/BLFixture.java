package org.re.reforwardingbe.sea.main.fixture;

import org.re.reforwardingbe.sea.main.domain.model.*;
import org.re.reforwardingbe.sea.main.domain.specification.BLSpec;
import org.re.reforwardingbe.sea.main.domain.specification.ContainerSpec;
import org.re.reforwardingbe.sea.main.domain.specification.HSCodeSpec;
import org.re.reforwardingbe.sea.main.domain.specification.ManifestSpec;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
import static org.re.reforwardingbe.sea.main.domain.model.PackageUnit.CB;
import static org.re.reforwardingbe.sea.main.domain.model.ServiceTerm.CFS_TO_CY;
import static org.re.reforwardingbe.sea.main.domain.model.ServiceTerm.CY_TO_CFS;
import static org.re.reforwardingbe.sea.main.domain.model.ShipmentType.DIRECT;
import static org.re.reforwardingbe.sea.main.domain.model.ShipmentType.HOUSE;
import static org.re.reforwardingbe.sea.main.domain.model.UnknownClause1.SLC;
import static org.re.reforwardingbe.sea.main.domain.model.UnknownClause2.STC;

public class BLFixture {
    public static BL createDefault1(){
        BLId fixture1Id = BLId.withoutId();
        ContainerSpec containerSpec1_1 = new ContainerSpec(fixture1Id, ContainerId.withoutId(), "ContainerNo1-1", F0FH, "1", "2", "3", "4", "5", "6", 50, CB, BigDecimal.valueOf(550.500), BigDecimal.valueOf(0.550));
        ContainerSpec containerSpec1_2 = new ContainerSpec(fixture1Id, ContainerId.withoutId(), "ContainerNo1-2", F0FH, null, null, null, null, null, null, 50, CB, BigDecimal.valueOf(1000.000), BigDecimal.valueOf(1.000));
        HSCodeSpec hsCodeSpec1_1 = new HSCodeSpec(fixture1Id, HSCodeId.withoutId(), "010100", "horse", true);
        HSCodeSpec hsCodeSpec1_2 = new HSCodeSpec(fixture1Id, HSCodeId.withoutId(), "420100", "horse saddle", false);
        ManifestSpec manifestSpec1_1 = new ManifestSpec(fixture1Id, ManifestId.withoutId(), "ManifestNo1-1", 50, CB, BigDecimal.valueOf(550.500));
        ManifestSpec manifestSpec1_2 = new ManifestSpec(fixture1Id, ManifestId.withoutId(), "ManifestNo1-2", 50, CB, BigDecimal.valueOf(1000.000));
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
        return BL.of(blSpec1);
    }

    public static BL createDefault2(){
        BLId fixture2Id = BLId.withoutId();
        ContainerSpec containerSpec2_1 = new ContainerSpec(fixture2Id, ContainerId.withoutId(), "ContainerNo2-1", T0FR, "1", "2", "3", "4", "5", "6", 40, CB, BigDecimal.valueOf(1000.000), BigDecimal.valueOf(0.800));

        ContainerSpec containerSpec2_2 = new ContainerSpec(fixture2Id, ContainerId.withoutId(), "ContainerNo2-2", T0FR, null, null, null, null, null, null, 60, CB, BigDecimal.valueOf(1700.000), BigDecimal.valueOf(1.000));

        HSCodeSpec hsCodeSpec2_1 = new HSCodeSpec(fixture2Id, HSCodeId.withoutId(), "870380", "Battery Electric Vehicle", true);
        HSCodeSpec hsCodeSpec2_2 = new HSCodeSpec(fixture2Id, HSCodeId.withoutId(), "850760", "Lithium-ion Battery", false);
        ManifestSpec manifestSpec2_1 = new ManifestSpec(fixture2Id, ManifestId.withoutId(), "ManifestNo2-1", 40, CB, BigDecimal.valueOf(1000.000));
        ManifestSpec manifestSpec2_2 = new ManifestSpec(fixture2Id, ManifestId.withoutId(), "ManifestNo2-2", 60, CB, BigDecimal.valueOf(1700.000));
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
        return BL.of(blSpec2);
    }

    public static BL createEdgeCase(){
        return null;
    }
}
