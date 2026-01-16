package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;

/* loaded from: classes3.dex */
public final class Ki implements Ka {
    public final /* synthetic */ UserProfile a;

    public Ki(UserProfile userProfile) {
        this.a = userProfile;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.reportUserProfile(this.a);
    }
}
