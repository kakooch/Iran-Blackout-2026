package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;

/* loaded from: classes3.dex */
public class IdCaptionItem extends PresenterItem {
    public String caption;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getSearchAbleName() {
        return this.caption;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getTitle() {
        return this.caption;
    }
}
