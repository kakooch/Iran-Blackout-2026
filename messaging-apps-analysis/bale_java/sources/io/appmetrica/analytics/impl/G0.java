package io.appmetrica.analytics.impl;

import android.location.Location;

/* loaded from: classes3.dex */
public final class G0 implements Runnable {
    public final /* synthetic */ Location a;
    public final /* synthetic */ C2601i1 b;

    public G0(C2601i1 c2601i1, Location location) {
        this.b = c2601i1;
        this.a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2743o0 c2743o0 = this.b.a;
        Location location = this.a;
        c2743o0.getClass();
        C2719n0.f().a(location);
    }
}
