package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;

/* loaded from: classes3.dex */
public class DeliveryTimeObject extends PresenterItem {
    public String delivery_time_id;
    public String description;
    public String title;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getTitle() {
        return this.title;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getSearchAbleName() {
        return this.title + " " + this.description;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getId() {
        return this.delivery_time_id;
    }
}
