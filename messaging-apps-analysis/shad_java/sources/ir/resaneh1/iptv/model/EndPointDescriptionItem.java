package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class EndPointDescriptionItem extends PresenterItem {
    public String text;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.endPointDescriotion;
    }

    public EndPointDescriptionItem(String str) {
        this.text = str;
    }
}
