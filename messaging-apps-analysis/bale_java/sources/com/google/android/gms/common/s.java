package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        boolean zM = false;
        boolean zM2 = false;
        boolean zM3 = false;
        boolean zM4 = false;
        String strF = null;
        IBinder iBinderU = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 1:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 2:
                    zM = SafeParcelReader.m(parcel, iT);
                    break;
                case 3:
                    zM2 = SafeParcelReader.m(parcel, iT);
                    break;
                case 4:
                    iBinderU = SafeParcelReader.u(parcel, iT);
                    break;
                case 5:
                    zM3 = SafeParcelReader.m(parcel, iT);
                    break;
                case 6:
                    zM4 = SafeParcelReader.m(parcel, iT);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzo(strF, zM, zM2, iBinderU, zM3, zM4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
