package org.re.reforwardingbe.sea.main.domain.vo;


public record Schedule(Liner liner, Vessel vessel, String voyageNumber, String etd, String eta, String onboardDate, SeaPort placeOfReceipt, SeaPort portOfLoading, SeaPort portOfDischarge,
                       SeaPort placeOfDelivery, SeaPort finalDestination) {
}
