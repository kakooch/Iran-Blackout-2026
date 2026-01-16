package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class DeliveryInfoObject extends PresenterItem {
    public String address;
    public DeliveryCityObject city;
    public String delivery_info_id;
    public boolean is_default;
    public LocationObject location;
    public String postal_code;
    public DeliveryProvinceObject province;
    public String recipient_mobile;
    public String recipient_name;
    public String recipient_phone;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.AddressObject;
    }
}
