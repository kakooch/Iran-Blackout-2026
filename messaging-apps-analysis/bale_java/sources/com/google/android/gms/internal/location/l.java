package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class l implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 1;
        zzdd zzddVar = null;
        IBinder iBinderU = null;
        IBinder iBinderU2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinderU3 = null;
        String strF = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 1:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 2:
                    zzddVar = (zzdd) SafeParcelReader.e(parcel, iT, zzdd.CREATOR);
                    break;
                case 3:
                    iBinderU = SafeParcelReader.u(parcel, iT);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) SafeParcelReader.e(parcel, iT, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinderU2 = SafeParcelReader.u(parcel, iT);
                    break;
                case 6:
                    iBinderU3 = SafeParcelReader.u(parcel, iT);
                    break;
                case 7:
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
                case 8:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzdf(iV, zzddVar, iBinderU, iBinderU2, pendingIntent, iBinderU3, strF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdf[i];
    }
}
