package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;

/* renamed from: io.appmetrica.analytics.impl.a1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2405a1 implements Runnable {
    public final /* synthetic */ ExternalAttribution a;
    public final /* synthetic */ C2601i1 b;

    public RunnableC2405a1(C2601i1 c2601i1, ExternalAttribution externalAttribution) {
        this.b = c2601i1;
        this.a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1.a(this.b).a(this.a);
    }
}
