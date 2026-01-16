package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class k4 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        String strF = "";
        String strF2 = strF;
        String strF3 = null;
        String strF4 = null;
        String strF5 = null;
        String strF6 = null;
        String strF7 = null;
        String strF8 = null;
        String strF9 = null;
        Boolean boolN = null;
        ArrayList arrayListH = null;
        String strF10 = null;
        String strF11 = null;
        long jX = 0;
        long jX2 = 0;
        long jX3 = 0;
        long jX4 = 0;
        long jX5 = 0;
        boolean zM = true;
        boolean zM2 = true;
        boolean zM3 = false;
        int iV = 0;
        boolean zM4 = false;
        long jX6 = -2147483648L;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 2:
                    strF3 = SafeParcelReader.f(parcel, iT);
                    break;
                case 3:
                    strF4 = SafeParcelReader.f(parcel, iT);
                    break;
                case 4:
                    strF5 = SafeParcelReader.f(parcel, iT);
                    break;
                case 5:
                    strF6 = SafeParcelReader.f(parcel, iT);
                    break;
                case 6:
                    jX = SafeParcelReader.x(parcel, iT);
                    break;
                case 7:
                    jX2 = SafeParcelReader.x(parcel, iT);
                    break;
                case 8:
                    strF7 = SafeParcelReader.f(parcel, iT);
                    break;
                case 9:
                    zM = SafeParcelReader.m(parcel, iT);
                    break;
                case 10:
                    zM3 = SafeParcelReader.m(parcel, iT);
                    break;
                case 11:
                    jX6 = SafeParcelReader.x(parcel, iT);
                    break;
                case 12:
                    strF8 = SafeParcelReader.f(parcel, iT);
                    break;
                case 13:
                    jX3 = SafeParcelReader.x(parcel, iT);
                    break;
                case 14:
                    jX4 = SafeParcelReader.x(parcel, iT);
                    break;
                case 15:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 16:
                    zM2 = SafeParcelReader.m(parcel, iT);
                    break;
                case 17:
                case 20:
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
                case 18:
                    zM4 = SafeParcelReader.m(parcel, iT);
                    break;
                case 19:
                    strF9 = SafeParcelReader.f(parcel, iT);
                    break;
                case 21:
                    boolN = SafeParcelReader.n(parcel, iT);
                    break;
                case 22:
                    jX5 = SafeParcelReader.x(parcel, iT);
                    break;
                case 23:
                    arrayListH = SafeParcelReader.h(parcel, iT);
                    break;
                case 24:
                    strF10 = SafeParcelReader.f(parcel, iT);
                    break;
                case 25:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 26:
                    strF2 = SafeParcelReader.f(parcel, iT);
                    break;
                case 27:
                    strF11 = SafeParcelReader.f(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzq(strF3, strF4, strF5, strF6, jX, jX2, strF7, zM, zM3, jX6, strF8, jX3, jX4, iV, zM2, zM4, strF9, boolN, jX5, arrayListH, strF10, strF, strF2, strF11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzq[i];
    }
}
