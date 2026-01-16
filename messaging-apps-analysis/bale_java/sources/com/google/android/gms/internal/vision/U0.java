package com.google.android.gms.internal.vision;

import java.util.Iterator;

/* loaded from: classes3.dex */
final class U0 extends a1 {
    private final /* synthetic */ T0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private U0(T0 t0) {
        super(t0, null);
        this.b = t0;
    }

    @Override // com.google.android.gms.internal.vision.a1, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new V0(this.b, null);
    }

    /* synthetic */ U0(T0 t0, S0 s0) {
        this(t0);
    }
}
