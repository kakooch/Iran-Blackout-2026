package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class V0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C2601i1 c;

    public V0(C2601i1 c2601i1, String str, String str2) {
        this.c = c2601i1;
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2743o0 c2743o0 = this.c.a;
        String str = this.a;
        String str2 = this.b;
        c2743o0.getClass();
        C2719n0.f().putAppEnvironmentValue(str, str2);
    }
}
