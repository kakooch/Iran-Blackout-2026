package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class J0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ C2601i1 b;

    public J0(C2601i1 c2601i1, String str) {
        this.b = c2601i1;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2743o0 c2743o0 = this.b.a;
        String str = this.a;
        c2743o0.getClass();
        C2719n0.f().setUserProfileID(str);
    }
}
