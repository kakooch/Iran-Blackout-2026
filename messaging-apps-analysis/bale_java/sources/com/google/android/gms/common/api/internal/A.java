package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.C2060d;
import com.google.android.gms.common.api.internal.C2063g;
import ir.nasim.C4982Hj7;

/* loaded from: classes3.dex */
final class A extends AbstractC2065i {
    final /* synthetic */ C2063g.a b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    A(C2063g.a aVar, C2060d.a aVar2) {
        super(aVar2);
        this.b = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC2065i
    protected final void b(a.b bVar, C4982Hj7 c4982Hj7) {
        this.b.b.accept(bVar, c4982Hj7);
    }
}
