package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import ir.nasim.AbstractC25130zm8;
import java.util.List;

/* loaded from: classes3.dex */
public final class m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        List listN = AbstractC25130zm8.N();
        int iV = 0;
        int iV2 = 0;
        int iV3 = 0;
        String strF = null;
        String strF2 = null;
        String strF3 = null;
        zzd zzdVar = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 1:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 2:
                    iV2 = SafeParcelReader.v(parcel, iT);
                    break;
                case 3:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 4:
                    strF2 = SafeParcelReader.f(parcel, iT);
                    break;
                case 5:
                    iV3 = SafeParcelReader.v(parcel, iT);
                    break;
                case 6:
                    strF3 = SafeParcelReader.f(parcel, iT);
                    break;
                case 7:
                    zzdVar = (zzd) SafeParcelReader.e(parcel, iT, zzd.CREATOR);
                    break;
                case 8:
                    listN = SafeParcelReader.j(parcel, iT, Feature.CREATOR);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzd(iV, iV2, strF, strF2, strF3, iV3, listN, zzdVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzd[i];
    }
}
