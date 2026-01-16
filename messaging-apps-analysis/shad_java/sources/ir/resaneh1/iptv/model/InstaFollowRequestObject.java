package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;

/* loaded from: classes3.dex */
public class InstaFollowRequestObject extends PresenterItem {
    public Long create_date;
    public String followee_id;
    public String follower_id;
    public String id;

    public InstaFollowRequestObject(String str) {
        this.id = str;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getPresenterId() {
        return this.id;
    }
}
