package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import ir.nasim.AbstractC10521bk8;
import ir.nasim.AbstractC13154fk8;
import ir.nasim.Gm8;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class T0 extends AbstractC10521bk8 implements Gm8 {
    T0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // ir.nasim.Gm8
    public final void C0(zzkw zzkwVar, zzq zzqVar) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.e(parcelB2, zzkwVar);
        AbstractC13154fk8.e(parcelB2, zzqVar);
        D2(2, parcelB2);
    }

    @Override // ir.nasim.Gm8
    public final void G0(zzq zzqVar) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.e(parcelB2, zzqVar);
        D2(20, parcelB2);
    }

    @Override // ir.nasim.Gm8
    public final List M0(String str, String str2, boolean z, zzq zzqVar) {
        Parcel parcelB2 = B2();
        parcelB2.writeString(str);
        parcelB2.writeString(str2);
        AbstractC13154fk8.d(parcelB2, z);
        AbstractC13154fk8.e(parcelB2, zzqVar);
        Parcel parcelC2 = C2(14, parcelB2);
        ArrayList arrayListCreateTypedArrayList = parcelC2.createTypedArrayList(zzkw.CREATOR);
        parcelC2.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // ir.nasim.Gm8
    public final void P0(zzq zzqVar) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.e(parcelB2, zzqVar);
        D2(18, parcelB2);
    }

    @Override // ir.nasim.Gm8
    public final List S1(String str, String str2, zzq zzqVar) {
        Parcel parcelB2 = B2();
        parcelB2.writeString(str);
        parcelB2.writeString(str2);
        AbstractC13154fk8.e(parcelB2, zzqVar);
        Parcel parcelC2 = C2(16, parcelB2);
        ArrayList arrayListCreateTypedArrayList = parcelC2.createTypedArrayList(zzac.CREATOR);
        parcelC2.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // ir.nasim.Gm8
    public final void h1(zzq zzqVar) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.e(parcelB2, zzqVar);
        D2(6, parcelB2);
    }

    @Override // ir.nasim.Gm8
    public final void k1(Bundle bundle, zzq zzqVar) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.e(parcelB2, bundle);
        AbstractC13154fk8.e(parcelB2, zzqVar);
        D2(19, parcelB2);
    }

    @Override // ir.nasim.Gm8
    public final List l1(String str, String str2, String str3, boolean z) {
        Parcel parcelB2 = B2();
        parcelB2.writeString(null);
        parcelB2.writeString(str2);
        parcelB2.writeString(str3);
        AbstractC13154fk8.d(parcelB2, z);
        Parcel parcelC2 = C2(15, parcelB2);
        ArrayList arrayListCreateTypedArrayList = parcelC2.createTypedArrayList(zzkw.CREATOR);
        parcelC2.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // ir.nasim.Gm8
    public final void m0(zzaw zzawVar, zzq zzqVar) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.e(parcelB2, zzawVar);
        AbstractC13154fk8.e(parcelB2, zzqVar);
        D2(1, parcelB2);
    }

    @Override // ir.nasim.Gm8
    public final void n2(zzac zzacVar, zzq zzqVar) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.e(parcelB2, zzacVar);
        AbstractC13154fk8.e(parcelB2, zzqVar);
        D2(12, parcelB2);
    }

    @Override // ir.nasim.Gm8
    public final void o0(zzq zzqVar) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.e(parcelB2, zzqVar);
        D2(4, parcelB2);
    }

    @Override // ir.nasim.Gm8
    public final byte[] r1(zzaw zzawVar, String str) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.e(parcelB2, zzawVar);
        parcelB2.writeString(str);
        Parcel parcelC2 = C2(9, parcelB2);
        byte[] bArrCreateByteArray = parcelC2.createByteArray();
        parcelC2.recycle();
        return bArrCreateByteArray;
    }

    @Override // ir.nasim.Gm8
    public final String u1(zzq zzqVar) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.e(parcelB2, zzqVar);
        Parcel parcelC2 = C2(11, parcelB2);
        String string = parcelC2.readString();
        parcelC2.recycle();
        return string;
    }

    @Override // ir.nasim.Gm8
    public final void v0(long j, String str, String str2, String str3) {
        Parcel parcelB2 = B2();
        parcelB2.writeLong(j);
        parcelB2.writeString(str);
        parcelB2.writeString(str2);
        parcelB2.writeString(str3);
        D2(10, parcelB2);
    }

    @Override // ir.nasim.Gm8
    public final List y1(String str, String str2, String str3) {
        Parcel parcelB2 = B2();
        parcelB2.writeString(null);
        parcelB2.writeString(str2);
        parcelB2.writeString(str3);
        Parcel parcelC2 = C2(17, parcelB2);
        ArrayList arrayListCreateTypedArrayList = parcelC2.createTypedArrayList(zzac.CREATOR);
        parcelC2.recycle();
        return arrayListCreateTypedArrayList;
    }
}
