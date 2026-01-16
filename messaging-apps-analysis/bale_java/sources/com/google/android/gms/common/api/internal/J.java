package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import ir.nasim.Ye8;

/* loaded from: classes3.dex */
final class J extends Ye8 {
    final /* synthetic */ Dialog a;
    final /* synthetic */ K b;

    J(K k, Dialog dialog) {
        this.b = k;
        this.a = dialog;
    }

    @Override // ir.nasim.Ye8
    public final void a() {
        this.b.b.o();
        if (this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
