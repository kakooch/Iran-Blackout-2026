package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class T0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C2601i1 c;

    public T0(C2601i1 c2601i1, String str, String str2) {
        this.c = c2601i1;
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1.a(this.c).b(this.a, this.b);
    }
}
