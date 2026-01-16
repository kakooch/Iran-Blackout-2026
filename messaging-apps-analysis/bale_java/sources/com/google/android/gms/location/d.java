package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzd;

/* loaded from: classes3.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        WorkSource workSource = new WorkSource();
        int iV = 102;
        long jX = 3600000;
        long jX2 = 600000;
        long jX3 = 0;
        long jX4 = Long.MAX_VALUE;
        long jX5 = Long.MAX_VALUE;
        int iV2 = Integer.MAX_VALUE;
        float fR = 0.0f;
        boolean zM = false;
        int iV3 = 0;
        int iV4 = 0;
        boolean zM2 = false;
        long jX6 = -1;
        String strF = null;
        zzd zzdVar = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 1:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 2:
                    jX = SafeParcelReader.x(parcel, iT);
                    break;
                case 3:
                    jX2 = SafeParcelReader.x(parcel, iT);
                    break;
                case 4:
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
                case 5:
                    jX4 = SafeParcelReader.x(parcel, iT);
                    break;
                case 6:
                    iV2 = SafeParcelReader.v(parcel, iT);
                    break;
                case 7:
                    fR = SafeParcelReader.r(parcel, iT);
                    break;
                case 8:
                    jX3 = SafeParcelReader.x(parcel, iT);
                    break;
                case 9:
                    zM = SafeParcelReader.m(parcel, iT);
                    break;
                case 10:
                    jX5 = SafeParcelReader.x(parcel, iT);
                    break;
                case 11:
                    jX6 = SafeParcelReader.x(parcel, iT);
                    break;
                case 12:
                    iV3 = SafeParcelReader.v(parcel, iT);
                    break;
                case 13:
                    iV4 = SafeParcelReader.v(parcel, iT);
                    break;
                case 14:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 15:
                    zM2 = SafeParcelReader.m(parcel, iT);
                    break;
                case 16:
                    workSource = (WorkSource) SafeParcelReader.e(parcel, iT, WorkSource.CREATOR);
                    break;
                case 17:
                    zzdVar = (zzd) SafeParcelReader.e(parcel, iT, zzd.CREATOR);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new LocationRequest(iV, jX, jX2, jX3, jX4, jX5, iV2, fR, zM, jX6, iV3, iV4, strF, zM2, workSource, zzdVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationRequest[i];
    }
}
