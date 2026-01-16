package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class u implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        boolean zM = false;
        String strF = null;
        IBinder iBinderU = null;
        boolean zM2 = false;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                strF = SafeParcelReader.f(parcel, iT);
            } else if (iL == 2) {
                iBinderU = SafeParcelReader.u(parcel, iT);
            } else if (iL == 3) {
                zM = SafeParcelReader.m(parcel, iT);
            } else if (iL != 4) {
                SafeParcelReader.A(parcel, iT);
            } else {
                zM2 = SafeParcelReader.m(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzs(strF, iBinderU, zM, zM2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzs[i];
    }
}
