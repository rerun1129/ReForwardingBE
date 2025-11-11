package org.re.reforwardingbe.sea.main.domain.vo;

public class Party {
    private final Shipper shipper;
    private final Consignee consignee;
    private final Notify notify;

    public Party(Shipper shipper, Consignee consignee, Notify notify) {
        this.shipper = shipper;
        this.consignee = consignee;
        this.notify = notify;
    }
}
