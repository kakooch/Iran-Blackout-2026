package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.AbstractC2064h;
import ir.nasim.C4982Hj7;

/* loaded from: classes3.dex */
final class B extends AbstractC2064h {
    final /* synthetic */ AbstractC2064h.a d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    B(AbstractC2064h.a aVar, Feature[] featureArr, boolean z, int i) {
        super(featureArr, z, i);
        this.d = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC2064h
    protected final void b(a.b bVar, C4982Hj7 c4982Hj7) {
        this.d.a.accept(bVar, c4982Hj7);
    }
}
