package com.google.android.gms.measurement.internal;

import ir.nasim.AbstractC16157kn8;
import ir.nasim.AbstractC3795Cj5;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.g1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2242g1 implements Runnable {
    private final InterfaceC2237f1 a;
    private final int b;
    private final Throwable c;
    private final byte[] d;
    private final String e;
    private final Map f;

    /* synthetic */ RunnableC2242g1(String str, InterfaceC2237f1 interfaceC2237f1, int i, Throwable th, byte[] bArr, Map map, AbstractC16157kn8 abstractC16157kn8) {
        AbstractC3795Cj5.j(interfaceC2237f1);
        this.a = interfaceC2237f1;
        this.b = i;
        this.c = th;
        this.d = bArr;
        this.e = str;
        this.f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.e, this.b, this.c, this.d, this.f);
    }
}
