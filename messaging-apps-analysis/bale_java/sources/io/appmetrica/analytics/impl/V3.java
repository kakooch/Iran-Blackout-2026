package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;

/* loaded from: classes3.dex */
public final class V3 extends SimpleThreadSafeToggle {
    public final C2733ne a;

    public V3(C2733ne c2733ne) {
        super(c2733ne.e(), "[ClientApiTrackingStatusToggle]");
        this.a = c2733ne;
    }

    public final void a(boolean z) {
        updateState(z);
        this.a.d(z);
    }
}
