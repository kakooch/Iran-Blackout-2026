package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.AbstractC2101z;
import ir.nasim.InterfaceC20302rm8;

/* renamed from: com.google.android.gms.internal.clearcut.c0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2076c0 implements S {
    private final InterfaceC20302rm8 a;
    private final String b;
    private final C2078d0 c;

    C2076c0(InterfaceC20302rm8 interfaceC20302rm8, String str, Object[] objArr) {
        this.a = interfaceC20302rm8;
        this.b = str;
        this.c = new C2078d0(interfaceC20302rm8.getClass(), str, objArr);
    }

    @Override // com.google.android.gms.internal.clearcut.S
    public final int a() {
        return (this.c.d & 1) == 1 ? AbstractC2101z.c.i : AbstractC2101z.c.j;
    }

    @Override // com.google.android.gms.internal.clearcut.S
    public final boolean b() {
        return (this.c.d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.clearcut.S
    public final InterfaceC20302rm8 c() {
        return this.a;
    }

    public final int d() {
        return this.c.e;
    }

    final C2078d0 e() {
        return this.c;
    }

    public final int f() {
        return this.c.h;
    }

    public final int g() {
        return this.c.i;
    }

    public final int h() {
        return this.c.j;
    }

    public final int i() {
        return this.c.m;
    }

    final int[] j() {
        return this.c.n;
    }

    public final int k() {
        return this.c.l;
    }

    public final int l() {
        return this.c.k;
    }
}
