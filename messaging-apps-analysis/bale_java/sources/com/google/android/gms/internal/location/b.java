package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.Status;
import ir.nasim.AbstractC6884Pj7;
import ir.nasim.C4982Hj7;
import ir.nasim.Nt8;

/* loaded from: classes3.dex */
final class b extends Nt8 {
    final /* synthetic */ C4982Hj7 a;

    b(i iVar, C4982Hj7 c4982Hj7) {
        this.a = c4982Hj7;
    }

    @Override // ir.nasim.InterfaceC20382ru8
    public final void N(Status status, Location location) {
        AbstractC6884Pj7.b(status, location, this.a);
    }
}
