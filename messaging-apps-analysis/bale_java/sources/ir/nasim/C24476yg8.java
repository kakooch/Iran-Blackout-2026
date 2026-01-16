package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: ir.nasim.yg8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24476yg8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        String strF = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 2) {
                strF = SafeParcelReader.f(parcel, iT);
            } else if (iL != 5) {
                SafeParcelReader.A(parcel, iT);
            } else {
                googleSignInOptions = (GoogleSignInOptions) SafeParcelReader.e(parcel, iT, GoogleSignInOptions.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new SignInConfiguration(strF, googleSignInOptions);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
