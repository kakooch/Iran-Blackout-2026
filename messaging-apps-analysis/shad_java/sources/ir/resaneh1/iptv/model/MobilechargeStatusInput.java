package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;

/* loaded from: classes3.dex */
public class MobilechargeStatusInput extends PresenterItem {
    public boolean done;
    public String token;

    public MobilechargeStatusInput(String str, boolean z) {
        this.token = str;
        this.done = z;
    }
}
