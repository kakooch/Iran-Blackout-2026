package io.appmetrica.analytics.identifiers.impl;

import android.os.IBinder;

/* loaded from: classes3.dex */
public final class s implements u {
    public final IBinder a;

    public s(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}
