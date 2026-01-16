package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class StoryEntityItemArray extends PresenterItem {
    public ArrayList<StoryEntityItem> array;
    public PresenterItemType presenterItemType;

    public StoryEntityItemArray(PresenterItemType presenterItemType) {
        this.presenterItemType = presenterItemType;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return this.presenterItemType;
    }
}
