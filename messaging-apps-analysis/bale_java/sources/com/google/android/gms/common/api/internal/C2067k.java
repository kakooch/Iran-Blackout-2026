package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.Task;
import ir.nasim.C4982Hj7;
import ir.nasim.WI4;

/* renamed from: com.google.android.gms.common.api.internal.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2067k implements WI4 {
    final /* synthetic */ C4982Hj7 a;
    final /* synthetic */ C2068l b;

    C2067k(C2068l c2068l, C4982Hj7 c4982Hj7) {
        this.b = c2068l;
        this.a = c4982Hj7;
    }

    @Override // ir.nasim.WI4
    public final void onComplete(Task task) {
        this.b.b.remove(this.a);
    }
}
