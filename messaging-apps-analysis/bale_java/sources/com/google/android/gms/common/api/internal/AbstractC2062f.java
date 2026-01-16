package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.C2060d;
import ir.nasim.C4982Hj7;

/* renamed from: com.google.android.gms.common.api.internal.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2062f {
    private final C2060d a;
    private final Feature[] b;
    private final boolean c;
    private final int d;

    protected AbstractC2062f(C2060d c2060d, Feature[] featureArr, boolean z, int i) {
        this.a = c2060d;
        this.b = featureArr;
        this.c = z;
        this.d = i;
    }

    public void a() {
        this.a.a();
    }

    public C2060d.a b() {
        return this.a.b();
    }

    public Feature[] c() {
        return this.b;
    }

    protected abstract void d(a.b bVar, C4982Hj7 c4982Hj7);

    public final int e() {
        return this.d;
    }

    public final boolean f() {
        return this.c;
    }
}
