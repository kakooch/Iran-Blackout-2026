package com.google.android.gms.internal.measurement;

import ir.nasim.Rr8;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.u, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2147u extends O0 implements Rr8 {
    /* synthetic */ C2147u(AbstractC2138p abstractC2138p) {
        super(C2149v.zza);
    }

    public final int r() {
        return ((C2149v) this.b).B();
    }

    public final C2145t s(int i) {
        return ((C2149v) this.b).D(i);
    }

    public final C2147u t() {
        o();
        ((C2149v) this.b).zzj = P0.m();
        return this;
    }

    public final C2147u u(int i, C2143s c2143s) {
        o();
        C2149v.N((C2149v) this.b, i, (C2145t) c2143s.m());
        return this;
    }

    public final String v() {
        return ((C2149v) this.b).I();
    }

    public final List w() {
        return Collections.unmodifiableList(((C2149v) this.b).J());
    }

    public final List x() {
        return Collections.unmodifiableList(((C2149v) this.b).K());
    }
}
