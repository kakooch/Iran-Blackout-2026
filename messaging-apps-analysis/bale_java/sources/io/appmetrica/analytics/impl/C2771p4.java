package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;

/* renamed from: io.appmetrica.analytics.impl.p4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2771p4 {
    public final SystemTimeProvider a;

    public C2771p4() {
        this(new SystemTimeProvider());
    }

    public final void a() {
        this.a.elapsedRealtime();
    }

    public C2771p4(SystemTimeProvider systemTimeProvider) {
        this.a = systemTimeProvider;
    }
}
