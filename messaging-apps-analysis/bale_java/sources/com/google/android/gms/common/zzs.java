package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.CG4;
import ir.nasim.Mv8;
import ir.nasim.XZ2;

/* loaded from: classes3.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new u();
    private final String a;
    private final n b;
    private final boolean c;
    private final boolean d;

    zzs(String str, n nVar, boolean z, boolean z2) {
        this.a = str;
        this.b = nVar;
        this.c = z;
        this.d = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.a;
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.t(parcel, 1, str, false);
        n nVar = this.b;
        if (nVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            nVar = null;
        }
        AbstractC21804u96.m(parcel, 2, nVar, false);
        AbstractC21804u96.c(parcel, 3, this.c);
        AbstractC21804u96.c(parcel, 4, this.d);
        AbstractC21804u96.b(parcel, iA);
    }

    zzs(String str, IBinder iBinder, boolean z, boolean z2) {
        this.a = str;
        o oVar = null;
        if (iBinder != null) {
            try {
                XZ2 xz2D = Mv8.C2(iBinder).d();
                byte[] bArr = xz2D == null ? null : (byte[]) CG4.D2(xz2D);
                if (bArr != null) {
                    oVar = new o(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            }
        }
        this.b = oVar;
        this.c = z;
        this.d = z2;
    }
}
