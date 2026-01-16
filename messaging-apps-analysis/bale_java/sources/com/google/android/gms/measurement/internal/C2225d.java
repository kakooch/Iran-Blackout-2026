package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.measurement.internal.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2225d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        String strF = null;
        String strF2 = null;
        zzkw zzkwVar = null;
        String strF3 = null;
        zzaw zzawVar = null;
        zzaw zzawVar2 = null;
        zzaw zzawVar3 = null;
        long jX = 0;
        long jX2 = 0;
        long jX3 = 0;
        boolean zM = false;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 2:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 3:
                    strF2 = SafeParcelReader.f(parcel, iT);
                    break;
                case 4:
                    zzkwVar = (zzkw) SafeParcelReader.e(parcel, iT, zzkw.CREATOR);
                    break;
                case 5:
                    jX = SafeParcelReader.x(parcel, iT);
                    break;
                case 6:
                    zM = SafeParcelReader.m(parcel, iT);
                    break;
                case 7:
                    strF3 = SafeParcelReader.f(parcel, iT);
                    break;
                case 8:
                    zzawVar = (zzaw) SafeParcelReader.e(parcel, iT, zzaw.CREATOR);
                    break;
                case 9:
                    jX2 = SafeParcelReader.x(parcel, iT);
                    break;
                case 10:
                    zzawVar2 = (zzaw) SafeParcelReader.e(parcel, iT, zzaw.CREATOR);
                    break;
                case 11:
                    jX3 = SafeParcelReader.x(parcel, iT);
                    break;
                case 12:
                    zzawVar3 = (zzaw) SafeParcelReader.e(parcel, iT, zzaw.CREATOR);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzac(strF, strF2, zzkwVar, jX, zM, strF3, zzawVar, jX2, zzawVar2, jX3, zzawVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzac[i];
    }
}
