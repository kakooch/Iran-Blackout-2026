package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import ir.nasim.AbstractC9921am8;
import ir.nasim.InterfaceC16758lo8;

/* loaded from: classes3.dex */
public final class e extends AbstractC9921am8 implements InterfaceC16758lo8 {
    e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gcm.INetworkTaskCallback");
    }

    @Override // ir.nasim.InterfaceC16758lo8
    public final void y(int i) {
        Parcel parcelB2 = B2();
        parcelB2.writeInt(i);
        C2(2, parcelB2);
    }
}
