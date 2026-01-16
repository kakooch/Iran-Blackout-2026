package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class DeliveryCityObject extends PresenterItem {
    public String city_id;
    public String name;
    public String province_id;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.city;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getSearchAbleName() {
        return this.name;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getId() {
        return this.city_id;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getTitle() {
        return this.name;
    }
}
