package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.helper.AppRubinoPreferences;

/* loaded from: classes3.dex */
public class InstaInput {
    public String profile_id;

    public void setProfileId(int i) {
        try {
            this.profile_id = AppRubinoPreferences.getInstance(i).getRubinoCurrentProfileObject().id;
        } catch (Exception unused) {
        }
    }
}
