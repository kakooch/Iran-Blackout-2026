package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.b1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2217b1 {
    private final int a;
    private final boolean b;
    private final boolean c;
    final /* synthetic */ C2227d1 d;

    C2217b1(C2227d1 c2227d1, int i, boolean z, boolean z2) {
        this.d = c2227d1;
        this.a = i;
        this.b = z;
        this.c = z2;
    }

    public final void a(String str) {
        this.d.F(this.a, this.b, this.c, str, null, null, null);
    }

    public final void b(String str, Object obj) {
        this.d.F(this.a, this.b, this.c, str, obj, null, null);
    }

    public final void c(String str, Object obj, Object obj2) {
        this.d.F(this.a, this.b, this.c, str, obj, obj2, null);
    }

    public final void d(String str, Object obj, Object obj2, Object obj3) {
        this.d.F(this.a, this.b, this.c, str, obj, obj2, obj3);
    }
}
