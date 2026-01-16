package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
final class J extends L {
    private int a = 0;
    private final int b;
    private final /* synthetic */ K c;

    J(K k) {
        this.c = k;
        this.b = k.j();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b;
    }

    @Override // ir.nasim.Jp8
    public final byte zza() {
        int i = this.a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.a = i + 1;
        return this.c.N(i);
    }
}
