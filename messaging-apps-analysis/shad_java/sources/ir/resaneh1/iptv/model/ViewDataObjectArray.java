package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ViewDataObjectArray extends PresenterItem {
    public String pagePartId;
    public ArrayList<ViewDataObject> arrayList = new ArrayList<>();
    public Integer viewId = null;

    public static int getPresenterItemTypeByViewId(int i) {
        return i;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.viewDataObjectArray;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public int getPresenterItemTypeInt() {
        Integer num = this.viewId;
        if (num != null) {
            return getPresenterItemTypeByViewId(num.intValue());
        }
        return getPresenterType().ordinal();
    }
}
