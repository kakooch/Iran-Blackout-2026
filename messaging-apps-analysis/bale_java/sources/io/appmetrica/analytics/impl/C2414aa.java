package io.appmetrica.analytics.impl;

import android.os.Bundle;

/* renamed from: io.appmetrica.analytics.impl.aa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2414aa extends L4 {
    public C2414aa(I4 i4) {
        super(i4);
    }

    @Override // io.appmetrica.analytics.impl.L4
    public final boolean a(Q5 q5, F4 f4) {
        Bundle bundle = q5.m;
        this.a.a(bundle != null ? (Ra) bundle.getParcelable("io.appmetrica.analytics.impl.IdentifiersData") : null);
        return false;
    }
}
