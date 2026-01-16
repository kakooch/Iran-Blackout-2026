package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import ir.nasim.AbstractC21804u96;

/* loaded from: classes3.dex */
public final class b4 implements Parcelable.Creator {
    static void a(zzkw zzkwVar, Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, zzkwVar.a);
        AbstractC21804u96.t(parcel, 2, zzkwVar.b, false);
        AbstractC21804u96.q(parcel, 3, zzkwVar.c);
        AbstractC21804u96.r(parcel, 4, zzkwVar.d, false);
        AbstractC21804u96.l(parcel, 5, null, false);
        AbstractC21804u96.t(parcel, 6, zzkwVar.e, false);
        AbstractC21804u96.t(parcel, 7, zzkwVar.f, false);
        AbstractC21804u96.j(parcel, 8, zzkwVar.g, false);
        AbstractC21804u96.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        String strF = null;
        Long lY = null;
        Float fS = null;
        String strF2 = null;
        String strF3 = null;
        Double dQ = null;
        long jX = 0;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 1:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 2:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 3:
                    jX = SafeParcelReader.x(parcel, iT);
                    break;
                case 4:
                    lY = SafeParcelReader.y(parcel, iT);
                    break;
                case 5:
                    fS = SafeParcelReader.s(parcel, iT);
                    break;
                case 6:
                    strF2 = SafeParcelReader.f(parcel, iT);
                    break;
                case 7:
                    strF3 = SafeParcelReader.f(parcel, iT);
                    break;
                case 8:
                    dQ = SafeParcelReader.q(parcel, iT);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzkw(iV, strF, jX, lY, fS, strF2, strF3, dQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzkw[i];
    }
}
