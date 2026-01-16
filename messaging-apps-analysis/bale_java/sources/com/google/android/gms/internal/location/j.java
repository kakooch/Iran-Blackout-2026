package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        IBinder iBinderU = null;
        IBinder iBinderU2 = null;
        PendingIntent pendingIntent = null;
        String strF = null;
        String strF2 = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 1:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 2:
                    iBinderU = SafeParcelReader.u(parcel, iT);
                    break;
                case 3:
                    iBinderU2 = SafeParcelReader.u(parcel, iT);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) SafeParcelReader.e(parcel, iT, PendingIntent.CREATOR);
                    break;
                case 5:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 6:
                    strF2 = SafeParcelReader.f(parcel, iT);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzdb(iV, iBinderU, iBinderU2, pendingIntent, strF, strF2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdb[i];
    }
}
