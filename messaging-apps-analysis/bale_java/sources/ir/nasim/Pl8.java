package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.face.internal.client.FaceParcel;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;
import com.google.android.gms.vision.face.internal.client.zza;

/* loaded from: classes3.dex */
public final class Pl8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        int iV2 = 0;
        float fR = 0.0f;
        float fR2 = 0.0f;
        float fR3 = 0.0f;
        float fR4 = 0.0f;
        float fR5 = 0.0f;
        float fR6 = 0.0f;
        float fR7 = 0.0f;
        float fR8 = Float.MAX_VALUE;
        float fR9 = Float.MAX_VALUE;
        float fR10 = Float.MAX_VALUE;
        LandmarkParcel[] landmarkParcelArr = null;
        zza[] zzaVarArr = null;
        float fR11 = -1.0f;
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
                    fR = SafeParcelReader.r(parcel, iT);
                    break;
                case 4:
                    fR2 = SafeParcelReader.r(parcel, iT);
                    break;
                case 5:
                    fR3 = SafeParcelReader.r(parcel, iT);
                    break;
                case 6:
                    fR4 = SafeParcelReader.r(parcel, iT);
                    break;
                case 7:
                    fR8 = SafeParcelReader.r(parcel, iT);
                    break;
                case 8:
                    fR9 = SafeParcelReader.r(parcel, iT);
                    break;
                case 9:
                    landmarkParcelArr = (LandmarkParcel[]) SafeParcelReader.i(parcel, iT, LandmarkParcel.CREATOR);
                    break;
                case 10:
                    fR5 = SafeParcelReader.r(parcel, iT);
                    break;
                case 11:
                    fR6 = SafeParcelReader.r(parcel, iT);
                    break;
                case 12:
                    fR7 = SafeParcelReader.r(parcel, iT);
                    break;
                case 13:
                    zzaVarArr = (zza[]) SafeParcelReader.i(parcel, iT, zza.CREATOR);
                    break;
                case 14:
                    fR10 = SafeParcelReader.r(parcel, iT);
                    break;
                case 15:
                    fR11 = SafeParcelReader.r(parcel, iT);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new FaceParcel(iV, iV2, fR, fR2, fR3, fR4, fR8, fR9, fR10, landmarkParcelArr, fR5, fR6, fR7, zzaVarArr, fR11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new FaceParcel[i];
    }
}
