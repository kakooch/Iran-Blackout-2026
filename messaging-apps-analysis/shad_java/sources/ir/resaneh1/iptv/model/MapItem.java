package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class MapItem extends PresenterItem {
    public LocationObject locationObject;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.mapItem;
    }
}
