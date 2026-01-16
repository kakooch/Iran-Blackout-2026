package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.C2063g;
import ir.nasim.C4982Hj7;

/* loaded from: classes3.dex */
final class z extends AbstractC2062f {
    final /* synthetic */ C2063g.a e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    z(C2063g.a aVar, C2060d c2060d, Feature[] featureArr, boolean z, int i) {
        super(c2060d, featureArr, z, i);
        this.e = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC2062f
    protected final void d(a.b bVar, C4982Hj7 c4982Hj7) {
        this.e.a.accept(bVar, c4982Hj7);
    }
}
