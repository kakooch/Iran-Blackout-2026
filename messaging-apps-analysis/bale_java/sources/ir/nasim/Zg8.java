package ir.nasim;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class Zg8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            if (SafeParcelReader.l(iT) != 1) {
                SafeParcelReader.A(parcel, iT);
            } else {
                intent = (Intent) SafeParcelReader.e(parcel, iT, Intent.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new CloudMessage(intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CloudMessage[i];
    }
}
