package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ir.nasim.AbstractC11061cf8;
import ir.nasim.InterfaceC23286wf8;
import ir.nasim.Le8;

/* loaded from: classes3.dex */
public final class c extends Le8 implements IInterface {
    c(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void F2(zai zaiVar, InterfaceC23286wf8 interfaceC23286wf8) {
        Parcel parcelB2 = B2();
        AbstractC11061cf8.c(parcelB2, zaiVar);
        AbstractC11061cf8.d(parcelB2, interfaceC23286wf8);
        D2(12, parcelB2);
    }
}
