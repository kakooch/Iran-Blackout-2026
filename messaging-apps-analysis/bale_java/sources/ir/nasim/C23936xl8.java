package ir.nasim;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzcl;

/* renamed from: ir.nasim.xl8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C23936xl8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        long jX = 0;
        long jX2 = 0;
        boolean zM = false;
        String strF = null;
        String strF2 = null;
        String strF3 = null;
        Bundle bundleA = null;
        String strF4 = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 1:
                    jX = SafeParcelReader.x(parcel, iT);
                    break;
                case 2:
                    jX2 = SafeParcelReader.x(parcel, iT);
                    break;
                case 3:
                    zM = SafeParcelReader.m(parcel, iT);
                    break;
                case 4:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 5:
                    strF2 = SafeParcelReader.f(parcel, iT);
                    break;
                case 6:
                    strF3 = SafeParcelReader.f(parcel, iT);
                    break;
                case 7:
                    bundleA = SafeParcelReader.a(parcel, iT);
                    break;
                case 8:
                    strF4 = SafeParcelReader.f(parcel, iT);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzcl(jX, jX2, zM, strF, strF2, strF3, bundleA, strF4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcl[i];
    }
}
