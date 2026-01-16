package com.google.android.gms.internal.vision;

import ir.nasim.Jp8;

/* loaded from: classes3.dex */
abstract class L implements Jp8 {
    L() {
    }

    @Override // java.util.Iterator
    public /* synthetic */ Object next() {
        return Byte.valueOf(zza());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
