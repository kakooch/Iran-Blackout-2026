package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;

/* renamed from: io.appmetrica.analytics.impl.k4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2651k4 extends AbstractC2826rc {
    public final C2637je a;

    public C2651k4(Context context) {
        this(new C2637je(W6.a(context).b()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2826rc
    public final void a(int i) {
        this.a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2826rc
    public final int b() {
        return (int) this.a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2826rc
    public final SparseArray<C2953wj> c() {
        return new SparseArray<>();
    }

    public C2651k4(C2637je c2637je) {
        this.a = c2637je;
    }
}
