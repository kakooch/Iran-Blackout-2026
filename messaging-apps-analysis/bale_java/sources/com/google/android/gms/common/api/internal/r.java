package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.b;

/* loaded from: classes3.dex */
final class r implements b.e {
    final /* synthetic */ s a;

    r(s sVar) {
        this.a = sVar;
    }

    @Override // com.google.android.gms.common.internal.b.e
    public final void a() {
        this.a.s.p.post(new q(this));
    }
}
