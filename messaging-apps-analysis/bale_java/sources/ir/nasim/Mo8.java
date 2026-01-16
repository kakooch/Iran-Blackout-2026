package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.phenotype.ExperimentTokens;

/* loaded from: classes3.dex */
public final class Mo8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        String strF = null;
        byte[] bArrB = null;
        byte[][] bArrC = null;
        byte[][] bArrC2 = null;
        byte[][] bArrC3 = null;
        byte[][] bArrC4 = null;
        int[] iArrD = null;
        byte[][] bArrC5 = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 2:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 3:
                    bArrB = SafeParcelReader.b(parcel, iT);
                    break;
                case 4:
                    bArrC = SafeParcelReader.c(parcel, iT);
                    break;
                case 5:
                    bArrC2 = SafeParcelReader.c(parcel, iT);
                    break;
                case 6:
                    bArrC3 = SafeParcelReader.c(parcel, iT);
                    break;
                case 7:
                    bArrC4 = SafeParcelReader.c(parcel, iT);
                    break;
                case 8:
                    iArrD = SafeParcelReader.d(parcel, iT);
                    break;
                case 9:
                    bArrC5 = SafeParcelReader.c(parcel, iT);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new ExperimentTokens(strF, bArrB, bArrC, bArrC2, bArrC3, bArrC4, iArrD, bArrC5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ExperimentTokens[i];
    }
}
