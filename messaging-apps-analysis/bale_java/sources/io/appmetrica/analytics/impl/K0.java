package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;

/* loaded from: classes3.dex */
public final class K0 implements Runnable {
    public final /* synthetic */ UserProfile a;
    public final /* synthetic */ C2601i1 b;

    public K0(C2601i1 c2601i1, UserProfile userProfile) {
        this.b = c2601i1;
        this.a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1.a(this.b).reportUserProfile(this.a);
    }
}
