package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;

/* loaded from: classes3.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        zzr zzrVar = null;
        byte[] bArrB = null;
        int[] iArrD = null;
        String[] strArrG = null;
        int[] iArrD2 = null;
        byte[][] bArrC = null;
        ExperimentTokens[] experimentTokensArr = null;
        boolean zM = true;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 2:
                    zzrVar = (zzr) SafeParcelReader.e(parcel, iT, zzr.CREATOR);
                    break;
                case 3:
                    bArrB = SafeParcelReader.b(parcel, iT);
                    break;
                case 4:
                    iArrD = SafeParcelReader.d(parcel, iT);
                    break;
                case 5:
                    strArrG = SafeParcelReader.g(parcel, iT);
                    break;
                case 6:
                    iArrD2 = SafeParcelReader.d(parcel, iT);
                    break;
                case 7:
                    bArrC = SafeParcelReader.c(parcel, iT);
                    break;
                case 8:
                    zM = SafeParcelReader.m(parcel, iT);
                    break;
                case 9:
                    experimentTokensArr = (ExperimentTokens[]) SafeParcelReader.i(parcel, iT, ExperimentTokens.CREATOR);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zze(zzrVar, bArrB, iArrD, strArrG, iArrD2, bArrC, zM, experimentTokensArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zze[i];
    }
}
