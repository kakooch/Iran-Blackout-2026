package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.Map;

/* loaded from: classes3.dex */
public class AODObjectDet extends PresenterItem {
    public Map<String, String> characteristics;
    public TagObject comments;
    public AODObjectAbs object_abs;
    public TagObject related;
    public Boolean send_message = Boolean.FALSE;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.AodDet;
    }
}
