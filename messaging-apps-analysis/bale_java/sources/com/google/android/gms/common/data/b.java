package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        int iV2 = 0;
        String[] strArrG = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundleA = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                strArrG = SafeParcelReader.g(parcel, iT);
            } else if (iL == 2) {
                cursorWindowArr = (CursorWindow[]) SafeParcelReader.i(parcel, iT, CursorWindow.CREATOR);
            } else if (iL == 3) {
                iV2 = SafeParcelReader.v(parcel, iT);
            } else if (iL == 4) {
                bundleA = SafeParcelReader.a(parcel, iT);
            } else if (iL != 1000) {
                SafeParcelReader.A(parcel, iT);
            } else {
                iV = SafeParcelReader.v(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        DataHolder dataHolder = new DataHolder(iV, strArrG, cursorWindowArr, iV2, bundleA);
        dataHolder.d0();
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new DataHolder[i];
    }
}
