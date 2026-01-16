package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.cm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2476cm implements Hm {
    public final Hm a;
    public final Object b;

    public C2476cm(Hm hm, Object obj) {
        this.a = hm;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.impl.Hm
    public final Object a(Object obj) {
        return obj != this.a.a(obj) ? this.b : obj;
    }
}
