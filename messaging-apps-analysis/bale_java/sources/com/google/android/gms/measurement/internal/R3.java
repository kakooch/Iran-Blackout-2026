package com.google.android.gms.measurement.internal;

import java.util.Map;

/* loaded from: classes3.dex */
final class R3 implements InterfaceC2237f1 {
    final /* synthetic */ String a;
    final /* synthetic */ Y3 b;

    R3(Y3 y3, String str) {
        this.b = y3;
        this.a = str;
    }

    @Override // com.google.android.gms.measurement.internal.InterfaceC2237f1
    public final void a(String str, int i, Throwable th, byte[] bArr, Map map) {
        this.b.p(i, th, bArr, this.a);
    }
}
