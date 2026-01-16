package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SectionObject extends PresenterItem {
    public String section_id;
    public String section_title;
    public ArrayList<SessionObject> sessions = new ArrayList<>();

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.section;
    }
}
