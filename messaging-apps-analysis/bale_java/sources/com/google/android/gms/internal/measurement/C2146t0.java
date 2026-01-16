package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.t0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2146t0 extends AbstractC2150v0 {
    private int a = 0;
    private final int b;
    final /* synthetic */ A0 c;

    C2146t0(A0 a0) {
        this.c = a0;
        this.b = a0.r();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b;
    }

    @Override // ir.nasim.InterfaceC23986xq8
    public final byte zza() {
        int i = this.a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.a = i + 1;
        return this.c.j(i);
    }
}
