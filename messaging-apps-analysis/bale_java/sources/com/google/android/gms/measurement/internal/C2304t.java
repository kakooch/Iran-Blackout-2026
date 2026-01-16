package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import ir.nasim.AbstractC21804u96;

/* renamed from: com.google.android.gms.measurement.internal.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2304t implements Parcelable.Creator {
    static void a(zzaw zzawVar, Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.t(parcel, 2, zzawVar.a, false);
        AbstractC21804u96.s(parcel, 3, zzawVar.b, i, false);
        AbstractC21804u96.t(parcel, 4, zzawVar.c, false);
        AbstractC21804u96.q(parcel, 5, zzawVar.d);
        AbstractC21804u96.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        String strF = null;
        zzau zzauVar = null;
        String strF2 = null;
        long jX = 0;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 2) {
                strF = SafeParcelReader.f(parcel, iT);
            } else if (iL == 3) {
                zzauVar = (zzau) SafeParcelReader.e(parcel, iT, zzau.CREATOR);
            } else if (iL == 4) {
                strF2 = SafeParcelReader.f(parcel, iT);
            } else if (iL != 5) {
                SafeParcelReader.A(parcel, iT);
            } else {
                jX = SafeParcelReader.x(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzaw(strF, zzauVar, strF2, jX);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaw[i];
    }
}
