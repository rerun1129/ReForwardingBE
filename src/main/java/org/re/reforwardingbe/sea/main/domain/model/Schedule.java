package org.re.reforwardingbe.sea.main.domain.model;


public record Schedule(Liner liner, Vessel vessel, String voyageNumber, String etd, String eta, String onboardDate, SeaPort placeOfReceipt, SeaPort portOfLoading, SeaPort portOfDischarge,
                       SeaPort placeOfDelivery, SeaPort finalDestination) {
    public Schedule(String eta, String etd, SeaPort portOfLoading, SeaPort portOfDischarge, Vessel vessel, String voyageNumber) {
        this(null, vessel, voyageNumber, etd, eta, "", null, portOfLoading, portOfDischarge, null, null);
    }
}
