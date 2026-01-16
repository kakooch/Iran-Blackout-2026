package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class ShortcutObject extends PresenterItem {
    public String icon_url;
    public Link link;
    public String title;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.shortcut;
    }

    public ShortcutObject(String str, String str2) {
        this.title = str;
        this.icon_url = str2;
    }
}
