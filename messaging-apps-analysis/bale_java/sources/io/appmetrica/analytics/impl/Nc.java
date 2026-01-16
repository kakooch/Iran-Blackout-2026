package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* loaded from: classes3.dex */
public final class Nc extends SafeRunnable {
    public final /* synthetic */ Oc a;
    public final /* synthetic */ String b;
    public final /* synthetic */ byte[] c;

    public Nc(Oc oc, String str, byte[] bArr) {
        this.a = oc;
        this.b = str;
        this.c = bArr;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Oc.a(this.a).setSessionExtra(this.b, this.c);
    }
}
