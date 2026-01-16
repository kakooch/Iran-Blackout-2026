package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import ir.nasim.AbstractC22929w35;

/* renamed from: com.google.android.gms.common.api.internal.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2066j implements AbstractC22929w35.a {
    final /* synthetic */ BasePendingResult a;
    final /* synthetic */ C2068l b;

    C2066j(C2068l c2068l, BasePendingResult basePendingResult) {
        this.b = c2068l;
        this.a = basePendingResult;
    }

    @Override // ir.nasim.AbstractC22929w35.a
    public final void a(Status status) {
        this.b.a.remove(this.a);
    }
}
