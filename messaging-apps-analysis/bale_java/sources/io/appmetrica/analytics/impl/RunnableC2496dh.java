package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;

/* renamed from: io.appmetrica.analytics.impl.dh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2496dh implements Runnable {
    public final /* synthetic */ UserProfile a;
    public final /* synthetic */ C2951wh b;

    public RunnableC2496dh(C2951wh c2951wh, UserProfile userProfile) {
        this.b = c2951wh;
        this.a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.b;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).reportUserProfile(this.a);
    }
}
