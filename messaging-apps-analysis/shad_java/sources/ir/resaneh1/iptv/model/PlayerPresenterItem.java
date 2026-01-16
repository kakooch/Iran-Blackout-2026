package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class PlayerPresenterItem extends PresenterItem {
    public String image_url;
    public String stream_id;
    public String stream_type;
    public String stream_url;
    public boolean isLive = false;
    public boolean isForcePlayFromBegin = false;
    public boolean isTouchControllerAlwaysEnabled = false;

    public PlayerPresenterItem(String str, String str2) {
        this.stream_id = str;
        this.stream_type = str2;
    }

    public PlayerPresenterItem(String str) {
        this.stream_url = str;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.PlayerPresenterItem;
    }
}
