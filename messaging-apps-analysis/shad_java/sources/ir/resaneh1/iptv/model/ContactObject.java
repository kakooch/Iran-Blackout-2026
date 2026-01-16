package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class ContactObject extends PresenterItem {
    public String fullname;
    public String imageUrl;
    public String lastSeen;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.Contact;
    }

    public ContactObject(String str, String str2, String str3) {
        this.fullname = str;
        this.lastSeen = str2;
        this.imageUrl = str3;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getSearchAbleName() {
        return this.fullname;
    }
}
