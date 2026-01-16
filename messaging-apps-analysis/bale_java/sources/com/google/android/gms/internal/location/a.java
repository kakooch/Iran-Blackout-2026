package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import ir.nasim.AbstractC6884Pj7;
import ir.nasim.C4982Hj7;
import ir.nasim.InterfaceC10672c03;

/* loaded from: classes3.dex */
final class a extends InterfaceC10672c03.a {
    final /* synthetic */ Object a;
    final /* synthetic */ C4982Hj7 h;

    a(i iVar, Object obj, C4982Hj7 c4982Hj7) {
        this.a = obj;
        this.h = c4982Hj7;
    }

    @Override // ir.nasim.InterfaceC10672c03
    public final void B1(Status status) {
        AbstractC6884Pj7.b(status, this.a, this.h);
    }
}
