package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class SearchTabObject extends PresenterItem {
    public PresenterFragment fragment;
    public int icon;
    public int selectedIcon;
    public String text;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.searchTab;
    }
}
