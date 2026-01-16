package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import ir.nasim.Gk8;
import ir.nasim.Ig8;
import ir.nasim.InterfaceC10672c03;
import ir.nasim.InterfaceC11374ct8;
import ir.nasim.InterfaceC20382ru8;
import ir.nasim.Ju8;

/* loaded from: classes3.dex */
public final class o extends Ig8 implements InterfaceC11374ct8 {
    o(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // ir.nasim.InterfaceC11374ct8
    public final void Q0(LocationSettingsRequest locationSettingsRequest, Ju8 ju8, String str) {
        Parcel parcelB2 = B2();
        Gk8.c(parcelB2, locationSettingsRequest);
        Gk8.d(parcelB2, ju8);
        parcelB2.writeString(null);
        D2(63, parcelB2);
    }

    @Override // ir.nasim.InterfaceC11374ct8
    public final void W0(zzdb zzdbVar, InterfaceC10672c03 interfaceC10672c03) {
        Parcel parcelB2 = B2();
        Gk8.c(parcelB2, zzdbVar);
        Gk8.d(parcelB2, interfaceC10672c03);
        D2(89, parcelB2);
    }

    @Override // ir.nasim.InterfaceC11374ct8
    public final Location d() {
        Parcel parcelC2 = C2(7, B2());
        Location location = (Location) Gk8.a(parcelC2, Location.CREATOR);
        parcelC2.recycle();
        return location;
    }

    @Override // ir.nasim.InterfaceC11374ct8
    public final void j2(zzdb zzdbVar, LocationRequest locationRequest, InterfaceC10672c03 interfaceC10672c03) {
        Parcel parcelB2 = B2();
        Gk8.c(parcelB2, zzdbVar);
        Gk8.c(parcelB2, locationRequest);
        Gk8.d(parcelB2, interfaceC10672c03);
        D2(88, parcelB2);
    }

    @Override // ir.nasim.InterfaceC11374ct8
    public final void v2(LastLocationRequest lastLocationRequest, InterfaceC20382ru8 interfaceC20382ru8) {
        Parcel parcelB2 = B2();
        Gk8.c(parcelB2, lastLocationRequest);
        Gk8.d(parcelB2, interfaceC20382ru8);
        D2(82, parcelB2);
    }

    @Override // ir.nasim.InterfaceC11374ct8
    public final void w1(zzdf zzdfVar) {
        Parcel parcelB2 = B2();
        Gk8.c(parcelB2, zzdfVar);
        D2(59, parcelB2);
    }
}
